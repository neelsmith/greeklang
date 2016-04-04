package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekWSynopsis {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnique() {
    //
    def expectedUnique = [

    "ἔλυσα": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.INDICATIVE, Voice.ACTIVE],
    "λέλυκα": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.INDICATIVE, Voice.ACTIVE],

    "ἐλελύκη": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE],

    "λύοιμι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.OPTATIVE, Voice.ACTIVE],
    "λύσοιμι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.FUTURE, Mood.OPTATIVE, Voice.ACTIVE],
    "λύσαιμι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.ACTIVE],
    "λύσωμαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.MIDDLE],
    "λυσαίμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.MIDDLE],
    ]
    // ambiguou:
    // luw
    // lusw


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
  void testMPForms() {

    // luou
    def expectedMP = [
    "λύομαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.INDICATIVE],
    "λυοίμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.OPTATIVE],
    "λέλυμαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.INDICATIVE],
    "ἐλελύμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE]
    ]

    def mpVoice = [Voice.MIDDLE, Voice.PASSIVE]
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
      assert mpVoice.contains(formIdentification.getVoice())
    }
  }
}
