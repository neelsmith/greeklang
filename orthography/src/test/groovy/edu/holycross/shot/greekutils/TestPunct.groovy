package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestPunct extends GroovyTestCase {

  // the four standard punctuation marks:
  String asciiPunct = ".;:,a"
  String uniPunct = ".;·,α"
  
  void testPunctuation() {
    GreekString asciiGreek = new GreekString(asciiPunct)
    GreekString uniGreek = new GreekString(uniPunct,"Unicode")

    // Test 1: both inputs yield identical ascii-only
    // transcription:
    assert uniGreek.toString() == asciiGreek.toString()

    // Test 2: both inputs yield identical Unicode Greek
    // transcription:
    assert uniGreek.toString(true) == asciiGreek.toString(true)

  }



  

}