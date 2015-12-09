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


    AtticWord decided = new AtticWord("EDOXSEN")
    String expectedAccString = "E/DOXSEN"
    AtticWord accWord =  decided.accent(AccentPattern.RECESSIVE)
    assert accWord.toString() == expectedAccString
  }



  @Test
    void testLongshortAttic() {
      AtticWord demos = new AtticWord("DE_MO^S")
      String expectedResult = "DE_=MO^S"
      AtticWord accented =  demos.accent(AccentPattern.PENULT)
      assert accented.toString() == expectedResult
      // also works with static method:
      assert AtticAccent.accentWord(demos, AccentPattern.PENULT).toString() == expectedResult
    }

    @Test
      void testShortLong() {
        AtticWord victory = new AtticWord("NI^KE_")
        String expectedResult = "NI^/KE_"
        AtticWord accented =  victory.accent(AccentPattern.PENULT)
        assert accented.toString() == expectedResult
        // also works with static method:
        assert AtticAccent.accentWord(victory, AccentPattern.PENULT).toString() == expectedResult
      }

}
