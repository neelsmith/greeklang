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

  // These should be dynamically acquired from a URN registry:
  String stemUrnBase = "urn:cite:morph:"
  String inflUrnBase = "urn:cite:morph:"
  String lexEntUrnBase = "urn:cite:shot:"

  /// The two halves of the FST output string:
  /** Stem component of FST analysis string.*/
  String stemString
  /** Component of FST analysis string with inflectional pattern.*/
  String inflectionString


  /** Form of analysis to extract from this string.
  * ("Part of speech")
  */
  AnalyticalType analysisPattern

  //// Content extracted from raw FST output string
  /** URN of the lexical entity of the analysis. */
  CiteUrn lexicalEntity

  /** The grammatical form of the analysis */
  MorphForm morphForm

  /** The explanation for the analysis. */
  AnalysisExplanation explanation



  /** Ordered list of multicharacter symbols in the stem component. */
  ArrayList stemTags = []
  /** Ordered list of multicharacter symbols in the inflectional pattern component. */
  ArrayList inflTags = []

  /** Constructor determines the analytical pattern for the analysis string.
  * @param analysisStr Output of fst-infl.
  */
  FstAnalysisParser(String analysisStr) {
      def cols = analysisStr.split(/::/)
      stemString = cols[0]
      inflectionString = cols[1]

      // check that strings are not null before doing findAll
       stemTags = stemString.findAll(/<[^>]+>/)
       inflTags = inflectionString.findAll(/<[^>]+>/)

       String lexEntUrnStr = lexEntUrnBase + stemTags[1].replaceAll(/[<>]/,"")
       System.err.println "Lex Ent urn str" + lexEntUrnStr
       lexicalEntity = new CiteUrn(lexEntUrnStr)

       String stemUrnStr = stemUrnBase + stemTags[0].replaceAll(/[<>]/,"")
       System.err.println "Stem urn str " + stemUrnStr
       CiteUrn stem = new CiteUrn(stemUrnStr)

       String inflUrnStr = inflUrnBase + inflTags[1].replaceAll(/[<>]/,"")
       System.err.println "Infl urn str " + inflUrnStr
       CiteUrn inflectionalPattern  = new CiteUrn(inflUrnStr)

       explanation = new AnalysisExplanation(stem, inflectionalPattern)

      if (stemTags[2] != "<#>") {
        analysisPattern = AnalyticalType.getByToken(stemTags[2])
      } else {
        if (["<infin>", "<ptcpl>","<vadj>"].contains(inflTags[1])) {
          analysisPattern = AnalyticalType.getByToken(inflTags[1])
        } else {
          analysisPattern = AnalyticalType.CVERB
        }
      }
      morphForm = computeMorphForm()
      //  "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
  }


  /** Creates a MorphForm object
  */
  MorphForm computeMorphForm() {
    MorphForm mf  = null
    //AnalyticalType analyticalType = AnalyticalType.getByToken(analysisPattern)
    switch (analysisPattern) {
      case AnalyticalType.CVERB:
      def person = Person.getByToken(inflTags[2])
      def num = GrammaticalNumber.getByToken(inflTags[3])
      def tense = Tense.getByToken(inflTags[4])
      def mood = Mood.getByToken(inflTags[5])
      def voice = Voice.getByToken(inflTags[6])
      VerbForm verb = new VerbForm(person, num, tense, mood, voice)
      mf = new MorphForm(analysisPattern, verb)
      break

      default:
      System.err.println "Unimplemented analytical type: " + analyticalType
      break
      return mf
    }
  }


  String getAccentTag() {

  }



}
