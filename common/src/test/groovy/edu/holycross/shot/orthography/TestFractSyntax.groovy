package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFractSyntax {

  String half = '𐅵"'


  @Test void  testAbbr() {
    MilesianString ms = new MilesianString(half)
    // fractional value without integer component,
    // so fraction part should == original input string:
    assert ms.getFractionPart() == half
  }



}
