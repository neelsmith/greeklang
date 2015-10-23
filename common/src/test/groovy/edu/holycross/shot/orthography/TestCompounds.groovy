package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestCompounds  {


  String compound = "δ' " + 'β ιβ"'


  @Test
  void  testSimpleFracts() {
    MilesianString ms = new MilesianString(compound)
    println "Transcription is " + ms.xscribe()
  }



}
