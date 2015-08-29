package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestLookAhead extends GroovyTestCase {




  void testSimple() {
    String testString = "mh=nin"
    GreekWord gkstr = new GreekWord(testString)

    
    assert GreekWord.countToInclude(testString,1) == 1
    assert gkstr.countToInclude(1) == 1

    assert GreekWord.countToInclude(testString,4) == 0
    assert gkstr.countToInclude(4) == 0

    assert shouldFail {
      GreekWord.countToInclude(testString,0)
    }
    assert shouldFail {
      gkstr.countToInclude(0)
    }
  }




}