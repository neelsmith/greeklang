package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestDigitSeq extends GroovyTestCase {


  String badSeq = "ετ"

  void  testSeq() {

    assert shouldFail {
      MilesianString ms = new MilesianString(badSeq)
    }
    //MilesianInteger mi = new MilesianInteger(ms.getIntegerPart())
    //println "For sting ${badSeq}, integer is " + mi

    
  }



}