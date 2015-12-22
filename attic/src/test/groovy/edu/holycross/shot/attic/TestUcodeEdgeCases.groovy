package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestUcodeEdgeCases {


  //  test all 3 constructors
  @Test
  void testConstructors() {


    AtticString atticU = new AtticString("hοδος", true)
    assert atticU.toString() == "HODOS"

    AtticString atticAscii = new AtticString("HODOS")
    assert atticAscii.toString(true) == "hοδος"


  }




}
