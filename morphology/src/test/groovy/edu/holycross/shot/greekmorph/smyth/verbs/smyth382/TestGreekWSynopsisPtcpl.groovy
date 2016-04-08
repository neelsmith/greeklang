package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekWSynopsisPtcpl{
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnique() {
    def expectedUnique = [
    "λύων": [Tense.PRESENT, Voice.ACTIVE],
    "λύσων": [Tense.FUTURE, Voice.ACTIVE],
    "λύσας": [Tense.AORIST, Voice.ACTIVE],
    "λελυκώς": [Tense.PERFECT, Voice.ACTIVE],


    "λυσόμενος": [Tense.FUTURE, Voice.MIDDLE],
    "λυσάμενος": [Tense.AORIST, Voice.MIDDLE],

    "λυθησόμενος": [Tense.FUTURE, Voice.PASSIVE],
    "λυθείς": [Tense.AORIST, Voice.PASSIVE],
    ]
    expectedUnique.keySet().each { greek ->
      System.err.println "GREEK " + greek
      def expectedAnswer = expectedUnique[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 1
      MorphForm form = morph.analyses[0].getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.PARTICIPLE
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getTense() == expectedAnswer[0]
      assert formIdentification.getVoice() == expectedAnswer[1]
    }
  }


  @Test
  void testMP() {
    def expectedMP= [
    "λυόμενος": Tense.PRESENT,
    //"λελυμένος": Tense.PERFECT,
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
        assert formIdentification.getTense() == expectedAnswer
        assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
      }
    }
  }
}
