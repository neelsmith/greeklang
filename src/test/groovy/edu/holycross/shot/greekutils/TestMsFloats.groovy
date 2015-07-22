package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestMsFloats extends GroovyTestCase {




  void testConverting() {
    GreekMsString msString = new GreekMsString("ἀ̄λλ'", "Unicode")
    String expectedAscii = "a)_ll'"
    assert msString.toString(false) == expectedAscii
  }
  

}