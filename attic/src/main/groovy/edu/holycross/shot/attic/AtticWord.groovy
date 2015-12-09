package edu.holycross.shot.attic

import edu.holycross.shot.orthography.GreekOrthography
import edu.holycross.shot.phonology.AccentPattern
/**
 * A class for working with a Greek word.
 */
class AtticWord implements GreekOrthography {


  /** The word in ascii format.*/
  AtticString asciiWord


  /** Constructor verifies that
   * String contains only valid characters.
   * @param srcString Greek string, in ascii.
   * @throws Exception if not all characters in srcString are valid.
   */
  AtticWord(String srcString)
  throws Exception {
    Integer count = 0
    this.asciiWord = new AtticString(srcString)
  }


  // perhaps ensure that only alphabetic +
  // breathing + accent + quantity?
  // ie, no punctuation
  boolean isValid() {
    return true
  }

  /** Splits word into syllabes.
  * @returns An ordered list of AtticStrings.
  */
  ArrayList getSyllables() {
    return AtticSyllable.getSyllables(this)
  }


  /** Removes accents from a word.
  * @returns A AtticWord with accents removed.
  */
  AtticWord stripAccents() {
    return AtticAccent.stripAccents(this)
  }


  ArrayList getFinalAccentQuantities() {
    return AtticSyllable.getFinalAccentQuantities(this)
  }

  

  AtticWord accent(AccentPattern acc) {
    return AtticAccent.accentWord(this, acc)
  }

  /** Overrides default implementation of toString.
   * @returns ASCII version of a Greek word.
   */
  String toString() {
    return this.asciiWord.toString()
  }

   String toString(boolean asUnicode) {
     if (asUnicode) {
       AtticString s = new AtticString(this.asciiWord.toString())
       return s.toString(asUnicode)
    } else {
       return this.asciiWord.toString()
    }
   }

}
