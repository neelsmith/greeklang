package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestDecimals extends GroovyTestCase {

  String longStr = "ε' 𐅵 δ" + '"'
  String fract = '𐅵 δ"'



  void testFractions() {
    MilesianFraction mf = new MilesianFraction(fract)
    println "${fract} == " + mf.getFractionValue()

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
  void testLongStr() {
    MilesianString multiPart = new MilesianString(longStr)
    assert MilesianInteger.toInteger(multiPart.mInt.codePoints) == 5
    assert multiPart.getFractionPart() == fract
        
    println "Fractional part == " +  multiPart.mFract.getFractionValue()
    
    //assert multiPart.toDecimal() == 5.75
  }

}