package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekWParticiples {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnique() {
    def expectedUnique = [
    "λύων": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.PRESENT, Voice.ACTIVE],
    "λύσων": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.FUTURE, Voice.ACTIVE],
    "λύσας": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.AORIST, Voice.ACTIVE],
    //"λελυκώς": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.PERFECT, Voice.ACTIVE],

    "λυσόμενος": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.FUTURE, Voice.MIDDLE],
    "λυσάμενος": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.AORIST, Voice.MIDDLE],

    "λυθησόμενος": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.FUTURE, Voice.PASSIVE],
    //"λυθείς": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.AORIST, Voice.PASSIVE],
    ]
    expectedUnique.keySet().each { greek ->
      System.err.println "GREEK " + greek
      def expectedAnswer = expectedUnique[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 1
      MorphForm form = morph.analyses[0].getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.PARTICIPLE
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == expectedAnswer[0]
      assert formIdentification.getCas() == expectedAnswer[1]
      assert formIdentification.getNum() == expectedAnswer[2]
      assert formIdentification.getTense() == expectedAnswer[3]
      assert formIdentification.getVoice() == expectedAnswer[4]
    }
  }

// MP forms:
// luomenos, lelumenos
  @Test
  void testMP() {
    def expectedMP = [
      "λυόμενος": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.PRESENT],
    ]
    expectedMP.keySet().each { greek ->
      System.err.println "GREEK " + greek
      def expectedAnswer = expectedMP[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 2
      morph.analyses.each { ma ->
        MorphForm form = ma.getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.PARTICIPLE

        CitableId formIdentification = form.getAnalysis()
        assert formIdentification.getGender() == expectedAnswer[0]
        assert formIdentification.getCas() == expectedAnswer[1]
        assert formIdentification.getNum() == expectedAnswer[2]
        assert formIdentification.getTense() == expectedAnswer[3]
        assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
      }
    }
  }


}
