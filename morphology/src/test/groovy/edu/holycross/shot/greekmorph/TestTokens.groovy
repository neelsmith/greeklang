package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestTokens {

  @Test
  void testStruct () {
    String surface = "λύω"
    String expectedFst = "luw"
    FstToken fstToken = new FstToken(surface)

    assert fstToken.getFstStr() == expectedFst
  }
}
