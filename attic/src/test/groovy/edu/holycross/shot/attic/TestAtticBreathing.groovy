package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


import edu.holycross.shot.phonology.AccentPattern

class TestAtticBreathing{


  @Test
  void testSimple () {
    String src = "EDOXSEN"
    String expectedUcode = "ἐδοχσεν"
    assert AtticString.ucodeForAscii(src) == expectedUcode
    assert AtticString.asciiForUcode(expectedUcode) == src
  }


  @Test
  void testDiphthong () {
    String src = "AIEI"
    String expectedUcode = "αἰει"
    assert AtticString.ucodeForAscii(src) == expectedUcode
    assert AtticString.asciiForUcode(expectedUcode) == src
  }


  @Test
  void testRough () {
    String src = "HODOS"
    String expectedUcode = "ὁδος"

    assert AtticString.ucodeForAscii(src) == expectedUcode
    assert AtticString.asciiForUcode(expectedUcode) == src
  }
}
