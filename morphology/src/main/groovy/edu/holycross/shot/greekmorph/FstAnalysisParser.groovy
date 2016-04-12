package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
* Class for parsing structured text output of SFST toolkit's fst-infl.
* Lines beginning with '>' identify surface strings.  Following non-empty
* lines provide underlying analyses.  Lines beginning "No result" identify
* surface strings that could not be identified.
*
* Analyses are composed of a stem component and an inflectional pattern,
* separated by "::"
*/
class FstAnalysisParser {

  Integer debug = 0

  /** UrnManager expands collection abbreviations to full CITE URNs. */
  UrnManager urnMgr

  /** Regex pattern for multicharacter symbols in FST string */
  java.util.regex.Pattern allTags = ~/<[^>]+>/
  /** Regex pattern for analytical symbols in FST string,
  * omitting <#> since that's valid in stem char sequences before we
  * add accent.  */
  java.util.regex.Pattern semanticTags = ~/<[a-z0-9_\.]+>/
  /**Regex pattern for everything to the left of the first URN, inclusive. */
  java.util.regex.Pattern leftmostUrn = ~/.+<\/u>/
  /**Regex pattern for right most URN. */
  java.util.regex.Pattern rightmostUrn = ~/<u>[^<]+<\/u>\s*/


  /** Regex pattern for URN values wrapped in <u>..</u> symbols in FST string */
  java.util.regex.Pattern urnTags = ~/<u>[^<]+<\/u>/

  /// The two halves of the FST output string:
  /** Stem component of FST analysis string.*/
  String stemString
  /** Component of FST analysis string with inflectional pattern.*/
  String inflectionString

  /// Ordered lists of tags in each half of the FST string:
  /** Ordered list of multicharacter symbols in the stem component. */
  ArrayList stemTags = []
  /** Ordered list of multicharacter symbols in the inflectional pattern component. */
  ArrayList inflTags = []

  //// Content extracted from raw FST output string //////////////////
  //
  /** Form of analysis extracted from this string.
  * ("Part of speech")
  */
  AnalyticalType analysisPattern

  /** URN of the lexical entity of the analysis. */
  CiteUrn lexicalEntity

  /** The grammatical form of the analysis */
  MorphForm morphForm

  /** The explanation for the analysis. */
  AnalysisExplanation explanation

  /** Surface string for stem part.*/
  String surfaceStem

  /** Surface string for inflectional part. */
  String surfaceInflection

  String inflectionTag


  /** Multicharacter symbols that can appear in stem strings.  */
  static ArrayList editorialTags = ["<#>", "<lo>", "<sh>", "<ro>", "<sm>"]


  /** Collects the surface representation of the stem string,
  * given the entire stem component of the FST reply.
  * @param stemString Stem component of the FST reply.
  * @returns The literal string value of the stem.
  */
  String formatStemSurface(String stemString){
    String surfaceFormatted =  stemString.replaceFirst("<ro>", "(")
    surfaceFormatted = surfaceFormatted.replaceFirst("<sm>", ")")
    surfaceFormatted = surfaceFormatted.replaceAll(leftmostUrn,"").replaceAll(leftmostUrn,"")
    surfaceFormatted = surfaceFormatted.replaceAll(semanticTags, "")
    return surfaceFormatted
  }

