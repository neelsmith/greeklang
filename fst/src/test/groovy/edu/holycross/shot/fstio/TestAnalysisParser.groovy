package edu.holycross.shot.fstio

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

//<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>

class TestAnalysisParser {

  @Test
  void testParser() {
    String infin = "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
    FstAnalysisParser fap = new FstAnalysisParser(infin)
    assert fap.getStem() == "<coretests.n64316_0>"
    assert fap.getLexicalEntity() == "<lexent.n64316>"
    assert fap.getInflectionalPattern() == "<w_indicative.1>" ///"<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
    assert fap.getPos() == "<verb>"


  }
}
