package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestCompounds  {


  String compound = "δ' " + 'β ιβ"'


  @Test
  void  testSimpleFracts() {
    MilesianString ms = new MilesianString(compound)
    String expectedXscript = "4 1/2 + 1/12"
    assert ms.xscribe() == expectedXscript
  }



}
