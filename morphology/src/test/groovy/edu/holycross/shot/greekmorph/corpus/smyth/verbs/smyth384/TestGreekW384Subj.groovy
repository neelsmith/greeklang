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
  //  "λίπῃ": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE],



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



  @Test
  void testAmbig() {
  //  "λίπῃ": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE],

    String greek = "λίπῃ"
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB

      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getTense() == Tense.AORIST
      assert formIdentification.getMood() == Mood.SUBJUNCTIVE
	    assert formIdentification.getNum() == GrammaticalNumber.SINGULAR

      if (formIdentification.getVoice() ==  Voice.ACTIVE) {
        assert formIdentification.getPerson() == Person.THIRD
      } else if (formIdentification.getVoice() ==  Voice.MIDDLE) {
        assert formIdentification.getPerson() == Person.SECOND
      } else {
        throw new Exception ("Bad voice for λίπῃ")
      }
    }
  }


  @Test
  void testDualMid() {
  //  "λίπῃ": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE],

    String greek = "λίπησθον"
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB

      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getTense() == Tense.AORIST
      assert formIdentification.getMood() == Mood.SUBJUNCTIVE
	    assert formIdentification.getNum() == GrammaticalNumber.DUAL
      assert formIdentification.getVoice() ==  Voice.MIDDLE
      assert [Person.SECOND, Person.THIRD].contains(formIdentification.getPerson())
    }
  }


  @Test
  void testDualAct() {
  //  "λίπῃ": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.ACTIVE],

    String greek = "λίπητον"
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB

      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getTense() == Tense.AORIST
      assert formIdentification.getMood() == Mood.SUBJUNCTIVE
      assert formIdentification.getNum() == GrammaticalNumber.DUAL
      assert formIdentification.getVoice() ==  Voice.ACTIVE
      assert [Person.SECOND, Person.THIRD].contains(formIdentification.getPerson())
    }
  }

  @Test
  void testMiddle() {
    def expected = [
      "λίπωμαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.MIDDLE],

      "λίπηται": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE,  Voice.MIDDLE],



      "λιπώμεθα": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.SUBJUNCTIVE,  Voice.MIDDLE],
      "λίπησθε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.MIDDLE],
      "λίπωνται" : [Person.THIRD, GrammaticalNumber.PLURAL, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.MIDDLE],
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
