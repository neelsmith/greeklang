package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekWImpft {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)

  @Test
  void testSinglePrelim() {
    mp.debug = 10
    mp.fstParser.debug = 10
    String greek = "ἔλυες"
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
    // could be middle, could be passive
    assert morph.analyses.size() == 1

    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == Person.SECOND
      assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      assert formIdentification.getTense() == Tense.IMPERFECT
      assert formIdentification.getMood() == Mood.INDICATIVE
      assert (formIdentification.getVoice() == Voice.ACTIVE)

    }

  }

  @Test
  void testUnique () {
    mp.debug = 10
    mp.fstParser.debug = 10
    def expectedUnique = [
    "ἔλυες": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.IMPERFECT, Mood.INDICATIVE, Voice.ACTIVE],
    "ἔλυε": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.IMPERFECT, Mood.INDICATIVE, Voice.ACTIVE],

    "ἐλύομεν": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.IMPERFECT, Mood.INDICATIVE, Voice.ACTIVE],
    "ἐλύετε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.IMPERFECT, Mood.INDICATIVE, Voice.ACTIVE]
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
  void testFirstThird() {
    String greek = "ἔλυον"
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB

      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getTense() == Tense.IMPERFECT
      assert formIdentification.getMood() == Mood.INDICATIVE
      assert formIdentification.getVoice() ==  Voice.ACTIVE

      if (formIdentification.getPerson() == Person.FIRST) {
	assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      } else {
	assert formIdentification.getNum() == GrammaticalNumber.PLURAL
	assert formIdentification.getPerson() == Person.THIRD
      }
    }
  }

  // add test on duals

  @Test
  void testMP() {
    def expectedMP = [
      "ἐλυόμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.IMPERFECT, Mood.INDICATIVE],
      "ἐλύου": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.IMPERFECT, Mood.INDICATIVE],
      "ἐλύετο": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.IMPERFECT, Mood.INDICATIVE],
      "ἐλυόμεθα": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.IMPERFECT, Mood.INDICATIVE],
      "ἐλύεσθε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.IMPERFECT, Mood.INDICATIVE],
      "ἐλύοντο" : [Person.THIRD, GrammaticalNumber.PLURAL, Tense.IMPERFECT, Mood.INDICATIVE],
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
      assert ((formIdentification.getVoice() == Voice.MIDDLE) || (formIdentification.getVoice() == Voice.PASSIVE))

    }


  }
}
