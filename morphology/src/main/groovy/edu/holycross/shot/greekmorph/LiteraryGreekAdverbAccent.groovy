package edu.holycross.shot.greekmorph


import edu.holycross.shot.orthography.GreekString
import edu.holycross.shot.orthography.GreekOrthography
import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.phonology.Accent
import edu.holycross.shot.phonology.AccentPattern
import edu.holycross.shot.phonology.Syllable

class LiteraryGreekAdverbAccent {
static debug =  10

    /**
     */
    static GreekWord addAdvUltima(GreekWord gw, AdverbForm advForm, String inflectionClass) {

      def syllables = gw.getSyllables()
      Integer lastIndex = syllables.size() - 1
      String lastSyll = syllables[lastIndex]



      switch (inflectionClass) {
      default:
      syllables[lastIndex] = Accent.accentSyllable(lastSyll, "=")
      break
      }

      GreekWord resultWord = new GreekWord(syllables.join(""))
      return  resultWord
    }


    static  GreekWord getAccentedAdverbForm(GreekString inflectionalString, FstAnalysisParser analysisInfo) {
        GreekWord accented
        System.err.println "ACCEWNT ADVERB: " + inflectionalString

        // Analysis data:
        AnalysisTriple triple = analysisInfo.getTriple()
        MorphForm form = triple.getMorphForm()
        AdverbForm advAnalysis = form.getAnalysis()
        GreekWord retrievedForm = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())

        def inflectionSyllables = Syllable.getSyllables(inflectionalString)
        def accPattern = advAnalysis.getPersistentAccent()

        def maxOffset = AccentPattern.values().size() - 1
        if (debug > 0) {
          System.err.println "Acc. pattern is " + accPattern
          System.err.println "Checking adv w  persistent accent " + accPattern + " and ordinal " + accPattern.ordinal()
          def sylloffset = (inflectionSyllables.size() - 1)
          def max1 = sylloffset + accPattern.ordinal()
          def max2 = 2 // ie, PersistentAccent.size() - 1
          def shiftidx = Math.min(max1, max2)
          def allVals = PersistentAccent.values()
          System.err.println "TRY INDEX " + shiftidx + " = " + allVals[shiftidx]
        }

        String inflectionTag = analysisInfo.getInflectionTag()
        if (debug > 0) {System.err.println "Adverb to accent ${retrievedForm}, look at " + advAnalysis.getPersistentAccent()}
        switch (advAnalysis.getPersistentAccent()) {
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
        accented = LiteraryGreekAdverbAccent.addAdvUltima(retrievedForm, advAnalysis, analysisInfo.getInflectionTag())
        break


        case PersistentAccent.IRREGULAR_ACCENT:
        // need to check for polysyllabic ending:
        accented = retrievedForm
        break
        }
        return accented
      }


}
