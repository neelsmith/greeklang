package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

//<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>

class TestAnalysisParser {

  @Test
  void testParser() {
    String conjverb = "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
    FstAnalysisParser fap = new FstAnalysisParser(conjverb)
    assert fap.getStem() == "<coretests.n64316_0>"
    assert fap.getLexicalEntity() == "<lexent.n64316>"
    assert fap.getInflectionalPattern() == "<w_indicative.1>" ///"<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
    assert fap.getPos() == "<verb>"
    assert fap.getMorphAnalysis() == "urn:cite:morph:form.cv00000"

  }
}
