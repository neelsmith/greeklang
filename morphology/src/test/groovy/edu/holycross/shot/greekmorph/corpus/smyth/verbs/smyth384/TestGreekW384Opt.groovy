package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekW384Opt {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testActive () {
    mp.debug = 10
    mp.fstParser.debug = 10
    def expectedUnique = [
    "λίποιμι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.ACTIVE],
    "λίποις": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.ACTIVE],
    "λίποι": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.ACTIVE],



    "λίποιτον": [Person.SECOND, GrammaticalNumber.DUAL, Tense.AORIST, Mood.OPTATIVE, Voice.ACTIVE],
    "λιποίτην": [Person.THIRD, GrammaticalNumber.DUAL, Tense.AORIST, Mood.OPTATIVE, Voice.ACTIVE],



    "λίποιμεν": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.OPTATIVE, Voice.ACTIVE],
    "λίποιτε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.OPTATIVE, Voice.ACTIVE],
    "λίποιεν": [Person.THIRD, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.OPTATIVE, Voice.ACTIVE]
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
  void testMiddle() {
    def expected = [
      "λιποίμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.MIDDLE],
      "λίποιο": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.MIDDLE],
      "λίποιτο": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE,  Voice.MIDDLE],

      "λίποισθον": [Person.SECOND, GrammaticalNumber.DUAL, Tense.AORIST, Mood.OPTATIVE,  Voice.MIDDLE],
      "λιποίσθην": [Person.THIRD, GrammaticalNumber.DUAL, Tense.AORIST, Mood.OPTATIVE,  Voice.MIDDLE],

      "λιποίμεθα": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.OPTATIVE,  Voice.MIDDLE],
      "λίποισθε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.OPTATIVE, Voice.MIDDLE],
      "λίποιντο" : [Person.THIRD, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.OPTATIVE, Voice.MIDDLE],
    ]

    expected.keySet().each { greek ->
      def expectedAnswer = expected[greek]
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