  /** Constructor builds an object representation of the information
  * in  an FST morphological analysis string.
  * @param analysisStr Literal string output of fst-infl.
  * @param umgr A UrnManager configured to resolve abbreviated
  * URNs in this data set.
  */
  FstAnalysisParser(String analysisStr, UrnManager umgr) {
      this.urnMgr = umgr
      def cols = analysisStr.split(/::/)
      if (cols.size() != 2) {
        throw new Exception("FstAnalysisParser: could not parse ${analysisStr}")
      }
      // check that strings are not null before doing findAll?
      stemString = cols[0]
      stemTags = stemString.findAll(allTags)
      def stemUrns = stemString.findAll(urnTags)

      inflectionString = cols[1]
      inflTags = inflectionString.findAll(allTags)
      def inflUrns = inflectionString.findAll(urnTags)

      //  check size before indexing...
      String stemAbbrUrn = stemUrns[0].replaceFirst('<u>',"").replaceFirst('</u>',"")
      String lexEntAbbrUrn = stemUrns[1].replaceFirst('<u>',"").replaceFirst('</u>',"")
      String inflAbbrUrn =  inflUrns[0].replaceFirst('<u>',"").replaceFirst('</u>',"")

      String stemUrnStr = resolveUrn(stemAbbrUrn)
      String lexEntUrnStr = resolveUrn(lexEntAbbrUrn)
      String inflUrnStr = resolveUrn(inflAbbrUrn)

       if (debug > 0 ) {
         System.err.println "FstAP: analyze as URNs:"
         System.err.println "\tLex Ent urn str" + lexEntUrnStr
         System.err.println "\tStem urn str " + stemUrnStr
         System.err.println "\tInfl urn str " + inflUrnStr
         System.err.println "Check 1st infl tag : " + inflTags[0]

         System.err.println "All stem tags: " + stemTags
         System.err.println "All infl tags: " + inflTags
       }

       this.inflectionTag = inflTags[0].replaceFirst(">","").replaceFirst("<","")
       this.lexicalEntity = new CiteUrn(lexEntUrnStr)

       CiteUrn stem = new CiteUrn(stemUrnStr)
       CiteUrn inflectionalPattern  = new CiteUrn(inflUrnStr)
       this.explanation = new AnalysisExplanation(stem, inflectionalPattern)

       // Second tag in inflectional pattern must be "part of speech", unless overriden:
       if (stemTags[4] == "<pron>") {
	 System.err.println "Pronoun analytical type ovverides adje"
	 analysisPattern = AnalyticalType.getByToken("<pron>")
	 System.err.println "yielding pattern "  + analysisPattern
       } else {
	 analysisPattern = AnalyticalType.getByToken(inflTags[1])
       }
       if (debug > 0) { System.err.println "For ${inflTags[1]}, analysisPattern was " + analysisPattern }


      if (debug > 0) { System.err.println "Compute morph form"}
      morphForm = computeMorphForm()


      surfaceStem =  formatStemSurface(stemString)
      // Strip out all tags from surface form except <#>
      if (debug > 0) { System.err.println "RAW MORPHFORM has surface " + stemString + "-" + inflectionString}

      surfaceInflection = inflectionString.replaceAll(rightmostUrn,"").replaceAll(semanticTags, "")






  }


  /** Expands an abbreviated reference to a full URN string.
  * @param s String in format Collection.Object
  * @returns A String that validates as a CiteUrn.
  * @throws Exception if s is not formatted properly, or if
  * cannot resolve s to a URN.
  */
  String resolveUrn(String s) {
    String objectStr = s.replaceAll(/[<>]/,"")
    def refParts = objectStr.split(/\./)
    if  (refParts.size() != 2) {
      throw new Exception ("FAP: can't resolve URN from ${s} with parts ${refParts}")
    }
    try {
      String urnStr =  urnMgr.getUrn(refParts[0]).toString() + "." + refParts[1]
      return urnStr
    } catch(Exception e) {
      System.err.println "FstAnalysisParser: failed to get urn for ${s}"
      throw e
    }
  }

