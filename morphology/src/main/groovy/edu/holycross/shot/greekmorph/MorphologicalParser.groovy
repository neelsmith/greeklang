package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString
import edu.harvard.chs.cite.CiteUrn
import edu.harvard.chs.cite.CtsUrn

/** A Greek morphological parser.
*/
class MorphologicalParser {

  Integer debug  = 0

  /** Implementation of accent-free Greek morphology
  * in a finite state transducer. */
  FstParser fstParser

  /** Manager for expanding collection IDs to full CITE URNs. */
  UrnManager urnManager

  /** Constructor with location of sfst binary and
  * a system for expanding abbreviated URN references.
  * @param fstBinary Full path to binary sfst (.a) file.
  * @param umgr UrnManager configured for collections cited
  * in stem lexica for this corpus.
  */
  MorphologicalParser(String fstBinary, UrnManager umgr) {
    fstParser = new FstParser(fstBinary)
    urnManager = umgr
  }


  // TO BE IMPLEMENTED.  GENERATE ACCENTED FORM AND COMPARE TO SUBMITTED FORM.
  /** NOT YET IMPLEMENTED */
  boolean checkAccent(GreekString utf8String, FstAnalysisParser analysisInfo) {
    
    return true
  }

  /** Gets a morphological analysis for a Greek string.
  * @param gkStr The string to analyze.
  * @returns A MorphologicalAnalysis.
  */
  MorphologicalAnalysis parseGreekString(GreekString gkStr) {
    ArrayList analysisList  = []


    FstToken fstToken = new FstToken(gkStr)
    if (debug > 0) {System.err.println "MorphologicalAnalysis: submit ${fstToken}"}
    String parseOutput = fstParser.parseToken(fstToken)
    parseOutput.eachLine { l ->
      if (l[0] == ">") {
        // omit
      } else if (l ==~ /[Nn]o result.+/) {
        // omit
      } else {
        FstAnalysisParser fap = new FstAnalysisParser(l, urnManager)
        if (checkAccent(gkStr,fap)) {
          analysisList.add(fap.getTriple())
        }
      }
    }
    return( new MorphologicalAnalysis(gkStr, analysisList))
  }

  String toRdf(GreekString gkStr, CtsUrn ctsUrn) {

  }


}
