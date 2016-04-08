package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Smyth 382.
*/
class TestGreekWSynopsisAorist {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnique() {

    def expectedUnique = [

    "ἔλυσα": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.INDICATIVE, Voice.ACTIVE],
    "λύσαιμι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.ACTIVE],
    "λῦσον": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.IMPERATIVE, Voice.ACTIVE],


    "ἐλυσάμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.INDICATIVE, Voice.MIDDLE],
    "λύσωμαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.MIDDLE],
    "λυσαίμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.MIDDLE],




    "ἐλύθην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.INDICATIVE, Voice.PASSIVE],
    "λυθείην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.PASSIVE],
    //"λυθῶ": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.PASSIVE],

    "λύθητι": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.IMPERATIVE, Voice.PASSIVE],

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
  void testAmbig1() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("λύσω",true))
    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == Person.FIRST
      assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      assert formIdentification.getVoice() == Voice.ACTIVE


      switch (formIdentification.getTense()) {
        case Tense.FUTURE:
        assert formIdentification.getMood() == Mood.INDICATIVE
        break

        case Tense.AORIST:
        assert formIdentification.getMood() == Mood.SUBJUNCTIVE
        break
        default:
        throw new Exception("Invalid tense for λύω")
        break
      }
    }
  }




  @Test
  void testAmbig4() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("λῦσαι",true))
    /*
    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      CitableId formIdentification = form.getAnalysis()
System.err.println "For λῦσαι : " + formIdentification.toString()
      switch (form.getAnalyticalType() ) {
        case AnalyticalType.CVERB:
        assert formIdentification.getPerson() == Person.SECOND
        assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
        assert formIdentification.getTense() == Tense.AORIST
        assert formIdentification.getMood() == Mood.IMPERATIVE
        assert formIdentification.getVoice() == Voice.MIDDLE
        break
        case AnalyticalType.INFINITIVE:
        assert formIdentification.getTense() == Tense.AORIST
        assert formIdentification.getVoice() == Voice.ACTIVE
        break
        default:
        throw new Exception("Invalid analysis type for λῦσαι")
        break
      }
    }*/
  }

}
