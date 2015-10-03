package edu.holycross.shot.fstio

/**
* Class for parsing output of SFST toolkit's fst-infl parser.
*/
class FstAnalysisParser {


  String stem
  String inflection

  /** Constructor. */
  FstAnalysisParser(String analysisStr) {
      def cols = analysisStr.split(/::/)
      stem = cols[0]
      inflection = cols[1]
    // do nothing
  }

}
