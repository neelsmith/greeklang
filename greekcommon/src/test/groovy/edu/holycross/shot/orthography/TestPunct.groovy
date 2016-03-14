package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestPunct {

  // the four standard punctuation marks:
  String asciiPunct = ".;:,a"
  String uniPunct = ".;·,α"

  @Test void testPunctuation() {
    GreekString asciiGreek = new GreekString(asciiPunct)
    GreekString uniGreek = new GreekString(uniPunct,true)

    // Test 1: both inputs yield identical ascii-only
    // transcription:
    assert uniGreek.toString() == asciiGreek.toString()

    // Test 2: both inputs yield identical Unicode Greek
    // transcription:
    assert uniGreek.toString(true) == asciiGreek.toString(true)

  }





}
