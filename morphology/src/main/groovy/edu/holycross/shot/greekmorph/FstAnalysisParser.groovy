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


  /** Stem component of FST analysis string.*/
  String stemString
  /** Component of FST analysis string with inflectional pattern.*/
  String inflectionString

  /** String codes identifying the analytical pattern to apply to
  * FST analytical string. */
  String analysisPattern

  /*
  String lexicalEntity
  String stem // urn for stem
  String inflectionalPattern
*/

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
       
       /*
      stem = stemTags[0]
      lexicalEntity = stemTags[1]
      inflectionalPattern  = inflTags[1]
      */
      if (stemTags[2] != "<#>") {
        analysisPattern = stemTags[2]
      } else {
        if (["<infin>", "<ptcpl>","<vadj>"].contains(inflTags[1])) {
          analysisPattern = inflTags[1]
        } else {
          analysisPattern = "<verb>"
        }
      }

      //  "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
  }


  /** Creates a MorphForm object
  */
  MorphForm getMorphForm() {
    MorphForm mf  = null
    AnalyticalType analyticalType = AnalyticalType.getByToken(analysisPattern)
    switch (analysisPattern) {
      case "<verb>":
      def person = Person.getByToken(inflTags[2])
      def num = GrammaticalNumber.getByToken(inflTags[3])
      def tense = Tense.getByToken(inflTags[4])
      def mood = Mood.getByToken(inflTags[5])
      def voice = Voice.getByToken(inflTags[6])
      VerbForm verb = new VerbForm(person, num, tense, mood, voice)
      mf = new MorphForm(analyticalType, verb)
      break

      default:
      System.err.println "Unimplemented analytical type: " + analyticalType
      break
      return mf
    }
  }

  CiteUrn getLexicalEntityUrn() {

  }
  CiteUrn getStemUrn() {

  }
  CiteUrn getInflectionalPatternUrn() {}


}
