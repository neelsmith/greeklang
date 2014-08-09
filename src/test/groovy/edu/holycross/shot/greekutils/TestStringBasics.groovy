package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestStringBasics extends GroovyTestCase {


  String testString = "mh=nin"

  void testStatic() {

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

    assert GreekString.containsVowel(testString)
    
    
  }



}