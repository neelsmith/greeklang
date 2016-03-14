package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestIntParts {


  String third = 'γ"'
  String longStr = '𐅵 δ"'

  @Test void  testSimpleFract() {
    /*
    System.err.println "\n\n-->"
    System.err.println "third has " + third.codePointCount(0,third.length()) + " code points for length " + third.length()
    */
    MilesianString msThird = new MilesianString(third)
    assert msThird.getFractionPart() == third

  }

  @Test void  testLongFract() {
    /*
    System.err.println "longStr has " + longStr.codePointCount(0,longStr.length()) + " code points for length " + longStr.length()
    */

    MilesianString msLong = new MilesianString(longStr)
    assert msLong.getFractionPart() == longStr
  }

}
