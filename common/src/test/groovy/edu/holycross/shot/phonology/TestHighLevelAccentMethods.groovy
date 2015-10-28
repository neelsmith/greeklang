package edu.holycross.shot.phonology

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


import  edu.holycross.shot.phonology.AccentPattern
import  edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestHighLevelAccentMethods {


  @Test
  void testRecessive() {
    GreekWord proparoxytone = new GreekWord("a)nqrwpos")
    String expectedProparoxytone = "a)/nqrwpos"
    System.err.println "Want to add accent to " + proparoxytone
    System.err.println "Use pattern " + AccentPattern.RECESSIVE

    //GreekWord antepenult =  proparoxytone.accent(AccentPattern.RECESSIVE)
    //assert antepenult.toString() == expectedProparoxytone
  }
}
