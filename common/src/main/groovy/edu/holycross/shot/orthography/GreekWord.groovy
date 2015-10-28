package edu.holycross.shot.orthography

import edu.holycross.shot.phonology.Syllable
import edu.holycross.shot.phonology.Phonology
import edu.holycross.shot.phonology.AccentPattern
import edu.holycross.shot.phonology.Accent

/**
 * A class for working with a Greek word.
 */
class GreekWord {



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


  /** Splits word into syllabes.
  * @returns An ordered list of GreekStrings.
  */
  ArrayList getSyllables() {
    return Syllable.getSyllables(this)
  }


  /** Removes accents from a word.
  * @returns A GreekWord with accents removed.
  */
  GreekWord stripAccents() {
    return Accent.stripAccents(this)


  }


  ArrayList getFinalAccentQuantities() {

    return Syllable.getFinalAccentQuantities(this)
  }

  GreekWord addAccent(ArrayList syllables, AccentPattern accent) {

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
