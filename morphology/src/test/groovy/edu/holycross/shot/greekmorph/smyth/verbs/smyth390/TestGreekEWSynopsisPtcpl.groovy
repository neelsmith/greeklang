package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekEWSynopsisPtcpl {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnique() {
    //
    def expectedUnique = [

    "ποιῶν": [Tense.PRESENT, Voice.ACTIVE],
    "ποιήσων": [Tense.FUTURE, Voice.ACTIVE],
    "ποιήσας": [Tense.AORIST, Voice.ACTIVE],
    "πεποιηκώς": [Tense.PERFECT, Voice.ACTIVE],


    "ποιησόμενος": [Tense.FUTURE, Voice.MIDDLE],
    "ποιησάμενος": [Tense.AORIST, Voice.MIDDLE],


    "ποιηθησόεμνος": [Tense.FUTURE, Voice.PASSIVE],
    "ποιηθεῖς": [Tense.AORIST, Voice.PASSIVE],

    ]

    expectedUnique.keySet().each { greek ->
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

// Voice.MIDDLE],
  @Test
  void testMP() {
    def expectedMP = [
    "ποιούμενος": Tense.PRESENT,
    "πεποιημένος": Tense.PERFECT
    ]
    expectedMP.keySet().each { greek ->
      def expectedAnswer = expectedMP[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 2
      morph.analyses.each{ ma ->
        MorphForm form = morph.analyses[0].getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.INFINITIVE
        CitableId formIdentification = form.getAnalysis()
        assert formIdentification.getTense() == expectedAnswer
        assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
      }

    }
  }

}
