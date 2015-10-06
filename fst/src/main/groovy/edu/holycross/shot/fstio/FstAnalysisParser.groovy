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


  /** Constructor. */
  FstAnalysisParser(String analysisStr) {
      def cols = analysisStr.split(/::/)
      stemString = cols[0]
      inflectionString = cols[1]
      // check that strings are not null before doing findAll
      def stemTags = stemString.findAll(/<[^>]+>/)
      def infTags = inflectionString.findAll(/<[^>]+>/)

      stem = stemTags[0]
      lexicalEntity = stemTags[1]
      inflectionalPattern  = infTags[1]
      if (stemTags[2] != "<#>") {
        pos = stemTags[2]
      } else {
        if (["<infin>", "<ptcpl>","<vadj>"].contains(infTags[1])) {
          pos = infTags[1]
        } else {
          pos = "<verb>"
        }
      }

      //  "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
  }

}
