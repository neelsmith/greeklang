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

  /** Stem part of surface string */
  String surfaceStem

  /** Inflectional part of surface string */
  String surfaceInflection

  static ArrayList editorialTags = ["<#>", "<lo>", "<sh>", "<ro>", "<sm>"]

  /** Constructor builds an object representation of information in a morphological
  * analysis from an FST analysis string.
  * @param analysisStr Output of fst-infl.
  */
  FstAnalysisParser(String analysisStr, UrnManager umgr) {
      this.urnMgr = umgr
      def cols = analysisStr.split(/::/)
      if (cols.size() != 2) {
        throw new Exception("FstAnalysisParser: could not parse ${analysisStr}")
      }
      stemString = cols[0]
      inflectionString = cols[1]
      if (debug > 1) {
        System.err.println "FstAP: Analyzing " + analysisStr
        System.err.println "Preparing to compute parts with\t stemstr ${stemString}\n\tinfl string ${inflectionString}"
      }

      // Before doing this, extract URNs from stem.
      //STEM: <u>coretests.n67485_0</u><u>lexent.n67485</u>mhn<noun><fem><is_ios>
      //NOUNINFL: <is_ios>is<fem><nom><sg><u>is_ios.1</u>
      def stemUrns = stemString.findAll(urnTags)
      //  check size ...
      String stemAbbrUrn = stemUrns[0].replaceFirst('<u>',"").replaceFirst('</u>',"")
      String inflAbbrUrn = stemUrns[1].replaceFirst('<u>',"").replaceFirst('</u>',"")

      stemUrns = stemString.findAll(urnTags)
      // check that strings are not null before doing findAll
      stemTags = stemString.findAll(allTags)
      inflTags = inflectionString.findAll(allTags)

      String stemUrnStr = resolveUrn(stemAbbrUrn)
      String lexEntUrnStr = resolveUrn(inflAbbrUrn)
      String inflUrnStr = resolveUrn(inflTags[1])

       if (debug > 0 ) {
         System.err.println "FstAP: analyze as URNs:"
         System.err.println "\tLex Ent urn str" + lexEntUrnStr
         System.err.println "\tStem urn str " + stemUrnStr
         System.err.println "\tInfl urn str " + inflUrnStr
       }

       lexicalEntity = new CiteUrn(lexEntUrnStr)
       CiteUrn stem = new CiteUrn(stemUrnStr)
       CiteUrn inflectionalPattern  = new CiteUrn(inflUrnStr)

       explanation = new AnalysisExplanation(stem, inflectionalPattern)
       // Verbs include a morpheme boundary marker <#>, and have
       // "part of speech" in tag 3.  Other types have part of speech
       // in tag 2.
       //
       // analysisPattern must be defined before invoking computeMorphForm()

       // Need to read past editorial symbols:

       boolean posFound = false
       Integer idx = 2
       while ((idx < stemTags.size()) && (! posFound)) {
         if (editorialTags.contains(stemTags[idx])) {
           idx++
         } else if (stemTags[idx] == "<noun>") {
           analysisPattern = AnalyticalType.getByToken(stemTags[idx])
           posFound = true
         } else {
           //...
         }

       }

       /*
      if (stemTags[2] != "<#>") {
        analysisPattern = AnalyticalType.getByToken(stemTags[2])
      } else {
        if (["<infin>", "<ptcpl>","<vadj>"].contains(inflTags[1])) {
          analysisPattern = AnalyticalType.getByToken(inflTags[1])
        } else {
          analysisPattern = AnalyticalType.CVERB
        }
      }*/
      morphForm = computeMorphForm()

      surfaceStem = stemString.replaceAll(semanticTags, "")
      surfaceInflection = inflectionString.replaceAll(semanticTags, "")

      // Example of conjugated verb:  "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
      // Example of compound form with quantity symbol:
      //  "<coretests.n6949_0><lexent.n6949>a<sm>na<#>lus<lo><verb><w_regular>
      // ::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
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
  */
  MorphForm computeMorphForm() {
    MorphForm mf  = null
    switch (analysisPattern) {
      case AnalyticalType.CVERB:
      if (debug > 1) {
        System.err.println "FAP creating MorphForm wth inflTags ${inflTags} from inflectionSTring ${inflectionString}"
      }
      Person person = Person.getByToken(inflTags[2])
      GrammaticalNumber num = GrammaticalNumber.getByToken(inflTags[3])
      Tense tense = Tense.getByToken(inflTags[4])
      Mood mood = Mood.getByToken(inflTags[5])
      Voice voice = Voice.getByToken(inflTags[6])
      VerbForm verb = new VerbForm(person, num, tense, mood, voice)
      mf = new MorphForm(analysisPattern, verb)
      break

      default:
      System.err.println "Unimplemented analytical type: " + analysisPattern
      break
      return mf
    }
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
  * @returns Appropriate AccentTag object.
  */
  AccentTag getAccentTag() {
    System.err.println "FstAnalysisParser:getAccentTag: not yet implemented."
    return null
  }



}
