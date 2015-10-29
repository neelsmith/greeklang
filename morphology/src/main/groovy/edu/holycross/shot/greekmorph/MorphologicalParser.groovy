package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString
import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.phonology.Accent
import edu.holycross.shot.phonology.AccentPattern
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
    // depends on type of analysis.
    // with only a handful of exceptions, conjugated verbs are recessive.
    // nouns have persistent accent property to consider.
    GreekWord unaccented = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())
    GreekWord accented
    AnalysisTriple triple = analysisInfo.getTriple()
    MorphForm form = triple.getMorphForm()
    switch (form.getAnalyticalType()) {
      case AnalyticalType.NOUN:
      NounForm nounAnalysis = form.getAnalysis()
      //System.err.println "Decide about ${unaccented} with pers.acc. " + nounAnalysis.getPersistentAccent()

      switch (nounAnalysis.getPersistentAccent()) {
        case PersistentAccent.STEM_PENULT:
        accented = Accent.accentWord(unaccented, AccentPattern.RECESSIVE)
        System.err.println "Compare accented ${accented} with source ${utf8String}"
        break
        case PersistentAccent.STEM_ULTIMA:
        accented = Accent.accentWord(unaccented, AccentPattern.PENULT)
        System.err.println "Compare accented ${accented} with source ${utf8String}"
        break
      }
      break

      default:
      System.err.println "MorphologicalParser: analytical type ${triple.morphForm.getAnalyticalType()} not yet implemented"
      break
    }

    return (accented.toString() == utf8String.toString())
  }

  /** Gets a morphological analysis for a Greek string.
  * @param gkStr The string to analyze.
  * @returns A MorphologicalAnalysis.
  */
  MorphologicalAnalysis parseGreekString(GreekString gkStr) {
    ArrayList analysisList  = []
    System.err.println "Parsing " + gkStr

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
