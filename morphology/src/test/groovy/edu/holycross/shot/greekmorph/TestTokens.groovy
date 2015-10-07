package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestTokens {

  @Test
  void testStruct () {
    GreekString surface = new GreekString("λύω","Unicode")
    String expectedFst = new GreekString("luw")
    FstToken fstToken = new FstToken(surface)

    assert fstToken.getFstStr().toString() == expectedFst.toString()
  }

}
