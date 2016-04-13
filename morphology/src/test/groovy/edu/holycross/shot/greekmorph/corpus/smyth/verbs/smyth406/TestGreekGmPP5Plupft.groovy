package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Smyth 406.
*/
class TestGreekGmPP5Plupft {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)



  @Test
  void testUnique() {
    //
    def expectedUnique = [
    "ἐπεπράγμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE],
    "ἐπέπραξο": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE],
    "ἐπέπρακτο": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE],


    "ἐπέπραχθον": [Person.SECOND, GrammaticalNumber.DUAL, Tense.PLUPERFECT, Mood.INDICATIVE],
    "ἐπεπράχθην": [Person.THIRD, GrammaticalNumber.DUAL, Tense.PLUPERFECT, Mood.INDICATIVE],

    "ἐπεπράγμεθα": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.PLUPERFECT, Mood.INDICATIVE],
    "ἐπέπραχθε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.PLUPERFECT, Mood.INDICATIVE]

    ]
    expectedUnique.keySet().each { greek ->
      def expectedAnswer = expectedUnique[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 2
      morph.analyses.each { ma ->

        MorphForm form = ma.getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.CVERB
        CitableId formIdentification = form.getAnalysis()
        assert formIdentification.getPerson() == expectedAnswer[0]
        assert formIdentification.getNum() == expectedAnswer[1]
        assert formIdentification.getTense() == expectedAnswer[2]
        assert formIdentification.getMood() == expectedAnswer[3]
        assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
      }
    }
  }



}
