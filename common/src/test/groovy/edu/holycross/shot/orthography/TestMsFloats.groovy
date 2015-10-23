package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestMsFloats {




  @Test void testConverting() {
    GreekMsString msString = new GreekMsString("ἀ̄λλ'", "Unicode")
    String expectedAscii = "a)_ll'"
    assert msString.toString(false) == expectedAscii
  }


}