  /** Creates a MorphForm object from tags in the FST analysis string.
  *  The first two tokens in inflection tags are always inflectional type
  * and part of speech, so we always start type-specific handling with the
  * third item in the array of inflection tags.
  */
  MorphForm computeMorphForm() {
    MorphForm mf  = null
    if (debug > 0)  { System.err.println "Analysis patterns: " + analysisPattern}
    switch (analysisPattern) {
      case AnalyticalType.CVERB:
      //System.err.println "HERE ARE ALL INFL TAGS FOR A CVERB: " + inflTags
//<w_regular>, <verb>, <3rd>, <pl>, <pres>, <indic>, <act>
      Person person = Person.getByToken(inflTags[2])
      GrammaticalNumber num = GrammaticalNumber.getByToken(inflTags[3])
      Tense tense = Tense.getByToken(inflTags[4])
      Mood mood = Mood.getByToken(inflTags[5])
      Voice voice = Voice.getByToken(inflTags[6])
      VerbForm verb = new VerbForm(person, num, tense, mood, voice)
      mf = new MorphForm(analysisPattern, verb)
      break


      case AnalyticalType.NOUN:
      Gender gender
      GrammaticalCase cas
      GrammaticalNumber num
      PersistentAccent accent
      if (inflTags[0] == "<irregnoun>") {
	// then inflectional data is actually stored in lexicon:
	System.err.println "Irregnoun stem tags: " + stemTags
	gender = Gender.getByToken(stemTags[4])
	cas = GrammaticalCase.getByToken(stemTags[5])
	num = GrammaticalNumber.getByToken(stemTags[6])
	accent = PersistentAccent.getByToken("<irregacc>")
	
      } else {
	gender = Gender.getByToken(inflTags[2])
	cas = GrammaticalCase.getByToken(inflTags[3])
	num = GrammaticalNumber.getByToken(inflTags[4])
	// Persistent accent is recorded  as last item in stem data:
	Integer lastTag = stemTags.size() - 1
	accent = PersistentAccent.getByToken(stemTags[lastTag])
      }
      NounForm noun = new NounForm(gender, cas, num, accent)
      mf = new MorphForm(analysisPattern, noun)
      break

      case AnalyticalType.INDECLINABLE:
      //System.err.println "HERE ARE ALL INFL TAGS FOR AN INDECLINABLE: " + inflTags

      Integer lastTag = stemTags.size() - 1
      PersistentAccent accent = PersistentAccent.getByToken(stemTags[lastTag])
      mf = new MorphForm(analysisPattern,new IndeclinableForm())
      break

      case AnalyticalType.ADJECTIVE:
      Integer lastTag = stemTags.size() - 1
      PersistentAccent accent = PersistentAccent.getByToken(stemTags[lastTag])
      // gender,case,number,degree:
      Gender gender = Gender.getByToken(inflTags[2])
      GrammaticalCase cas = GrammaticalCase.getByToken(inflTags[3])
      GrammaticalNumber num = GrammaticalNumber.getByToken(inflTags[4])
      Degree degr = Degree.getByToken(inflTags[5])
      mf = new MorphForm(analysisPattern, new AdjectiveForm(gender, cas,num,degr,accent))
      break

      case AnalyticalType.INFINITIVE:
        Tense t = Tense.getByToken(inflTags[2])
        Voice v = Voice.getByToken(inflTags[3])
        mf = new MorphForm(analysisPattern, new InfinitiveForm(t,v))
      break


      case AnalyticalType.PARTICIPLE:
      //System.err.println "HERE ARE ALL INFL TAGS FOR AN PTCPL: " + inflTags
        //[<w_regular>, <ptcpl>, <masc>, <nom>, <sg>, <pres>, <act>,
        Gender gender = Gender.getByToken(inflTags[2])
        GrammaticalCase cas = GrammaticalCase.getByToken(inflTags[3])
        GrammaticalNumber num = GrammaticalNumber.getByToken(inflTags[4])
        Tense tense = Tense.getByToken(inflTags[5])
        Voice voice = Voice.getByToken(inflTags[6])
        mf = new MorphForm(analysisPattern, new ParticipleForm(tense,voice,gender,cas,num))
        break

      case AnalyticalType.VERBAL_ADJECTIVE:
      //System.err.println "HERE ARE ALL INFL TAGS FOR AN VADJ: " + inflTags
      Gender gender = Gender.getByToken(inflTags[2])
      GrammaticalCase cas = GrammaticalCase.getByToken(inflTags[3])
      GrammaticalNumber num = GrammaticalNumber.getByToken(inflTags[4])
      mf = new MorphForm(analysisPattern, new VerbalAdjectiveForm(gender, cas, num))
      break

      case AnalyticalType.ADVERB:
      //<os_h_on>, <adv>, <pos>
      //System.err.println "HERE ARE ALL INFL TAGS FOR AN ADV: " + inflTags
      Integer lastTag = stemTags.size() - 1
      PersistentAccent accent = PersistentAccent.getByToken(stemTags[lastTag])


      Degree deg = Degree.getByToken(inflTags[2])
      mf = new MorphForm(analysisPattern, new AdverbForm(deg, accent))
      break

    case AnalyticalType.PRONOUN:
    Integer lastTag = stemTags.size() - 1
    PersistentAccent accent = PersistentAccent.getByToken(stemTags[lastTag])
    
    //System.err.println "HERE ARE ALL INFL TAGS FOR A PRON: " + inflTags

    Gender gender = Gender.getByToken(inflTags[2])
    GrammaticalCase cas = GrammaticalCase.getByToken(inflTags[3])
    GrammaticalNumber num = GrammaticalNumber.getByToken(inflTags[4])
    mf = new MorphForm(analysisPattern, new PronounForm(gender, cas,num,accent))
    break
    
      default:
      System.err.println "FAP: Unimplemented analytical type: " + analysisPattern
      break

    }
    return mf
  }

  /** Gets a human-readable presentation of surface form.
  * @returns String formatted as STEM-INFLECTION with morpheme
  * boundary markers are stripped out.
  */
  String getSurface() {
    return surfaceStem.replaceFirst(/<#>/,"") + "-" + surfaceInflection
  }


  /** Finds accentuation for this ID.  When accent is not explicitly
  * given by a FST multicharacter symbol, it is treated as recessive.
  * @returns Appropriate PersistentAccent object.
  */
  PersistentAccent getAccent() {
    System.err.println "FstAnalysisParser:getAccentTag: not yet implemented."
    return null
  }

  AnalysisTriple getTriple() {
    return new AnalysisTriple(lexicalEntity, morphForm, explanation)
  }


  String toString() {
    return "${surfaceStem}-${surfaceInflection} < ${lexicalEntity} ${morphForm}"
  }

}
