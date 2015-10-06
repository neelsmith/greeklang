package edu.holycross.shot.greekutils

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestMilStr {

  String highVal = "𐅵"
  String one = "α"
  @Test void  testConstr() {

    MilesianString msOne = new MilesianString(one)
    println "Got MilStr for one"
    //    MilesianString msHigh = new MilesianString(highVal)
    // println "Got MilStr for 1/2"
  }

}
