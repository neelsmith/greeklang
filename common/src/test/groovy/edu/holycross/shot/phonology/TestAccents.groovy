package edu.holycross.shot.phonology


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestAccents {

  @Test
  void testSyll() {
    assert Accent.accentSyllable("os", "/") == "o/s"

    assert shouldFail {
      String noVowel = Accent.accentSyllable("d'", "/")
    }
  }

  @Test
  void testRecessive() {
    GreekWord proparoxytone = new GreekWord("luomenos")
    String expectedProparoxytone = "luo/menos"
    GreekWord antepenult =  Accent.addRecessiveAccent(proparoxytone)
    //assert antepenult.toString() == expectedProparoxytone

    GreekWord paroxytone = new GreekWord("paideuein")
    String expectedParoxytone = "paideu/ein"
    GreekWord penult =  Accent.addRecessiveAccent(paroxytone)
    assert penult.toString() == expectedParoxytone

  }

}
