package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestWordContents extends GroovyTestCase {


  String testString = "mh=nin"

  void testConstructor() {
    GreekWord gkstr = new GreekWord(testString)

    assert shouldFail {
      GreekWord notAWord = new GreekWord("123")
    }
  }



}