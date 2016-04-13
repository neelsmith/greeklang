package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Smyth 382.
*/
class TestGreekWSynopsisPres {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)




  @Test
  void testUnique() {
    System.err.println "\n\n\nBeginning to test UNIQUE FORMS\n"
    def expectedUnique = [
    "λύοιμι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.OPTATIVE, Voice.ACTIVE],
    "λῦε": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.IMPERATIVE, Voice.ACTIVE],
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
    System.err.println "\n\nFinished testing UNIQUE FORMS\n"
  }


  @Test
  void testMPForms() {
    System.err.println "\n\n\nBeginning to test MP FORMS\n"
    // luou
    def expectedMP = [
    "λύομαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.INDICATIVE],
    "ἐλυόμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.IMPERFECT, Mood.INDICATIVE],
    "λύωμαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.SUBJUNCTIVE],
    "λυοίμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.OPTATIVE],


    "λύου": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.IMPERATIVE],


    ]

    def mpVoice = [Voice.MIDDLE, Voice.PASSIVE]
    expectedMP.keySet().each { greek ->
      def expectedAnswer = expectedMP[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
System.err.println "Analyses for " + greek + ": " + morph.analyses.size()
      assert morph.analyses.size() == 2
      MorphForm form = morph.analyses[0].getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == expectedAnswer[0]
      assert formIdentification.getNum() == expectedAnswer[1]
      assert formIdentification.getTense() == expectedAnswer[2]
      assert formIdentification.getMood() == expectedAnswer[3]
      assert mpVoice.contains(formIdentification.getVoice())
    }
      System.err.println "\n\n\nFINISHED testing MP FORMS\n"
  }



  @Test
  void testAmbig2() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("λύω",true))
    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == Person.FIRST
      assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      assert formIdentification.getVoice() == Voice.ACTIVE
      assert formIdentification.getTense() == Tense.PRESENT
      assert [Mood.INDICATIVE, Mood.SUBJUNCTIVE].contains(formIdentification.getMood())
    }
  }

  @Test
  void testAmbig3() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("ἔλυον",true))
    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getTense() == Tense.IMPERFECT
      assert formIdentification.getMood() == Mood.INDICATIVE
      assert formIdentification.getVoice() == Voice.ACTIVE

      switch (formIdentification.getPerson()) {
        case Person.FIRST:
        assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
        break
        case Person.THIRD:
        assert formIdentification.getNum() == GrammaticalNumber.PLURAL
        break
        default:
        throw new Exception("Invalid person/number combination for ἔλυον")
        break
      }
    }
  }



}
