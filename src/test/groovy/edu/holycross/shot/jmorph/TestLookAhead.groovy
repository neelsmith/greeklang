package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestLookAhead extends GroovyTestCase {




  void testSimple() {
    String testString = "mh=nin"
    GreekWord gkstr = new GreekWord(testString)


    
    assert gkstr.countToInclude(testString,1) == 1
    assert gkstr.countToInclude(1) == 1

    assert gkstr.countToInclude(testString,4) == 0
    assert gkstr.countToInclude(4) == 0

    assert shouldFail {
      gkstr.countToInclude(testString,0)
    }
    assert shouldFail {
      gkstr.countToInclude(0)
    }
  }




}