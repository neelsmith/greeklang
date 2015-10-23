package edu.holycross.shot.greekutils

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestDigitSeq {


  String badSeq = "ετ"

  @Test void  testSeq() {

    assert shouldFail {
      MilesianString ms = new MilesianString(badSeq)
    }
    //MilesianInteger mi = new MilesianInteger(ms.getIntegerPart())
    //println "For sting ${badSeq}, integer is " + mi


  }



}
