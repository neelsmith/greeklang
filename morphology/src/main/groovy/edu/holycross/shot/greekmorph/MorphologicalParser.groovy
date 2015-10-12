package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString

/**
* A Greek morphological parser.
*/
class MorphologicalParser {

  Integer debug  = 1

  /** Implementation of accent-free Greek morphology
  * in a finite state transducer. */
  FstParser fstParser

  UrnManager urnManager

  /** Constructor with location of sfst binary.
  * @param Full path to binary sfst (.a) file
  */
  MorphologicalParser(String fstBinary, UrnManager umgr) {
    fstParser = new FstParser(fstBinary)
    urnManager = umgr
  }


  // TO BE IMPLEMENTED.  GENERATE ACCENTED FORM AND COMPARE TO SUBMITTED FORM.
  boolean checkAccent(GreekString utf8String, FstAnalysisParser analysisInfo) {
    return true
  }

  /** Gets a morphological analysis for a greek string.
  * @param gkStr The string to analyze.
  * @returns a MorphologicalAnalysis.
  */
  MorphologicalAnalysis parseGreekString(GreekString gkStr) {
    ArrayList analysisList  = []
    ArrayList explanationList = []

    FstToken fstToken = new FstToken(gkStr)
    if (debug > 0) {System.err.println "MorphologicalAnalysis: submit ${fstToken}"}
    String parseOutput = fstParser.parseToken(fstToken)
    parseOutput.eachLine { l ->
      if (l[0] == ">") {
        // omit
      } else if (l ==~ /[Nn]o result.+/) {
        // omit
      } else {
        FstAnalysisParser fsp = new FstAnalysisParser(l, urnManager)
        if (checkAccent(gkStr,fsp)) {
          analysisList.add(fsp.getMorphForm())
          explanationList.add(fsp.getExplanation())
        }
      }
    }
    return( new MorphologicalAnalysis(gkStr, analysisList, explanationList))
  }

}
