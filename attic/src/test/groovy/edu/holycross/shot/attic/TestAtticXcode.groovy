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
  void testBreathings() {
    // source string:
    String ascii = "EDOXSEN"
    // unicode conversion:
    String ucode = "ἐδοχσεν"
    // roundtripping adds initial breathing:
    String expected = "EDOXSEN"

    assert ucode == AtticString.ucodeForAscii(ascii)
    assert AtticString.asciiForUcode(ucode) == expected


    // behavior of transcoding in AtticWord class regarding accents and breathings:
    AtticWord unacc = new AtticWord(AtticString.asciiForUcode(ucode))
    String accentString = unacc.accent(AccentPattern.RECESSIVE)
    AtticWord accented = new AtticWord(accentString)
    String expectedAscii = "E/DOXSEN"
    String expectedUcode = "ἔδοχσεν"
    assert accented.toString()  == expectedAscii
    assert accented.toString(true) == expectedUcode
    


  }

}
