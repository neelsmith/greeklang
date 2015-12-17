package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString
import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.phonology.Accent
import edu.holycross.shot.phonology.AccentPattern
import edu.harvard.chs.cite.CiteUrn
import edu.harvard.chs.cite.CtsUrn

/** A Greek morphological parser.
*/
class LiteraryGreekParser {

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
  LiteraryGreekParser(String fstBinary, UrnManager umgr) {
    fstParser = new FstParser(fstBinary)
    urnManager = umgr
  }


  boolean isFirstDeclension(String inflectionClass) {
    switch (inflectionClass) {
      case "h_hs":
      return true
      break

      default:
      return false
      break
    }
  }
  boolean isSecondDeclension(String inflectionClass) {
    switch (inflectionClass) {
      case "os_ou":
      return true
      break
      default:
      return false
      break
    }
  }
  GreekWord addNounUltima(GreekWord gw, NounForm nounForm, String inflectionClass) {

    def syllables = gw.getSyllables()
    Integer lastIndex = syllables.size() - 1
    String lastSyll = syllables[lastIndex]

    // need to know form!
    // for nouns:  oblique are =, nom/acc are /
    /* - Final -αι -οι are normally short , but are LONG IN OPTATIVE and in locative οἴκοι (S. 169)

    1. Accent is generally *persistent* (Smyth 205)
    2. First, second decl. oxytone:  perispomenon in gen, dat
    3. First decl:  all gen plural are perispomenon

    */

    if ((isFirstDeclension(inflectionClass)) || (isSecondDeclension(inflectionClass)) ) {
      switch (nounForm.cas) {
        case GrammaticalCase.GENITIVE:
        case GrammaticalCase.DATIVE:
        syllables[lastIndex] = Accent.accentSyllable(lastSyll, "=")
        break
        default :
        syllables[lastIndex] = Accent.accentSyllable(lastSyll, "/")
        break
      }

    }

    /*
    Third declension is complicated
    */
    GreekWord resultWord = new GreekWord(syllables.join(""))
    return  resultWord
  }



  boolean checkNounAccent(GreekString gs, FstAnalysisParser analysisInfo) {
    // Add accent to unaccented form based on analysisInfo.
    // Method is true if accented form we create matches gs.
    GreekWord accented
    GreekWord unaccented = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())


    AnalysisTriple triple = analysisInfo.getTriple()
    MorphForm form = triple.getMorphForm()
    NounForm nounAnalysis = form.getAnalysis()
    String inflectionTag = analysisInfo.getInflectionTag()
    if (debug > 0) {
      System.err.println "Checking noun w  persistent accent " + nounAnalysis.getPersistentAccent()
    }

    if ( (isFirstDeclension(inflectionTag) ) &&
	 (nounAnalysis.cas == GrammaticalCase.GENITIVE) &&
	 (nounAnalysis.num == GrammaticalNumber.PLURAL)
       ) {
      if (debug > 1) {System.err.println "Special treatment for 1st decl  ${nounAnalysis.cas}  ${nounAnalysis.num}"}
      accented = addNounUltima(unaccented, nounAnalysis, analysisInfo.getInflectionTag())

    } else {
      if ( (isFirstDeclension(inflectionTag)) || (isSecondDeclension(inflectionTag))) {
        if (debug > 0) {System.err.println "NOT gen.pl., so look at " + nounAnalysis.getPersistentAccent()}
        switch (nounAnalysis.getPersistentAccent()) {
          case PersistentAccent.STEM_PENULT:
          accented = unaccented.accent(AccentPattern.RECESSIVE)
          break

          case PersistentAccent.STEM_ULTIMA:
          accented =  Accent.accentWord(unaccented, AccentPattern.PENULT)
          break

          case PersistentAccent.INFLECTIONAL_ENDING:
          accented = addNounUltima(unaccented, nounAnalysis, analysisInfo.getInflectionTag())
          break
        }
      }
    }

    if (debug > 0 ) {
      System.err.println "Check accent by comparing ${accented} to ${gs}"
    }
    return (accented.toString().replaceAll("[_^]","") == gs.toString())
  }


  // TO BE IMPLEMENTED.  GENERATE ACCENTED FORM AND COMPARE TO SUBMITTED FORM.
  /**
   */
  boolean checkAccent(GreekString utf8String, FstAnalysisParser analysisInfo) {
    // depends on type of analysis
    AnalysisTriple triple = analysisInfo.getTriple()
    MorphForm form = triple.getMorphForm()

    switch (form.getAnalyticalType()) {
    case AnalyticalType.NOUN:
    return checkNounAccent(utf8String, analysisInfo)
    break

    default:
    System.err.println "MorphologicalParser: analytical type ${triple.morphForm.getAnalyticalType()} not yet implemented"
    return false
    break
    }
  }

  /** Gets a morphological analysis for a Greek string.
  * @param gkStr The string to analyze.
  * @returns A MorphologicalAnalysis.
  */
  MorphologicalAnalysis parseGreekString(GreekString gkStr) {
    ArrayList analysisList  = []
    if (debug > 0) {System.err.println "Parsing " + gkStr}

    FstToken fstToken = new FstToken(gkStr)
    if (debug > 0) {System.err.println "MorphologicalAnalysis: submit ${fstToken}"}
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
        if (checkAccent(gkStr,fap)) {
          analysisList.add(fap.getTriple())
        } else {
          if (debug > 0) {
            System.err.println "Reject ${gkStr}"
          }
        }
      }
    }
    return( new MorphologicalAnalysis(gkStr, analysisList))
  }

  String toRdf(GreekString gkStr, CtsUrn ctsUrn) {
  }


}
