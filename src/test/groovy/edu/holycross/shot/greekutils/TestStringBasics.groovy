package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestStringBasics extends GroovyTestCase {




  void testStaticMethods() {

    assert GreekString.vowel.size() == 7
    GreekString.vowel.each { v ->
      assert GreekString.isAlphabetic(v)
      assert GreekString.isVowel(v)
      assert GreekString.containsVowel(v)
    }

    assert GreekString.consonant.size() == 17
    GreekString.consonant.each { c ->
      assert GreekString.isAlphabetic(c)
    }

    assert GreekString.breathing.size() == 2
    GreekString.breathing.each { breath ->
      assert GreekString.isAccentOrBreathing(breath)
      assert GreekString.isAlphabetic(breath) == false
    }


    assert GreekString.accent.size() == 3
    GreekString.accent.each { acc ->
      assert GreekString.isAccentOrBreathing(acc)
      assert GreekString.isAlphabetic(acc) == false
    }


    assert GreekString.diphthong.size() == 11
    GreekString.diphthong.each { dip ->
      assert GreekString.isDiphthong(dip)
    }


    assert GreekString.quantity.size() == 2
    GreekString.quantity.each { q ->
      assert GreekString.isQuantity(q)
    }



    GreekString.punctuation.each { punct ->
      assert GreekString.isPunctuation(punct)
    }


    String testString = "mh=nin"
    assert GreekString.containsVowel(testString)
    
    
  }



}