package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString

/**
* A Greek morphological parser.
*/
class MorphologicalParser {

  /** Implementation of accent-free Greek morphology
  * in a finite state transducer. */
  FstParser fstParser

  /** Constructor with location of sfst binary.
  * @param Full path to binary sfst (.a) file
  */
  MorphologicalParser(String fstBinary) {
    fstParser = new FstParser(fstBinary)
  }

  /** Gets a morphological analysis for a greek string.
  * @param gkStr The string to analyze.
  * @returns a MorphologicalAnalysis.
  */
  MorphologicalAnalysis parseGreekString(GreekString gkStr) {
    ArrayList analysisList  = []
    ArrayList explanationList = []

    FstToken fstToken = new FstToken(gkStr)
    String parseOutput = fstParser.parseToken(fstToken)
    parseOutput.eachLine { l ->
      if (l[0] == ">") {
        // omit
      } else if (l ==~ /No result.+/) {
        // omit
      } else {
        FstAnalysisParser fsp = new FstAnalysisParser(l)
        analysisList.add(fsp.getMorphForm())
        explanationList.add(fsp.getExplanation())
      }
    }
    return( new MorphologicalAnalysis(gkStr, analysisList, explanationList))
  }

}
