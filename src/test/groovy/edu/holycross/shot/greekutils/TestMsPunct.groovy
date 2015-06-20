package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestMsPunct extends GroovyTestCase {

  String eoSchol = "⁑"
  String floatingGrave = "`"
  
  //    "·", "⁑" , "⁚"
  void testStaticPunctSigns() {
    assert GreekMsString.isMsPunctuation(eoSchol)
    assert GreekMsString.isValidMsChar(eoSchol)
  }


  void testStaticBreathQuatn() {
    assert GreekMsString.isMsQuantityOrBreathing(floatingGrave)
    assert GreekMsString.isValidMsChar(eoSchol)
  }
  
  
  void testBadPunctSigns() {
    // Arabic hamza not allowed:
    String hamza = "ء"
    assert GreekMsString.isMsPunctuation(hamza) == false
    assert GreekMsString.isValidChar(hamza) == false
  }
  
  void testInstance() {
    GreekMsString greekEoSchol = new GreekMsString(eoSchol, "Unicode")
    assert greekEoSchol.toString() == eoSchol
  }



}