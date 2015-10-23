package edu.holycross.shot.phonology


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.greekutils.GreekWord
import edu.holycross.shot.greekutils.GreekString
class TestPhonology {


  @Test
  void testAcc() {
    GreekString s = new GreekString("μῆνιν", "Unicode")
    println Phonology.stripAccents(s)
  }
}
