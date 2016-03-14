package edu.holycross.shot.phonology

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestBasicAccents {

  @Test
  void testSyll() {
    assert Accent.accentSyllable("os", "/") == "o/s"

    assert shouldFail {
      String noVowel = Accent.accentSyllable("d'", "/")
    }
  }

  @Test
  void testSyllWQuantity() {
    assert Accent.accentSyllable("lu_", "=") == "lu_="
  }
}
