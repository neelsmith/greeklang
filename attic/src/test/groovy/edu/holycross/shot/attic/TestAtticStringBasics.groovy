package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestAtticStringBasics {




  @Test void testStaticMethods() {

    assert AtticPhonology.vowel.size() == 5
    AtticPhonology.vowel.each { v ->
      assert AtticString.isAlphabetic(v)
      assert AtticString.isVowel(v)
      assert AtticString.containsVowel(v)
    }

    assert AtticPhonology.consonant.size() == 16
    AtticPhonology.consonant.each { c ->
      assert AtticString.isAlphabetic(c)
    }

    assert AtticPhonology.accent.size() == 3
    AtticPhonology.accent.each { acc ->
      assert AtticString.isAlphabetic(acc) == false
    }

    assert AtticPhonology.quantity.size() == 2
    AtticPhonology.quantity.each { q ->
      assert AtticString.isQuantity(q)
    }

    AtticString.punctuation.each { punct ->
      assert AtticString.isPunctuation(punct)
    }


    String testString = "BOLE"
    assert AtticString.containsVowel(testString)

  }



}
