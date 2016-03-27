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

/*
  @Test
  void testActive() {
    //
    def expectedUnique = [
    "λύομεν": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.PRESENT, Mood.INDICATIVE, Voice.ACTIVE]
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


  } */
}
