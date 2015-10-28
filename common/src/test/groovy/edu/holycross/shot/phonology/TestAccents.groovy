package edu.holycross.shot.phonology


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestAccents {

  @Test
  void testSyll() {
    assert Accent.accentSyllable("os", "/") == "o/s"
  }
}
