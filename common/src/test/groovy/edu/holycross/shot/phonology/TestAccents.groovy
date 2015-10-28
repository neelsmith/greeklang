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


    GreekWord paroxytone2 = new GreekWord("h(ra_")
    String expectedParoxytone2 = "h(/ra_"
    GreekWord penult2 =  Accent.addRecessiveAccent(paroxytone2)
    assert penult2.toString() == expectedParoxytone2
  }

}
