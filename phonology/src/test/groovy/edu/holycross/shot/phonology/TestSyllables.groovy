package edu.holycross.shot.phonology


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.greekutils.GreekWord

class TestSyllables {

  // map of input strings to expected values
  def testMap = [
  "poios"  : "poi#os"
  ]

  @Test
  void testSyllables() {
    testMap.each { m ->
      GreekWord gw = new GreekWord(m.key)
      assert Syllabifier.getSyllablicString(gw) == m.value
    }
  }
}
