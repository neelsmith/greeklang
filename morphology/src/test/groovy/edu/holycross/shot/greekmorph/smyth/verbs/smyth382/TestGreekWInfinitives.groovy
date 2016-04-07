package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekWInfinitives {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnique() {
    def expectedUnique = [
    "λύειν": [Tense.PRESENT, Voice.ACTIVE],
    "λύσειν": [Tense.FUTURE, Voice.ACTIVE],
    //"λελυκέναι": [Tense.PERFECT, Voice.ACTIVE],
    "λύσεσθαι": [Tense.FUTURE, Voice.MIDDLE],
    "λύσασθαι": [Tense.AORIST, Voice.MIDDLE],
    "λυθήσεσθαι": [Tense.FUTURE, Voice.PASSIVE],
    //"λυθῆναι": [Tense.AORIST, Voice.PASSIVE],
    ]
    expectedUnique.keySet().each { greek ->
      System.err.println "GREEK " + greek
      def expectedAnswer = expectedUnique[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 1
      MorphForm form = morph.analyses[0].getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.INFINITIVE
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getTense() == expectedAnswer[0]
      assert formIdentification.getVoice() == expectedAnswer[1]
    }
  }


  @Test
  void testMP() {
    def expectedMP= [
    "λύεσθαι": Tense.PRESENT,
    "λελύσθαι": Tense.PERFECT,
    ]
    expectedMP.keySet().each { greek ->
      System.err.println "GREEK " + greek
      def expectedAnswer = expectedMP[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 2
      morph.analyses.each { ma ->
        MorphForm form = ma.getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.INFINITIVE
        CitableId formIdentification = form.getAnalysis()
        assert formIdentification.getTense() == expectedAnswer
        assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
      }
    }
  }
}
