package edu.holycross.shot.greekutils

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestMsPunct {



  @Test void testStaticPunctSigns() {
    [ "\u0387", "⁑" , "⁚", "‡"].each { punctSign ->
      assert GreekMsString.isMsPunctuation(punctSign)
      assert GreekMsString.isValidMsChar(punctSign)
    }
  }

  @Test void testStaticBreathQuant() {
    ["\u0300", "\u0304", "\u0306", "\u0308"].each { mark ->
      assert GreekMsString.isMsQuantityOrBreathing(mark)
      assert GreekMsString.isValidMsChar(mark)
    }
  }


  @Test void testBadPunctSigns() {
    // Arabic hamza not allowed:
    String hamza = "ء"
    assert GreekMsString.isMsPunctuation(hamza) == false
    assert GreekMsString.isValidChar(hamza) == false
  }


}
