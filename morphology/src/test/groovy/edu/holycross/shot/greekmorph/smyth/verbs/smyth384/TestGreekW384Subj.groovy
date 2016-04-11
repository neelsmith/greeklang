package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekW384Subj {
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
    "λίπω": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE],
    "λίπῃς": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE],
    "λίπῃ": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE],



    //"ἐλίπετον": [Person.SECOND, GrammaticalNumber.DUAL, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE],
    //"ἐλιπέτην": [Person.THIRD, GrammaticalNumber.DUAL, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE],



    "λίπωμεν": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE],
    "λίπητε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE],
    "λίπωσι": [Person.THIRD, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE]
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

/*

  @Test
  void testFirstThird() {
    String greek = "ἔλιπον"
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB

      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getTense() == Tense.AORIST
      assert formIdentification.getMood() == Mood.SUBJUNCTIVE
      assert formIdentification.getVoice() ==  Voice.ACTIVE

      if (formIdentification.getPerson() == Person.FIRST) {
	assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      } else {
	assert formIdentification.getNum() == GrammaticalNumber.PLURAL
	assert formIdentification.getPerson() == Person.THIRD
      }
    }
  }


  @Test
  void testMiddle() {
    def expected = [
      "ἐλιπόμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.MIDDLE],
      "ἐλίπου": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.MIDDLE],
      "ἐλίπετο": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE,  Voice.MIDDLE],

      "ἐλίπεσθον": [Person.SECOND, GrammaticalNumber.DUAL, Tense.AORIST, Mood.SUBJUNCTIVE,  Voice.MIDDLE],
      "ἐλιπέσθην": [Person.THIRD, GrammaticalNumber.DUAL, Tense.AORIST, Mood.SUBJUNCTIVE,  Voice.MIDDLE],

      "ἐλιπόμεθα": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.SUBJUNCTIVE,  Voice.MIDDLE],
      "ἐλίπεσθε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.MIDDLE],
      "ἐλίποντο" : [Person.THIRD, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.MIDDLE],
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


  }*/

}
