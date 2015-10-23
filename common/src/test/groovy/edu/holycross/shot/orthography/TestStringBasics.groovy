package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.phonology.Phonology


class TestStringBasics {




  @Test void testStaticMethods() {

    assert Phonology.vowel.size() == 8
    Phonology.vowel.each { v ->
      assert GreekString.isAlphabetic(v)
      assert GreekString.isVowel(v)
      assert GreekString.containsVowel(v)
    }

    assert Phonology.consonant.size() == 17
    Phonology.consonant.each { c ->
      assert GreekString.isAlphabetic(c)
    }

    assert Phonology.breathing.size() == 2
    Phonology.breathing.each { breath ->
      assert GreekString.isAccentOrBreathing(breath)
      assert GreekString.isAlphabetic(breath) == false
    }


    assert Phonology.accent.size() == 3
    Phonology.accent.each { acc ->
      assert GreekString.isAccentOrBreathing(acc)
      assert GreekString.isAlphabetic(acc) == false
    }


    assert Phonology.diphthong.size() == 11
    Phonology.diphthong.each { dip ->
      assert GreekString.isDiphthong(dip)
    }


    assert Phonology.quantity.size() == 2
    Phonology.quantity.each { q ->
      assert GreekString.isQuantity(q)
    }



    Phonology.punctuation.each { punct ->
      assert GreekString.isPunctuation(punct)
    }


    String testString = "mh=nin"
    assert GreekString.containsVowel(testString)


  }



}
