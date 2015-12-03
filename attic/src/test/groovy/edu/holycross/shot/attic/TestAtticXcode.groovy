package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestAtticXcode{


  @Test
  void testAsciiAccentedVowels() {
    String ascii = "BOLE=S"
    String ucode = "βολε͂ς"

    assert ucode == AtticString.ucodeForAscii(ascii)
    assert ascii == AtticString.asciiForUcode(ucode)
  }


}
