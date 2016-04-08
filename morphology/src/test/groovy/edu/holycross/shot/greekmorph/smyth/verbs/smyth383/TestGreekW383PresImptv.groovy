package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Exhaustively test present imperative from Smyth 383.
*/
class TestGreekW383PresImptv {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)

  @Test
  void testUnq() {
    def expectedUnique = [
    "λῦε": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.IMPERATIVE, Voice.ACTIVE],
    "λυέτω": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.IMPERATIVE, Voice.ACTIVE],

    "λυέτων": [Person.THIRD, GrammaticalNumber.DUAL, Tense.PRESENT, Mood.IMPERATIVE, Voice.ACTIVE],

    "λυόντων": [Person.THIRD, GrammaticalNumber.PLURAL, Tense.PRESENT, Mood.IMPERATIVE, Voice.ACTIVE],
    ]
    expectedUnique.keySet().each { greek ->
      def expectedAnswer = expectedUnique[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 1
      MorphForm form = morph.analyses[0].getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == expectedAnswer[0]
      assert formIdentification.getNum() == expectedAnswer[1]
      assert formIdentification.getTense() == expectedAnswer[2]
      assert formIdentification.getMood() == expectedAnswer[3]
      assert formIdentification.getVoice() == expectedAnswer[4]
    }
  }


  @Test
  void testAmbig1() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("λύετον",true))
    assert morph.analyses.size() == 3
    morph.analyses.each  { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getNum() == GrammaticalNumber.DUAL
      assert formIdentification.getTense() == Tense.PRESENT
      assert formIdentification.getVoice() == Voice.ACTIVE

      switch (formIdentification.getMood()) {
        case Mood.IMPERATIVE:
        assert formIdentification.getPerson() == Person.SECOND
        break

        case Mood.INDICATIVE:
        assert [Person.SECOND, Person.THIRD].contains(formIdentification.getPerson())
        break

        default:
        throw new Exception ("Bad mood for λύετον")
        break
      }
    }
  }

  @Test
  void testAmbig2() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("λύετε",true))

    assert morph.analyses.size() == 2
    morph.analyses.each  { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == Person.SECOND
      assert formIdentification.getNum() == GrammaticalNumber.PLURAL
      assert formIdentification.getTense() == Tense.PRESENT
      assert formIdentification.getVoice() == Voice.ACTIVE
      assert [Mood.INDICATIVE, Mood.IMPERATIVE].contains( formIdentification.getMood())
    }
  }

  @Test
  void testAmbig3() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("λύεσθον",true))
    assert morph.analyses.size() == 6
    morph.analyses.each  { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getNum() == GrammaticalNumber.DUAL
      assert formIdentification.getTense() == Tense.PRESENT
      assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())

      switch (formIdentification.getMood()) {
      case Mood.IMPERATIVE:
      assert formIdentification.getPerson() == Person.SECOND
      break

      case Mood.INDICATIVE:
      assert [Person.SECOND, Person.THIRD].contains(formIdentification.getPerson())
      break

      default:
      throw new Exception ("Bad mood for λύεσθον")
      break
      }
    }
  }

  @Test
  void testAmbig4() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("λύεσθε",true))

    assert morph.analyses.size() == 2
    morph.analyses.each  { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == Person.SECOND
      assert formIdentification.getNum() == GrammaticalNumber.PLURAL
      assert formIdentification.getTense() == Tense.PRESENT
      assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
      assert [Mood.INDICATIVE, Mood.IMPERATIVE].contains( formIdentification.getMood())
    }
  }

  @Test
  void testAmbig5() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("λυέσθων",true))
    assert morph.analyses.size() == 2
    morph.analyses.each  { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == Person.THIRD
      assert [GrammaticalNumber.DUAL, GrammaticalNumber.PLURAL].contains(formIdentification.getNum())
      assert formIdentification.getTense() == Tense.PRESENT
      assert  formIdentification.getMood() == Mood.IMPERATIVE
      assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
    }
  }

  @Test
  void testMP() {
    def middpass = [Voice.MIDDLE, Voice.PASSIVE]
    def expectedMP = [
      "λύου": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.IMPERATIVE],
      "λυέσθω": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.IMPERATIVE],
      "λύεσθον": [Person.SECOND, GrammaticalNumber.DUAL, Tense.PRESENT, Mood.IMPERATIVE]
    ]
    expectedMP.keySet().each { greek ->
      def expectedAnswer = expectedMP[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 2
      MorphForm form = morph.analyses[0].getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == expectedAnswer[0]
      assert formIdentification.getNum() == expectedAnswer[1]
      assert formIdentification.getTense() == expectedAnswer[2]
      assert formIdentification.getMood() == expectedAnswer[3]
      assert middpass.contains(formIdentification.getVoice() )
    }
  }
}
