package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestStripAccs {

  @Test
  void testStripAcc() {
    GreekWord gw = new GreekWord("mh=nin")
    String expected = "mhnin"
    assert gw.stripAccents().toString() == expected
  }
}
