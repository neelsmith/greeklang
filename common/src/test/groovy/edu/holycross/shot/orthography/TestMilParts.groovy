package edu.holycross.shot.greekutils


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestMilParts {

  String longStr = "ε' 𐅵 δ" + '"'
  String fract = '𐅵 δ"'

  String intStr = "ε'"
  String shortStr = "ε"

  /** Tests string with both integer and fraction components*/
  @Test void testLongStr() {
    MilesianString multiPart = new MilesianString(longStr)
    assert  multiPart.getIntegerPart() == intStr
    assert  multiPart.getFractionPart() == fract
  }


  /** Tests string with fraction component only.*/
  @Test void testFractStr() {
    MilesianString fractPart = new MilesianString(fract)
    assert fractPart.getFractionPart() == fract
  }


  /** Tests string with integer value only, no
   * explicit terminator. */
  @Test void  testShortStr() {
    MilesianString onePart = new MilesianString(shortStr)
    assert onePart.getIntegerPart() == 'ε'
  }



  /** Tests string with integer value only,
   * explicit terminator and no trailing space. */
  @Test void  testIntStr () {
    MilesianString onePart = new MilesianString(intStr)
    assert onePart.getIntegerPart() ==  "ε'"
  }

}
