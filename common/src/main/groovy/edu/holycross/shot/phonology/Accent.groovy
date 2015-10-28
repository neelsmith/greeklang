package edu.holycross.shot.phonology

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

/** A class for working with the movable accent of GreekWords. */
class Accent {





  /** Removes accents from a GreekString.
  * @param gs GreekString to strip accents from.
  * @return A GreekString with accents removed.
  */
  static GreekString stripAccents(GreekString gs) {
    return new GreekString(gs.toString().findAll {
      ! Phonology.isAccent(it)
      }.join(''))
  }


  /** Removes accents from a GreekWord.
  * @param gw GreekWord to strip accents from.
  * @return A GreekWord with accents removed.
  */
  static GreekWord stripAccents(GreekWord gw) {
    return new GreekWord(gw.toString().findAll {
      ! Phonology.isAccent(it)
      }.join(''))
  }

  /** Places a given accent character on a single syllable by
  * reading from the end of the syllable back until a vowel is
  * found.
  * @param syllable ASCII String representing a single syllable,
  * e.g., as returned by GreekWord class' getSyllables method.
  * @param accentChar One of "/" or "=".
  * @returns String with accent character inserted.
  */
  static String accentSyllable(String syllable, String accentChar) {
    String accentedSyllable = ""
    boolean noAccent = true
    Integer index = syllable.size() - 1
    Integer max = index
    while ((index >= 0) && (noAccent)) {
      String ch = syllable[index]
      if (Phonology.isVowel(ch)) {
        if (index == syllable.size() - 1) {
          accentedSyllable = syllable  + accentChar
        } else {
          Integer nextIndex = index + 1
          accentedSyllable = syllable[0..index] + accentChar + syllable[nextIndex..max]
        }


        noAccent = false
      }
      index--
    }
    if (noAccent) {
      throw new Exception("Accent: no vowel found in ${syllable}")
    } else {
      return accentedSyllable
    }
  }

  // makes best guess at what accent to apply to what syllable
  // based on accent pattern and string content of greekword
  static GreekWord accentWord(GreekWord gw, AccentPattern acc) {
  }

}
