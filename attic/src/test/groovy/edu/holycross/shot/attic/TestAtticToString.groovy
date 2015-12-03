package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestAtticToString {


  //  test all 3 constructors
  @Test
  void testConstructors() {

    AtticString atticAscii = new AtticString("BOLE")
    assert atticAscii.toString(true) == "βολε"


    AtticString atticUcode = new AtticString("βολε", true)
    assert atticUcode.toString() == "BOLE"

    // explicitly require valid input:
    AtticString accented = new AtticString("βολε͂", true, false)

    assert accented.toString() == "BOLE="

  }

}
