package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestSyllables extends GroovyTestCase {




  void testSimple() {
    String testString = "mh=nin"
    def expected = ["mh=", "nin"]

    assert GreekWord.getSyllables(testString) == expected

    GreekWord gkstr = new GreekWord(testString)
    assert gkstr.getSyllables() == expected
  }

  void testBreathingDiphthSeq() {
    String testString = "a)/eide"
    def expected = ["a)/", "ei", "de"]

    assert GreekWord.getSyllables(testString) == expected

    GreekWord gkstr = new GreekWord(testString)
    assert gkstr.getSyllables() == expected
  }

  void testBreathingSeq() {
    String testString = "qea/"
    def expected = ["qe", "a/"]

    assert GreekWord.getSyllables(testString) == expected

    GreekWord gkstr = new GreekWord(testString)
    assert gkstr.getSyllables() == expected

  }
}