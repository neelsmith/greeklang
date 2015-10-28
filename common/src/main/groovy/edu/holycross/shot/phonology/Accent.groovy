package edu.holycross.shot.phonology

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

/** A class for working with the movable accent of GreekWords. */
class Accent {

  /** Regex to check string representation of a syllable for diphthong or long vowel. */
  static java.util.regex.Pattern syllLongByNature =  ~/.*(ai|oi|ei|au|eu|ou|hu|wu|ui|[hw_]).*/

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
      if ((Phonology.isVowel(ch)) || (Phonology.isBreathing(ch))) {
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

  /** Adds recessive accent to a GreekWord.
  * @param gw Unaccented form to accent.
  * @returns A GreekWord with accent added.
  */
  static GreekWord addRecessiveAccent(GreekWord gw) {
    def syllables = gw.getSyllables()
    Integer lastIndex = syllables.size() - 1
    String lastSyll = syllables[lastIndex]
    // last syllable long:
    if (lastSyll ==~ syllLongByNature) {
      switch(lastIndex) {
        case 0:
        syllables[lastIndex] = accentSyllable(syllables[lastIndex], "=")
        break

        default:
        Integer penultIdx = lastIndex - 1
        syllables[penultIdx] = accentSyllable(syllables[penultIdx], "/")
        break
      }


    } else {
      // syllable not long by nature:

      /*
      if (lastSyll  > 1 ) {

      syllables[antepenultIdex] = accentSyllable(syllables[antepenultIdex], "/")
      */
    }

    return new GreekWord(syllables.join(""))
  }

  // makes best guess at what accent to apply to what syllable
  // based on accent pattern and string content of greekword
  static GreekWord accentWord(GreekWord gw, AccentPattern acc) {
    switch (acc) {
      case AccentPattern.RECESSIVE:
      return addRecessiveAccent(gw)
      break
    }
  }

}
