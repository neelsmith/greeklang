package edu.holycross.shot.phonology


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString
class TestPhonology {


  @Test
  void testAcc() {
    GreekString s = new GreekString("μῆνιν", "Unicode")
    GreekString noAccent = Accent.stripAccents(s)
    assert noAccent.toString() == "mhnin"
  }
}
