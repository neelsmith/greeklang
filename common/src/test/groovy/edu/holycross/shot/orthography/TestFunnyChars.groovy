package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFunnyChars {

  @Test
  void testIotaSub() {
    String testUnicode = "λόγῳ"
    String testBeta = "lo/gw|"

    GreekString uniGreek = new GreekString(testUnicode, "Unicode")
    GreekString betaGreek = new GreekString(testBeta)
    assert uniGreek.toString() == betaGreek.toString()
  }



  @Test
  void testDiaeresis() {
    String testUnicode = "πηληϊάδεω"
    String testBeta = "phlhi+a/dew"

    GreekString uniGreek = new GreekString(testUnicode, "Unicode")
    GreekString betaGreek = new GreekString(testBeta)
    assert uniGreek.toString() == betaGreek.toString()
  }
}
