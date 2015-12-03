package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestAtticAccents{


  @Test
  void testAsciiAccentedVowels() {
    String accented = "BOLE=S"
    String expectedMock = "BOLε͂S"
    String adjusted = AtticString.adjustVowelAcc(accented)
    assert adjusted == expectedMock



    String article = "TO="
    String expected =  "Tο͂"
    String adjustedArticle = AtticString.adjustVowelAcc(article)
    assert adjustedArticle == expected
  }


  @Test
  void testUnicodeAccentedVowels() {
    String uniInput = "βολε͂ς"
    String expected1 = "βολE=ς"
    assert  AtticString.adjustVowelAcc(uniInput, true) == expected1

    String article = "το͂"
    String expected2 = "τO="
    assert  AtticString.adjustVowelAcc(article, true) == expected2
  }


}
