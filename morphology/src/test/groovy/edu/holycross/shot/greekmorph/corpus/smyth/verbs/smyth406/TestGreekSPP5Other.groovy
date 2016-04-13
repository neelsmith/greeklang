package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/**
*/
class TestGreekSPP5Other {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testInfin() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("πεπεῖσθαι",true))

    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.INFINITIVE
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getTense() == Tense.PERFECT
      assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
    }

  }


  @Test
  void testPtcpl() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("πεπεισμένος",true))

    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.PARTICIPLE
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.MASCULINE
      assert formIdentification.getCas() == GrammaticalCase.NOMINATIVE
      assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      assert formIdentification.getTense() == Tense.PERFECT


      assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
    }

  }

}
