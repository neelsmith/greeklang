package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestAtticToString{


  @Test
  void testAsciiAccentedVowels() {
    String accented = "BOLE=S"
    String expectedMock = "BOLÊS"
    String adjusted = AtticString.adjustVowelAcc(accented)
    assert adjusted == expectedMock



    String article = "TO="
    String expected =  "TÔ"
    String adjustedArticle = AtticString.adjustVowelAcc(article)
    assert adjustedArticle == expected
  }


  void testUnicodeAccentedVowels() {
        String uniInput = "βουλêς"
        System.err.println "boule: " + uniInput + " -> " + AtticString.adjustVowelAcc(uniInput, true)
  }

  // must test all 3 constructors
  @Test
  void testUniInput() {
    AtticString attic = new AtticString("βολε", true)
    assert attic.toString() == "BOLE"

    AtticString accented = new AtticString("βολê", true, true)
    System.err.println "βολê -> " + accented.toString()
  }

}
