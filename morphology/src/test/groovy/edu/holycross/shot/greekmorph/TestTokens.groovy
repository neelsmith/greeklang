package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

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

  @Test
  void testBreathing() {
    GreekString surface = new GreekString("ἔλυσα","Unicode")
    String expectedFst = "e<sm>lusa"
    FstToken fstToken = new FstToken(surface)
    assert fstToken.getFstStr().toString() == expectedFst

    GreekString surface2 = new GreekString("αἱρέω","Unicode")
    String expected2 = "ai<ro>rew"
    FstToken fstToken2 = new FstToken(surface2)
    assert fstToken2.getFstStr().toString() == expected2
  }



}
