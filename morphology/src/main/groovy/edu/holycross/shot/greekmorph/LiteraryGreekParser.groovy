package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString
import edu.holycross.shot.orthography.GreekOrthography
import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.phonology.Accent
import edu.holycross.shot.phonology.AccentPattern
import edu.holycross.shot.phonology.Syllable
import edu.harvard.chs.cite.CiteUrn
import edu.harvard.chs.cite.CtsUrn

/** A Greek morphological parser.
*/
class LiteraryGreekParser implements GreekParser {

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
      //<a_hs><a_as><h_hs><hs_ou><as_ou>

      case "a_hs":
      case "a_as":
      case "h_hs":
      case "hs_ou":
      case "as_ou":
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



  boolean isPreAccented(String inflectionClass) {
    switch (inflectionClass) {
      case "irregacc":
      case "eus_ews":
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


  GreekWord getAccentedForm(GreekString inflectionalString, FstAnalysisParser analysisInfo) {
    GreekWord accented

    // Analysis data:
    AnalysisTriple triple = analysisInfo.getTriple()
    MorphForm form = triple.getMorphForm()
    NounForm nounAnalysis = form.getAnalysis()
    GreekWord retrievedForm = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())

    def inflectionSyllables = Syllable.getSyllables(inflectionalString)
    def accPattern = nounAnalysis.getPersistentAccent()
    System.err.println "Acc. pattern is " + accPattern
    def maxOffset = AccentPattern.values().size() - 1
    if (debug > 0) {
      System.err.println "Checking noun w  persistent accent " + accPattern + " and ordinal " + accPattern.ordinal() //nounAnalysis.getPersistentAccent()
      def sylloffset = (inflectionSyllables.size() - 1)
      def max1 = sylloffset + accPattern.ordinal()
      def max2 = 2 // ie, PersistentAccent.size() - 1
      def shiftidx = Math.min(max1, max2)
      def allVals = PersistentAccent.values()
      System.err.println "TRY INDEX " + shiftidx + " = " + allVals[shiftidx]
    }

    String inflectionTag = analysisInfo.getInflectionTag()
    if (isFirstDeclension(inflectionTag)) {
      //check special cases:  gen.pl.:
      if (
        (nounAnalysis.cas == GrammaticalCase.GENITIVE) &&
	(nounAnalysis.num == GrammaticalNumber.PLURAL)
        ) {
	if (debug > 1) {System.err.println "Special treatment for 1st decl  ${nounAnalysis.cas}  ${nounAnalysis.num}"}
	accented = addNounUltima(retrievedForm, nounAnalysis, analysisInfo.getInflectionTag())

      } else {
        if (debug > 0) {System.err.println "NOT gen.pl., so look at " + nounAnalysis.getPersistentAccent()}
        switch (nounAnalysis.getPersistentAccent()) {
	case PersistentAccent.STEM_PENULT:
	accented = retrievedForm.accent(AccentPattern.RECESSIVE)
	break

	case PersistentAccent.STEM_ULTIMA:
	// need to check for polysyllabic ending:
	accented = retrievedForm.accent( AccentPattern.PENULT) //Accent.accentWord(retrievedForm, AccentPattern.PENULT)
	break

	case PersistentAccent.INFLECTIONAL_ENDING:
	// need to check for polysyllabic ending:
	accented = addNounUltima(retrievedForm, nounAnalysis, analysisInfo.getInflectionTag())
	break
        }
      }
    } else { // second or third decl:
      if (debug > 0) {System.err.println "Second or third decl, look at " + nounAnalysis.getPersistentAccent()}
      switch (nounAnalysis.getPersistentAccent()) {
      case PersistentAccent.STEM_PENULT:
      // need to check for polysyllabic ending:
      accented = retrievedForm.accent(AccentPattern.RECESSIVE)
      break

      case PersistentAccent.STEM_ULTIMA:
      // need to check for polysyllabic ending:
      accented =  Accent.accentWord(retrievedForm, AccentPattern.PENULT)
      break

      case PersistentAccent.INFLECTIONAL_ENDING:
      // need to check for polysyllabic ending:
      accented = addNounUltima(retrievedForm, nounAnalysis, analysisInfo.getInflectionTag())
      break


      case PersistentAccent.IRREGULAR_ACCENT:
      // need to check for polysyllabic ending:
      accented = retrievedForm
      break
      }
    }
    return accented
  }

  /** Determines if form retrieved from FST parser should be considered a
   * match for GreekString gs.
    // Add accent to form retrieved from FST based on analysisInfo.
    // Method is true if accented form we create matches gs.
   * @param gs GreekString submitted for analysis.
   * @param analysisInfo Parsed results from FST parser.
   */
  boolean checkNounAccent(GreekString gs, FstAnalysisParser analysisInfo) {
    // Normalized, canonically accented form to compare with gs:
    GreekWord accented
    // Surface form from FST parser:
    GreekWord retrievedForm = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())

    String inflectionTag = analysisInfo.getInflectionTag()

    // see if retrieved from is pre-accented.
    //inflectionTag
    if (isPreAccented(inflectionTag)) {
      System.err.println "${inflectionTag} class is already accented!"
      accented = retrievedForm
    } else {
      GreekString fstSurfaceString = new GreekString(analysisInfo.surfaceInflection)
      accented = getAccentedForm(fstSurfaceString, analysisInfo)
    }


    if (debug > 0 ) {
      System.err.println "Check noun accent by comparing ${accented} to ${gs}"
      System.err.println "(removing quanity markers to get " + accented.toString().replaceAll("[_^]","") + ")"
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


    case AnalyticalType.INDECLINABLE:
    GreekWord retrievedForm = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())
    return retrievedForm.toString() == utf8String.toString()
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
  MorphologicalAnalysis parseGreekString(GreekOrthography gkStr) {
    ArrayList analysisList  = []
    if (debug > 0) {System.err.println "\nParsing " + gkStr}

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
