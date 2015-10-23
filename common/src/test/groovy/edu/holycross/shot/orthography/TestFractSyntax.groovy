package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFractSyntax {

  String half = '𐅵"'


  @Test void  testAbbr() {
    MilesianString ms = new MilesianString(half)
    System.err.println  "\n\nNOW GET HALF:"
    //assert ms.getFractionPart() == half
  }



}
