package edu.holycross.shot.jmorph


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
    }

    gkstr.vowel.each { v ->
      assert gkstr.isAlphabetic(v)
    }

    gkstr.breathing.each { breath ->
      assert gkstr.isAccentBreathing(breath)
    }

    gkstr.accent.each { acc ->
      assert gkstr.isAccentBreathing(acc)
    }


  }



}