package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestSyllables extends GroovyTestCase {




  void testSimple() {
    String testString = "mh=nin"
    def expected = ["mh=", "nin"]

    GreekString gkstr = new GreekString(testString)
    def actualSyllables = gkstr.getSyllables()

    assert actualSyllables == expected
  }

  void testBreathingDiphthSeq() {
    String testString = "a)/eide"
    def expected = ["a)/", "ei", "de"]
    GreekString gkstr = new GreekString(testString)

    gkstr.debugLevel = 3
    def actualSyllables = gkstr.getSyllables()

    assert actualSyllables == expected
  }

  void testBreathingSeq() {
    String testString = "qea/"
    def expected = ["qe", "a/"]
    GreekString gkstr = new GreekString(testString)
    def actualSyllables = gkstr.getSyllables()
    assert actualSyllables == expected
  }
}