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

    //AtticWord unacc = new AtticWord(AtticString.asciiForUcode(ucode))
    //System.err.println "Add recessive " + unacc.accent(AccentPattern.RECESSIVE)

    //accent(AccentPattern.RECESSIVE)
  }

}
