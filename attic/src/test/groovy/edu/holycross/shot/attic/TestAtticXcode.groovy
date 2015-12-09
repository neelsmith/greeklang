package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


import edu.holycross.shot.phonology.AccentPattern

class TestAtticXcode{


  @Test
  void testAsciiAccentedVowels() {
    String ascii = "BOLE=S"
    String ucode = "βολε͂ς"

    assert ucode == AtticString.ucodeForAscii(ascii)
    assert ascii == AtticString.asciiForUcode(ucode)
  }

  @Test
  void testSmoothBreathings() {
    // source string:
    String ascii = "EDOXSEN"
    // unicode conversion:
    String ucode = "ἐδοχσεν"

    // note treatment of smooth breathing
    assert ucode == AtticString.ucodeForAscii(ascii)
    assert AtticString.asciiForUcode(ucode) == ascii


    // behavior of transcoding in AtticWord class regarding accents and breathings:
    AtticWord unacc = new AtticWord(AtticString.asciiForUcode(ucode))
    String accentString = unacc.accent(AccentPattern.RECESSIVE)
    AtticWord accented = new AtticWord(accentString)
    String expectedAscii = "E/DOXSEN"
    String expectedUcode = "ἔδοχσεν"
    assert accented.toString()  == expectedAscii
    assert accented.toString(true) == expectedUcode

  }
  @Test
  void testRoughBreathings() {
    // source string:
    String ascii = "HOTOS"
    String ucode = "ὁτος"
    assert ucode == AtticString.ucodeForAscii(ascii)
    assert AtticString.asciiForUcode(ucode) == ascii
  }
}
