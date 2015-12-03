package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.phonology.AccentPattern

class TestHighLevelAccentMethods {


  @Test
  void testRecessiveAttic() {
    AtticWord proparoxytone = new AtticWord("ANQRO_PO^S")
    String expectedProparoxytone = "A/NQRO_PO^S"
    AtticWord antepenult =  proparoxytone.accent(AccentPattern.RECESSIVE)
    assert antepenult.toString() == expectedProparoxytone
  }


/*
  @Test
    void testLongshortAttic() {
      AtticWord demos = new AtticWord("DE_MO^S")
      String expectedResult = "DE_=MO^S"
      AtticWord accented =  demos.accent(AccentPattern.PENULT)
      assert accented.toString() == expectedResult
      // also works with static method:
      assert Accent.accentWord(wrath, AccentPattern.PENULT) == expectedResult
    }*/

}
