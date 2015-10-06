package edu.holycross.shot.greekutils

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestMsStrings {




  @Test void testInstance() {
    String eoSchol = "⁑"
    GreekMsString greekEoSchol = new GreekMsString(eoSchol, "Unicode")
    assert greekEoSchol.toString() == eoSchol
  }



  @Test void testCombos() {
    String macronCombo = "ἀ̄λλ'"
    GreekMsString greekMacronCombo = new GreekMsString(macronCombo, "Unicode")
    println "${macronCombo} -> ${greekMacronCombo.toString(false)} "
    //   assert greekMacronCombo.toString() == macronCombo
  }

  @Test void testAwfulHighStops() {
    String high = "δίῳ·"
    GreekMsString greekHigh = new GreekMsString(high, "Unicode")
    println "${high} -> ${greekHigh.toString(false)} "

    String evilImpostor = "πυκίλαι·"
    assert shouldFail {
      GreekMsString dotless = new GreekMsString(evilImpostor, "Unicode")
    }
  }


  @Test void testWordString() {
    String verbForm = "κλονέονται"
    GreekMsString msVerbForm = new GreekMsString(verbForm, "Unicode")
    println "${msVerbForm} -> ${msVerbForm.toString(false)} "


  }


}
