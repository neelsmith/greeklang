package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestCompounds extends GroovyTestCase {


  String compound = "δ' " + 'β ιβ"'



  void  testSimpleFracts() {
    MilesianString ms = new MilesianString(compound)
    println "Transcription is " + ms.xscribe()
  }

  

}