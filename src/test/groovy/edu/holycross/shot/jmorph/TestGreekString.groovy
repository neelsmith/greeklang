package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestGreekString extends GroovyTestCase {

  void testConstructor() {
    GreekString gkstr = new GreekString("mh=nin")
    assert gkstr
    
    assert shouldFail {
      GreekString bogus= new GreekString("123")
    }
  }


  void testCharClass() {
    GreekString gkstr = new GreekString("mh=nin")

    gkstr.consonant.each { c ->
      assert gkstr.isAlphabetic(c)
    }

    gkstr.vowel.each { v ->
      assert gkstr.isAlphabetic(v)
    }

    
  }

}