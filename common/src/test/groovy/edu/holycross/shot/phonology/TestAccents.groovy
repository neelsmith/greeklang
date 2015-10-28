package edu.holycross.shot.phonology

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestAccents {


  @Test
  void testRecessive() {
    GreekWord proparoxytone = new GreekWord("luomenos")
    String expectedProparoxytone = "luo/menos"
    GreekWord antepenult =  Accent.addRecessiveAccent(proparoxytone)
    assert antepenult.toString() == expectedProparoxytone

    GreekWord paroxytone = new GreekWord("paideuein")
    String expectedParoxytone = "paideu/ein"
    GreekWord penult =  Accent.addRecessiveAccent(paroxytone)
    assert penult.toString() == expectedParoxytone

    GreekWord paroxytone2 = new GreekWord("h(ra_")
    String expectedParoxytone2 = "h(/ra_"
    GreekWord penult2 =  Accent.addRecessiveAccent(paroxytone2)
    assert penult2.toString() == expectedParoxytone2
  }

  @Test
  void testRecessive2() {
    GreekWord proparoxytone = new GreekWord("paideue")
    String expectedProparoxytone = "pai/deue"
    GreekWord antepenult =  Accent.addRecessiveAccent(proparoxytone)
    assert antepenult.toString() == expectedProparoxytone

    GreekWord paroxytone = new GreekWord("lu_e")
    String expectedParoxytone = "lu_=e"
    GreekWord penult =  Accent.addRecessiveAccent(paroxytone)
    assert penult.toString() == expectedParoxytone
  }

  @Test
  void testPenult() {
    GreekWord tooShort = new GreekWord("kai")
    assert shouldFail {
      GreekWord hopeless = Accent.addPenultAccent(tooShort)
    }
  }
}
