package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekW384Ptcpl {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnique () {
    mp.debug = 10
    mp.fstParser.debug = 10
    def expectedUnique = [
    "λιπών": [Tense.AORIST, Voice.ACTIVE],
    "λιπόμενος": [Tense.AORIST, Voice.MIDDLE],
    "λελοιπώς": [Tense.PERFECT, Voice.ACTIVE],


    ]
    expectedUnique.keySet().each { greek ->
      def expectedAnswer = expectedUnique[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
      assert morph.analyses.size() == 1
      MorphForm form = morph.analyses[0].getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.PARTICIPLE
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.MASCULINE
      assert formIdentification.getCas() == GrammaticalCase.NOMINATIVE
      assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      assert formIdentification.getTense() == expectedAnswer[0]
      assert formIdentification.getVoice() == expectedAnswer[1]

    }
  }
}
