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



}