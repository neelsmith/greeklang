package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestMilStr extends GroovyTestCase {

  String highVal = "𐅵"
  String one = "α"
  void  testConstr() {

    MilesianString msOne = new MilesianString(one)
    println "Got MilStr for one"
    //    MilesianString msHigh = new MilesianString(highVal)
    // println "Got MilStr for 1/2"
  }

}