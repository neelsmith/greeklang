package edu.holycross.shot.orthography

import edu.holycross.shot.phonology.Syllable
import edu.holycross.shot.phonology.Phonology

/**
 * A class for working with a Greek word.
 */
class GreekWord {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0




  /** The word in ascii format.*/
  GreekString asciiWord


  /** Constructor verifies that
   * String contains only valid characters.
   * @param srcString Greek string, in ascii.
   * @throws Exception if not all characters in srcString are valid.
   */
  GreekWord(String srcString)
  throws Exception {
    Integer count = 0
    this.asciiWord = new GreekString(srcString)
  }


  /**
   */
  ArrayList getSyllables() {
    return Syllable.getSyllables(this)
  }


  GreekWord stripAccents() {
    return Phonology.stripAccents(this)
  }

  /** Overrides default implementation of toString.
   * @returns ASCII version of a Greek word.
   */
  String toString() {
    return this.asciiWord.toString()
  }

   String toString(boolean asUnicode) {
     if (asUnicode) {
       GreekString s = new GreekString(this.asciiWord.toString())
       System.err.println ("GreekWord: Got ${s}, as uni = " + s.toString(asUnicode))
       return s.toString(asUnicode)
    } else {
       return this.asciiWord.toString()
    }
   }

}
