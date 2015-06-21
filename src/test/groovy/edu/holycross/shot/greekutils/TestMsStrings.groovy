package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestMsStrings extends GroovyTestCase {



  
  void testInstance() {
    String eoSchol = "⁑"
    GreekMsString greekEoSchol = new GreekMsString(eoSchol, "Unicode")
    assert greekEoSchol.toString() == eoSchol
  }



  void testCombos() {
    String macronCombo = "ἀ̄λλ'"
    GreekMsString greekMacronCombo = new GreekMsString(macronCombo, "Unicode")
    println "${macronCombo} -> ${greekMacronCombo.toString(false)} "
    //   assert greekMacronCombo.toString() == macronCombo
  }

  void testAwfulHighStops() {
    String high = "δίῳ·"
    GreekMsString greekHigh = new GreekMsString(high, "Unicode")
    println "${high} -> ${greekHigh.toString(false)} "
    
  }

}