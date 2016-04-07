package edu.holycross.shot.greekmorph


import edu.holycross.shot.orthography.GreekString
import edu.holycross.shot.orthography.GreekOrthography
import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.phonology.Accent
import edu.holycross.shot.phonology.AccentPattern
import edu.holycross.shot.phonology.Syllable

class LiteraryGreekNounAccent {
  static debug =  10

    static boolean isFirstDeclension(String inflectionClass) {
      switch (inflectionClass) {
        case "a_as":
        case "a_as_comp":
        case "a_as_long":
        case "a_as_short":
        case "a_hs":
        case "as_ou":
        case "as_ou_comp":
        case "h_hs":
        case "h_hs_comp":
        case "hs_ou":
        case "hs_ou_comp":

        return true
        break

        default:
        return false
        break
      }
    }
    static boolean isSecondDeclension(String inflectionClass) {
      switch (inflectionClass) {
        case "os_ou":
        return true
        break
        default:
        return false
        break
      }
    }



    /**
     */
    static GreekWord addAdjUltima(GreekWord gw, AdjectiveForm adjForm, String inflectionClass) {

      def syllables = gw.getSyllables()
      Integer lastIndex = syllables.size() - 1
      String lastSyll = syllables[lastIndex]

      switch (adjForm.cas) {
      case GrammaticalCase.GENITIVE:
      case GrammaticalCase.DATIVE:
      System.err.println "ADD PERISPOMENON TO " + adjForm + " for case " + adjForm.cas
      syllables[lastIndex] = Accent.accentSyllable(lastSyll, "=")
      break
      default :
      System.err.println "ADD OXYTONE TO " + adjForm + " for case " + adjForm.cas
      System.err.println "${lastSyll} is of class " + lastSyll.getClass()

      String accentedSyll =  Accent.accentSyllable(lastSyll, "/")
      System.err.println "Accented is " + accentedSyll
      syllables[lastIndex] = accentedSyll
      break
      }

      GreekWord resultWord = new GreekWord(syllables.join(""))
      return  resultWord
    }


    /**  Adds correct accent to last syllable of a noun, taking into consideration
    * the inflectional class the noun belongs to and the case of the string.
    */
    static GreekWord addNounUltima(GreekWord gw, NounForm nounForm, String inflectionClass) {

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

      //    Third declension is complicated
      GreekWord resultWord = new GreekWord(syllables.join(""))
      return  resultWord
    }


    /** Uses morphological information in a FstAnalysisParser to determine
    * how to accent a GreekString, and adds the appropriate accent.
    * @param inflectionalString
    * @param analysisInfo
    */
    static GreekWord getAccentedNounForm(GreekString inflectionalString, FstAnalysisParser analysisInfo) {
      GreekWord accented

      // Analysis data:
      AnalysisTriple triple = analysisInfo.getTriple()
      MorphForm form = triple.getMorphForm()
      NounForm nounAnalysis = form.getAnalysis()
      GreekWord retrievedForm = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())

      def inflectionSyllables = Syllable.getSyllables(inflectionalString)
      def accPattern = nounAnalysis.getPersistentAccent()

      def maxOffset = AccentPattern.values().size() - 1
      if (debug > 0) {
        System.err.println "Acc. pattern is " + accPattern
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
  	accented = LiteraryGreekNounAccent.addNounUltima(retrievedForm, nounAnalysis, analysisInfo.getInflectionTag())

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
  	accented = LiteraryGreekNounAccent.addNounUltima(retrievedForm, nounAnalysis, analysisInfo.getInflectionTag())
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
        accented = LiteraryGreekNounAccent.addNounUltima(retrievedForm, nounAnalysis, analysisInfo.getInflectionTag())
        break


        case PersistentAccent.IRREGULAR_ACCENT:
        // need to check for polysyllabic ending:
        accented = retrievedForm
        break
        }
      }
      return accented
    }





}
