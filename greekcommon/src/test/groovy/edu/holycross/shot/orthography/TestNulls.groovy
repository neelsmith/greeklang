package edu.holycross.shot.orthography


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

/** Class tests behavior of null Strings.
 */
class TestNulls {

  @Test
  void testNullGreekString() {
    // initialization from null strings is allowed:
    GreekString gs = new GreekString("")
    // toString() should return empty strings:
    assert gs.toString().size() == 0
    assert gs.toString(true).size() == 0

    GreekString nullUnicode = new GreekString("", true)
    assert nullUnicode.toString().size() == 0

  }
}
