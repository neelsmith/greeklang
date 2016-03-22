package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekWInfinitives {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)

  @Test
  void testSinglePrelim() {
    mp.debug = 10
    mp.fstParser.debug = 10


    String greek = "λύειν"
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
    assert morph.analyses.size() == 1

    MorphForm form = morph.analyses[0].getMorphForm()
    assert form.getAnalyticalType() == AnalyticalType.INFINITIVE
    CitableId formIdentification = form.getAnalysis()
    assert formIdentification.getTense() == Tense.PRESENT
    assert formIdentification.getVoice() == Voice.ACTIVE


  }

}
