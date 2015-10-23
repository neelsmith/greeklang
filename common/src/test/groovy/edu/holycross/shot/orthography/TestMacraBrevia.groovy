package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestMacraBrevia {



  @Test void testMacron() {
    String macron = "κώκῡσεν"
    String expectedAscii = "kw/ku_sen"

    GreekMsString macronString = new GreekMsString(macron, "Unicode")
    assert macronString.toString(false) ==  GreekMsString.asciifyUnicode(macron, "Unicode")

    assert macronString.toString(false) == expectedAscii

  }

  @Test void testBreve() {
    // map to ^
    String breve =  "πί̆θεσθέ"
    String expectedAscii = "pi/^qesqe/"


    GreekMsString breveString = new GreekMsString(breve, "Unicode")
    assert breveString.toString(false) ==  GreekMsString.asciifyUnicode(breve, "Unicode")

    assert breveString.toString(false) == expectedAscii

  }

  @Test void testDiaeresis () {
    String diaeresis = "ί̈σχειν"
    String expectedAscii = "i+/sxein"

    GreekMsString diaeresisString = new GreekMsString(diaeresis, "Unicode")
    assert diaeresisString.toString(false) ==  GreekMsString.asciifyUnicode(diaeresis, "Unicode")
    assert diaeresisString.toString(false) == expectedAscii

  }

  @Test void testPrecomposed() {
    File precomposed = new File("testdata/strings/kwkcombo.txt")
    String nfcStr = precomposed.getText("UTF-8")
    GreekMsString msString = new GreekMsString(nfcStr, "Unicode")

    String expectedAscii = "kw/ku_sen"
    String actualAscii =  msString.toString(false).replaceAll("\n","")

    println "Expected #${expectedAscii}#"
    println "Actual #${actualAscii}#"

  }


}
