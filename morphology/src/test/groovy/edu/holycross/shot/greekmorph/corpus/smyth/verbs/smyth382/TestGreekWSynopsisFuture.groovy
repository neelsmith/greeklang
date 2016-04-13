package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Smyth 382.
*/
class TestGreekWSynopsisFuture {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnique() {
    System.err.println "\n\n\nBeginning to test UNIQUE FORMS\n"
    def expectedUnique = [


    "λύσοιμι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.FUTURE, Mood.OPTATIVE, Voice.ACTIVE],


    "λύσομαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.FUTURE, Mood.INDICATIVE, Voice.MIDDLE],
    "λυσοίμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.FUTURE, Mood.OPTATIVE, Voice.MIDDLE],



    "λυθήσομαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.FUTURE, Mood.INDICATIVE, Voice.PASSIVE],
    "λυθησοίμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.FUTURE, Mood.OPTATIVE, Voice.PASSIVE],



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



}
