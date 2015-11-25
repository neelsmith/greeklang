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


  boolean isFirstDeclension(String inflectionClass) {
    switch (inflectionClass) {

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
    System.err.println "Accent ultima of " + gw + ", type " + inflectionClass + ", form " + nounForm

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
      System.err.println "IS 1-2 DECL"
      switch (nounForm.cas) {
        case GrammaticalCase.GENITIVE:
        case GrammaticalCase.DATIVE:

        syllables[lastIndex] = Accent.accentSyllable(lastSyll, "=")
        System.err.println "accented last syll "  + syllables
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
    System.err.println "Word with ultima = " + resultWord
    return  resultWord
  }

  // TO BE IMPLEMENTED.  GENERATE ACCENTED FORM AND COMPARE TO SUBMITTED FORM.
  /** NOT YET FULLY IMPLEMENTED */
  boolean checkAccent(GreekString utf8String, FstAnalysisParser analysisInfo) {

    System.err.println "Check accent on " + utf8String
    // depends on type of analysis.
    // with only a handful of exceptions, conjugated verbs are recessive.
    // nouns have persistent accent property to consider.
    GreekWord unaccented = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())

    GreekWord accented
    AnalysisTriple triple = analysisInfo.getTriple()
    MorphForm form = triple.getMorphForm()

    AnalysisExplanation explanation = triple.getAnalysisExplanation()

    if (debug > 0) {
      System.err.println "Checking unaccented " + unaccented + " with " + form.getAnalyticalType()

    }
    switch (form.getAnalyticalType()) {
      case AnalyticalType.NOUN:
      NounForm nounAnalysis = form.getAnalysis()
      if (debug > 0) {
        System.err.println "Checking  persistent accent " + nounAnalysis.getPersistentAccent()

      }


      switch (nounAnalysis.getPersistentAccent()) {
        case PersistentAccent.STEM_PENULT:
        accented = unaccented.accent(AccentPattern.RECESSIVE)
        break

        case PersistentAccent.STEM_ULTIMA:
        accented =  unaccented.accent(AccentPattern.PENULT)
        break

        case PersistentAccent.INFLECTIONAL_ENDING:
        accented = addNounUltima(unaccented, nounAnalysis, analysisInfo.getInflectionTag())
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
        if (debug > 0) {System.err.println "FAP: " + fap}
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
