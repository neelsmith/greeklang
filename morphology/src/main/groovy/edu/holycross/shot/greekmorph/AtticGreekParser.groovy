package edu.holycross.shot.greekmorph

import edu.holycross.shot.attic.AtticString
import edu.holycross.shot.orthography.GreekOrthography
import edu.holycross.shot.phonology.Accent
import edu.holycross.shot.phonology.AccentPattern
import edu.holycross.shot.phonology.Syllable
import edu.harvard.chs.cite.CiteUrn
import edu.harvard.chs.cite.CtsUrn

/** A Greek morphological parser.
*/
class AtticGreekParser implements GreekParser {

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
  AtticGreekParser(String fstBinary, UrnManager umgr) {
    fstParser = new FstParser(fstBinary)
    urnManager = umgr
  }

  MorphologicalAnalysis parseGreekString(GreekOrthography gkStr) {
    return parseGreekString(gkStr, true)
  }
  MorphologicalAnalysis parseGreekString(AtticString gkStr, boolean includeAccent) {
    ArrayList analysisList  = []
    if (debug > 0) {System.err.println "Parsing " + gkStr}
    FstToken fstToken = new FstToken(gkStr)
    if (debug > 0) {System.err.println "MorphologicalAnalysis: submit ${fstToken}"}
    // bad sig!
    String parseOutput = fstParser.parseToken(fstToken)
    if (debug > 0) {System.err.println "MorphologicalAnalysis: got ${parseOutput}"}
    parseOutput.eachLine { l ->
      if (l[0] == ">") {
        // omit
      } else if (l ==~ /[Nn]o result.+/) {
        // omit
      } else {
        FstAnalysisParser fap = new FstAnalysisParser(l, urnManager)
        if (debug > 0) {System.err.println "parse with FAP: " + fap}
        if (includeAccent) {
          if (checkAccent(gkStr,fap)) {
            analysisList.add(fap.getTriple())
          } else {
            if (debug > 0) {
              System.err.println "Reject ${gkStr}"
            }
          }
        } else {
          analysisList.add(fap.getTriple())
        }
      }
    }
    return( new MorphologicalAnalysis(gkStr, analysisList))
  }

  boolean	checkAccent(AtticString utf8String, FstAnalysisParser analysisInfo) {
    return true
  }
/*
// checkAccent
addNounUltima(edu.holycross.shot.orthography.GreekWord gw, NounForm nounForm, java.lang.String inflectionClass)
boolean	checkAccent(edu.holycross.shot.orthography.GreekString utf8String, FstAnalysisParser analysisInfo)
boolean	checkNounAccent(edu.holycross.shot.orthography.GreekString gs, FstAnalysisParser analysisInfo)
boolean	isFirstDeclension(java.lang.String inflectionClass)
boolean	isSecondDeclension(java.lang.String inflectionClass)
MorphologicalAnalysis	parseGreekString(edu.holycross.shot.orthography.GreekString gkStr)
*/
}
