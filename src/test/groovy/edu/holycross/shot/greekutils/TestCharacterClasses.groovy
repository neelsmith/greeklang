package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestCharacterClasses extends GroovyTestCase {


  String testString = "mh=nin"

  void testConstructor() {
    GreekWord gkstr = new GreekWord(testString)
    assert gkstr.toString() == testString
    
    assert shouldFail {
      GreekWord bogus= new GreekWord("123")
    }
  }


  void testCharClass() {
    GreekWord gkstr = new GreekWord(testString)

    gkstr.consonant.each { c ->
      assert gkstr.isAlphabetic(c)
      assert gkstr.isVowel(c) == false
    }

    gkstr.vowel.each { v ->
      assert gkstr.isAlphabetic(v)
      assert gkstr.isVowel(v)
    }

    gkstr.breathing.each { breath ->
      assert gkstr.isAccentBreathing(breath)
      assert gkstr.isAlphabetic(breath) == false
    }

    gkstr.accent.each { acc ->
      assert gkstr.isAccentBreathing(acc)
      assert gkstr.isAlphabetic(acc) == false
    }


  }



}