package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestDecimals {

  String longStr = "ε' 𐅵 δ" + '"'
  String fract = '𐅵 δ"'


  @Test
  void testFractions() {
    MilesianFraction mf = new MilesianFraction(fract)
    assert mf.getFractionValue() == 0.75

    String third = 'γ"'
    mf  = new MilesianFraction(third)
    assert mf.getFractionValue() == 0.333
    assert mf.getFractionValue(4) == 0.3333


    String expan = 'β δ"'
    mf  = new MilesianFraction(expan)
    assert mf.getFractionValue() == 0.75
    assert mf.getFractionValue(4) == 0.75
  }



  /** Tests string with both integer and fraction components*/
  @Test void testLongStr() {
    MilesianString multiPart = new MilesianString(longStr)
    assert MilesianInteger.toInteger(multiPart.mInt.codePoints) == 5
    assert multiPart.getFractionPart() == fract
    assert multiPart.toDecimal() == 5.75
    }

}
