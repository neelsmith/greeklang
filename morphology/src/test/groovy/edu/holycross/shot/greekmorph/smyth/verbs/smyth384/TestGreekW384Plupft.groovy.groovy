package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekW384Plupft {
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
      "ἐλελοίπη": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE],
      "ἐλελοίπης": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE],
      "ἐλελοίπει": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE],
      "ἐλελοίπειν": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE],

      "ἐλελοίπετον": [Person.SECOND, GrammaticalNumber.DUAL, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE],
    "ἐλελοιπέτην": [Person.THIRD, GrammaticalNumber.DUAL, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE],

    "ἐλελοίπεμεν": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE],
    "ἐλελοίπετε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE],
    "ἐλελοίπεσαν": [Person.THIRD, GrammaticalNumber.PLURAL, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE]

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
