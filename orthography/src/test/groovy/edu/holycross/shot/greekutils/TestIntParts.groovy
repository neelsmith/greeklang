package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestIntParts extends GroovyTestCase {


  String third = 'γ"'
  String longStr = '𐅵 δ"'

  void  testSimpleFract() {
    System.err.println "\n\n-->"
    System.err.println "third has " + third.codePointCount(0,third.length()) + " code points for length " + third.length()

    MilesianString msThird = new MilesianString(third)
    assert msThird.getFractionPart() == third
    System.err.println "And constructs properly"
  }

  void  testLongFract() {
    System.err.println "longStr has " + longStr.codePointCount(0,longStr.length()) + " code points for length " + longStr.length()
    
    
    MilesianString msLong = new MilesianString(longStr)
    assert msLong.getFractionPart() == longStr
  }

}