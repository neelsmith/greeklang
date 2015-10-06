package edu.holycross.shot.fstio

/**
* Class for parsing output of SFST toolkit's fst-infl parser.
*/
class FstAnalysisParser {


  String stemString
  String inflectionString

  // all URNs, really
  String lexicalEntity
  String stem
  String inflectionalPattern
  String pos
  // to derive from tags:
  String morphAnalysis
  //
  def stemTags
  def inflTags


  // move this into separate abstract class...

  def pers = ["<1st>": 0]
  def num = ["<sg>": 0]
  def tense = ["<pres>": 0]
  def mood = ["<indic>": 0]
  def voice = ["<act>": 0]


  /** Constructor. */
  FstAnalysisParser(String analysisStr) {
      def cols = analysisStr.split(/::/)
      stemString = cols[0]
      inflectionString = cols[1]
      // check that strings are not null before doing findAll
       stemTags = stemString.findAll(/<[^>]+>/)
       inflTags = inflectionString.findAll(/<[^>]+>/)

      stem = stemTags[0]
      lexicalEntity = stemTags[1]
      inflectionalPattern  = inflTags[1]
      if (stemTags[2] != "<#>") {
        pos = stemTags[2]
      } else {
        if (["<infin>", "<ptcpl>","<vadj>"].contains(inflTags[1])) {
          pos = inflTags[1]
        } else {
          pos = "<verb>"
        }
      }
      morphAnalysis = computeMorphAnalysis()
      //  "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
  }

  String computeMorphAnalysis() {
    String urnBase = "urn:cite:morph:form"
    switch (pos) {
      case "<verb>":
      System.err.println "Analyze verb"
      // check size of inflTags...
      return "${urnBase}.cv" + pers[inflTags[2]] + num[inflTags[3]] + tense[inflTags[4]] + mood[inflTags[5]] + voice[inflTags[6]]
      break

      default:
      System.err.println "Don't know how to parse PoS " + pos
      break
    }
  }



}
