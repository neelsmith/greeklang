package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekW384Imptv {
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
    "λίπε": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.IMPERATIVE, Voice.ACTIVE],
    "λιπέτω": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.IMPERATIVE, Voice.ACTIVE],


    "λίπετον": [Person.SECOND, GrammaticalNumber.DUAL, Tense.AORIST, Mood.IMPERATIVE, Voice.ACTIVE],
    "λιπέτων": [Person.THIRD, GrammaticalNumber.DUAL, Tense.AORIST, Mood.IMPERATIVE, Voice.ACTIVE],

    "λίπετε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.IMPERATIVE, Voice.ACTIVE],
    "λιπόντων": [Person.THIRD, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.IMPERATIVE, Voice.ACTIVE],




    "λιποῦ": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.IMPERATIVE, Voice.MIDDLE],
    "λιπέσθω": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.IMPERATIVE, Voice.MIDDLE],


    "λίπεσθον": [Person.SECOND, GrammaticalNumber.DUAL, Tense.AORIST, Mood.IMPERATIVE, Voice.MIDDLE],
  //  "λιπέτων": [Person.THIRD, GrammaticalNumber.DUAL, Tense.AORIST, Mood.IMPERATIVE, Voice.MIDDLE],

    "λίπεσθε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.IMPERATIVE, Voice.MIDDLE],
  //  "λιπόντων": [Person.THIRD, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.IMPERATIVE, Voice.MIDDLE]

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

}
