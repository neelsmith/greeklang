package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestAsciify extends GroovyTestCase {



  
  
  void testStaticPunctSigns() {
    [ "\u0387", "⁑" , "⁚"].each { punctSign ->
      assert GreekMsString.isMsPunctuation(punctSign)
      assert GreekMsString.isValidMsChar(punctSign)
    }
  }

  void testStaticBreathQuant() {

    ["\u0300", "\u0304", "\u0306", "\u0308"].each { mark ->
      assert GreekMsString.isMsQuantityOrBreathing(mark)
      assert GreekMsString.isValidMsChar(mark)
    }
  }
  
  
  void testBadPunctSigns() {
    // Arabic hamza not allowed:
    String hamza = "ء"
    assert GreekMsString.isMsPunctuation(hamza) == false
    assert GreekMsString.isValidChar(hamza) == false
  }
  


}