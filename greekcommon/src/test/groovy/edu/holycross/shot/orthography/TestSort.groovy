
package edu.holycross.shot.orthography


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

/** Class tests extracting integer and fraction
 * components of a MilesianString.
 */
class TestSort  {

  @Test
  void testCfWords() {
    GreekString asciiTheta = new GreekString ("e)/qhke")
    GreekString asciiKappa = new GreekString ("e)/kruye")
    assert asciiKappa > asciiTheta

    GreekString uniKappa = new GreekString("ἔκρυψε", true)
    assert uniKappa == asciiKappa
  }

  @Test
  void testSortList() {

    String srcWords = "Μῆνιν ἄειδε θεὰ Πηληϊάδεω Ἀχιλῆος οὐλομένην· ἡ μυρί' Ἀχαιοῖς ἄλγε' ἔθηκεν·"
    def wordList = srcWords.split(/\s/)

    // demonstrate insanity of sorting by Unicode order:
    def insaneUnicodeSort = [
    "Μῆνιν", "Πηληϊάδεω", "θεὰ", "μυρί'", "οὐλομένην·",
    "ἄειδε", "ἄλγε'", "Ἀχαιοῖς", "Ἀχιλῆος", "ἔθηκεν·",
    "ἡ"]
    assert wordList.sort() == insaneUnicodeSort

    // Create list of GreekStrings and sort rationally
    def srcGsList = []
    wordList.each {
      srcGsList.add(new GreekString(it, true))
    }
    def rationalGreekStringSort=  [
    "a)/eide", "a)/lge'",
    "a)xaioi=s", "a)xilh=os","e)/qhken:",
    "h(", "qea\\", "mh=nin", "muri/'","ou)lome/nhn:",
    "phlhi+a/dew"]
    def expectedGsList = []
    rationalGreekStringSort.each {
      expectedGsList.add(new GreekString(it))
    }

    assert expectedGsList == srcGsList.sort()

  }



}
