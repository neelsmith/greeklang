package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test

/** Class tests identifying fraction component of a 
 * MilesianString only containing a fraction component.
 */
class TestMilParts extends GroovyTestCase {

  String longStr = "ε' 𐅵 δ" + '"'
  String intStr = "ε'"

  String shortStr = "ε"

  /*void  testLongStr() {

    MilesianString multiPart = new MilesianString(longStr)
    System.err.println "Got MilStr for longStr"
    System.err.println  "Its integer component is " +  multiPart.getIntegerPart()
    assert  multiPart.getIntegerPart() == intStr
  }

  */    
  void  testShortStr() {
    MilesianString onePart = new MilesianString(shortStr)
    System.err.println "testshortSTr: created milesian string for "  + shortStr
    System.err.println  "From ${shortStr}, integer component is " +  onePart.getIntegerPart()

    assert onePart.getIntegerPart() == 'ε'
  }

}