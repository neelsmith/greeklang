package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestMilParts extends GroovyTestCase {

  String longStr = "ε' 𐅵 δ" + '"'
  String fract = '𐅵 δ"'
  
  String intStr = "ε'"
  String shortStr = "ε"

  /** Tests string with both integer and fraction components*/
  void testLongStr() {
    MilesianString multiPart = new MilesianString(longStr)
    assert  multiPart.getIntegerPart() == intStr
    assert  multiPart.getFractionPart() == fract
  }


  /** Tests string with fraction component only.*/
  void testFractStr() {
    MilesianString fractPart = new MilesianString(fract)
    assert fractPart.getFractionPart() == fract
  }

  
  /** Tests string with integer value only, no
   * explicit terminator. */
  void  testShortStr() {
    MilesianString onePart = new MilesianString(shortStr)
    assert onePart.getIntegerPart() == 'ε'
  }



  /** Tests string with integer value only, 
   * explicit terminator and no trailing space. */
  void  testIntStr () {
    MilesianString onePart = new MilesianString(intStr)
    assert onePart.getIntegerPart() ==  "ε'"
  }

}