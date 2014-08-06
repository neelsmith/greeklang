package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestGreekString extends GroovyTestCase {


  String testString = "mh=nin"

  void testConstructor() {
    GreekString gkstr = new GreekString(testString)
    assert gkstr.toString() == testString
    
    assert shouldFail {
      GreekString bogus= new GreekString("123")
    }
  }


  void testCharClass() {
    GreekString gkstr = new GreekString(testString)

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