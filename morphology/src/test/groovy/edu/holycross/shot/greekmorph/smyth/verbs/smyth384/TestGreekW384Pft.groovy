package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekW384Pft {
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
    "λέλοιπα": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.INDICATIVE, Voice.ACTIVE],
    "λέλοιπας": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.INDICATIVE, Voice.ACTIVE],
    "λέλοιπε": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.INDICATIVE, Voice.ACTIVE],




//    "λέλοιπατον": [Person.SECOND, GrammaticalNumber.DUAL, Tense.PERFECT, Mood.INDICATIVE, Voice.ACTIVE],




    "λελοίπαμεν": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.PERFECT, Mood.INDICATIVE, Voice.ACTIVE],
    "λελοίπατε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.PERFECT, Mood.INDICATIVE, Voice.ACTIVE],
    "λελοίπασι": [Person.THIRD, GrammaticalNumber.PLURAL, Tense.PERFECT, Mood.INDICATIVE, Voice.ACTIVE],

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
  void testDual() {
    String greek = "λελοίπατον"
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
    assert morph.analyses.size() == 2
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB

      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getTense() == Tense.PERFECT
      assert formIdentification.getMood() == Mood.INDICATIVE
      assert formIdentification.getVoice() ==  Voice.ACTIVE
      assert formIdentification.getNum() == GrammaticalNumber.DUAL

      assert  [Person.SECOND, Person.THIRD].contains(formIdentification.getPerson())

    }
  }

}
