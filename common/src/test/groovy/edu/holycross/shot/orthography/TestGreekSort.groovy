package edu.holycross.shot.orthography


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestGreekSort  {


  @Test
  void testCf() {
    assert (new GreekString("le/ge") < new GreekString("le/gete"))
    //assert (new GreekString("mh=nin") < new GreekString("a)/eide"))
  }

  @Test
  void testSort() {
    //def gc = new GreekComparator()
    def ilWords = [new GreekString("mh=nin"), new GreekString("a)/eide"), new GreekString("qea/")]
    def sortedWords = [new GreekString("a)/eide"), new GreekString("qea/"), new GreekString("mh=nin")]
    assert sortedWords == ilWords.sort()


    // When two words match for every char,
    // but one word keeps going, the short
    // word sorts first.

    def longShort = [new GreekString("le/gete"), new GreekString( "le/ge")]
    def shortLong = [new GreekString("le/ge"), new GreekString("le/gete")]
    assert shortLong == longShort.sort()

  }


}
