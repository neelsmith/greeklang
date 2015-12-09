package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestAtticAccents{


  @Test
  void testAsciiAccentedVowels() {
    String accented = "BOLE=S"
    String expectedMock = "BOLε͂S"
    String adjusted = AtticString.asciiVowelAccToUni(accented)
    assert adjusted == expectedMock
    assert AtticString.adjustVowelAccentCombo(accented, false) == expectedMock


    String article = "TO="
    String expected =  "Tο͂"
    String adjustedArticle = AtticString.asciiVowelAccToUni(article)
    assert adjustedArticle == expected
    assert AtticString.adjustVowelAccentCombo(article, false) == expected

  }


  @Test
  void testUnicodeAccentedVowels() {
    String uniInput = "βολε͂ς"
    String expected1 = "βολE=ς"
    assert  AtticString.adjustVowelAccentCombo(uniInput, true) == expected1

    String article = "το͂"
    String expected2 = "τO="
    assert  AtticString.adjustVowelAccentCombo(article, true) == expected2
  }


}
