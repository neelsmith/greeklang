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
    GreekWord antepenult =  proparoxytone.accent(AccentPattern.RECESSIVE)
    assert antepenult.toString() == expectedProparoxytone
  }


  @Test
  void testLongshort() {
    GreekWord wrath = new GreekWord("mhnin")
    String expectedResult = "mh=nin"
    GreekWord accented =  wrath.accent(AccentPattern.PENULT)
    assert  accented.toString() == expectedResult
    // also works with static method:
    assert Accent.accentWord(wrath, AccentPattern.PENULT).toString() == expectedResult
  }


}
