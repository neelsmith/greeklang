package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestMilStr {

  String highVal = "𐅵"
  String one = "α"

  @Test
  void testIntConstr() {
    MilesianString msOne = new MilesianString(one)
    assert msOne.hasFraction() == false
    assert msOne.toDecimal() == 1
  }



   @Test void testUniBMP() {
    MilesianString msHigh = new MilesianString(highVal)
    assert msHigh.hasFraction()
    assert msHigh.toDecimal() == 0.5
  }

}
