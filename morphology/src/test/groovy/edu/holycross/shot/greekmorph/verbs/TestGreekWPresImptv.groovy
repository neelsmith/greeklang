package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekWPresImptv {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnq() {
    //
    def expectedUnique = [
    "λῦε": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.IMPERATIVE, Voice.ACTIVE],

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
  void testMP() {
    def mp = [Voice.MIDDLE, Voice.PASSIVE]
    def expectedMP = [
      "λύου": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.IMPERATIVE],
      "λυέσθω": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.IMPERATIVE],
      "λύεσθον": [Person.SECOND, GrammaticalNumber.DUAL, Tense.PRESENT, Mood.IMPERATIVE],
      "λύεσθε": [Person.SECOND, GrammaticalNumber.PLURAL, Tense.PRESENT, Mood.IMPERATIVE]
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
      assert mp.contains(formIdentification.getVoice() )
    }
  }
}
