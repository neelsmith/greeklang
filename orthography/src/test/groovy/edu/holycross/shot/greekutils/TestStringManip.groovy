package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestStringManip extends GroovyTestCase {

  void testUnicode() {
    String src = "mh=nin"
    String expected = "mhnin"
    assert GreekString.stripAccents(src) == expected
  }

  void testDefault() {
  }



}