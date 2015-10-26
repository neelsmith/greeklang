package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestSyllables {




  @Test void testSimple() {
    String testString = "mh=nin"
    def expected = ["mh", "nin"]

    assert GreekWord.getSyllables(testString) == expected

    GreekWord gkstr = new GreekWord(testString)
    assert gkstr.getSyllables() == expected
  }

  @Test void testBreathingDiphthSeq() {
    String testString = "a)/eide"
    def expected = ["a)", "ei", "de"]

    assert GreekWord.getSyllables(testString) == expected

    GreekWord gkstr = new GreekWord(testString)
    assert gkstr.getSyllables() == expected
  }

  @Test void testBreathingSeq() {
    String testString = "qea/"
    def expected = ["qe", "a"]

    assert GreekWord.getSyllables(testString) == expected

    GreekWord gkstr = new GreekWord(testString)
    assert gkstr.getSyllables() == expected

  }
}
