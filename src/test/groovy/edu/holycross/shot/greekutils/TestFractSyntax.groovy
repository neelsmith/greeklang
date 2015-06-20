package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestFractSyntax extends GroovyTestCase {

  String half = '𐅵"'


  void  testAbbr() {
    MilesianString ms = new MilesianString(half)
    System.err.println  "\n\nNOW GET HALF:"
    //assert ms.getFractionPart() == half
  }

  

}