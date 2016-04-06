package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekWVadjs {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)

  @Test
  void testVAdj1() {
    mp.debug = 10
    mp.fstParser.debug = 10
    String greek = "λυτέος"
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
    // could be middle, could be passive
    assert morph.analyses.size() == 1


    MorphForm form = morph.analyses[0].getMorphForm()
    assert form.getAnalyticalType() == AnalyticalType.VERBAL_ADJECTIVE
    CitableId formIdentification = form.getAnalysis()
    assert formIdentification.getGender() == Gender.MASCULINE
    assert formIdentification.getCas() == GrammaticalCase.NOMINATIVE
    assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
  }

  @Test
  void testVAdj2() {
    mp.debug = 10
    mp.fstParser.debug = 10
    String greek = "λυτός"
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
    // could be middle, could be passive
    assert morph.analyses.size() == 1


    MorphForm form = morph.analyses[0].getMorphForm()
    assert form.getAnalyticalType() == AnalyticalType.VERBAL_ADJECTIVE
    CitableId formIdentification = form.getAnalysis()
    assert formIdentification.getGender() == Gender.MASCULINE
    assert formIdentification.getCas() == GrammaticalCase.NOMINATIVE
    assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
  }

}
