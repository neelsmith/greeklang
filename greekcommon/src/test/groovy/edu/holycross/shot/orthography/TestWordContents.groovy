package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestWordContents {


  String testString = "mh=nin"

  @Test void testConstructor() {
    GreekWord gkstr = new GreekWord(testString)

    assert shouldFail {
      GreekWord notAWord = new GreekWord("123")
    }
  }



}
