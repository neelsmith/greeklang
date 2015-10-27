package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestMilStr {

  String highVal = "𐅵"
  String one = "α"
/*
  @Test
  void testIntConstr() {
    MilesianString msOne = new MilesianString(one)
    assert msOne.hasFraction() == false
    assert msOne.toDecimal() == 1
  }
*/


  @Test void testUniBMP() {
    System.err.println "Testing Unicode BMP"
    MilesianString msHigh = new MilesianString(highVal)
    println "Got MilStr for 1/2"
  }

}
