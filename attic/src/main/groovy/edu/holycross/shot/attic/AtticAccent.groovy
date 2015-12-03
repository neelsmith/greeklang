package edu.holycross.shot.attic

import edu.holycross.shot.phonology.AccentPattern

/** A class for working with the movable accent of AtticWords. */
class AtticAccent {

  /** Regex to check string representation of a syllable for diphthong or long vowel. */
  static java.util.regex.Pattern syllLongByNature =  ~/.*([AEIOU][_]).*/

  /** Removes accents from a AtticString.
  * @param gs AtticString to strip accents from.
  * @return A AtticString with accents removed.
  */
  static AtticString stripAccents(AtticString gs) {
    return new AtticString(gs.toString().findAll {
      ! AtticPhonology.isAccent(it)
      }.join(''))
  }


  /** Removes accents from a AtticWord.
  * @param gw AtticWord to strip accents from.
  * @return A AtticWord with accents removed.
  */
  static AtticWord stripAccents(AtticWord gw) {
    return new AtticWord(gw.toString().findAll {
      ! AtticPhonology.isAccent(it)
      }.join(''))
  }

  /** Places a given accent character on a single syllable by
  * reading from the end of the syllable back until a vowel is
  * found.
  * @param syllable ASCII String representing a single syllable,
  * e.g., as returned by AtticWord class' getSyllables method.
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

      if ((AtticPhonology.isVowel(ch)) ||  AtticPhonology.isQuantity(ch)) {
	if (ch != "|") {
	  if (index == syllable.size() - 1) {
	    accentedSyllable = syllable  + accentChar
	  } else {
	    Integer nextIndex = index + 1
	    accentedSyllable = syllable[0..index] + accentChar + syllable[nextIndex..max]
	  }
	  noAccent = false
	}
      }
      index--
    }
    if (noAccent) {
      throw new Exception("Accent: no vowel found in ${syllable}")
    } else {
      return accentedSyllable
    }
  }



  /** Adds persistent accent on penult to a AtticWord.
  * @param gw Unaccented form to accent.
  * @returns A AtticWord with accent added.
  * @throws Exception if gw does not have at least two syllables.
  */
  static AtticWord addPenultAccent(AtticWord gw) {
    def syllables = gw.getSyllables()
    if (syllables.size() < 2){
      throw new Exception("Accent: cannot accent penult of ${gw}. Too few syllables.")
    }
    //println "No. syllables in ${gw}: " + syllables.size()
    Integer lastIndex = syllables.size() - 1
    String lastSyll = syllables[lastIndex]
    Integer penultIdx = lastIndex - 1
    String penult = syllables[penultIdx]

    if (hasFinalDiphthong(gw)) {
      // treat as short:  Smyth 169
      if (penult ==~ syllLongByNature ) {
        // properispomenon

  syllables[penultIdx] = accentSyllable(penult, "=")

      } else {
        // paroxytone:
  syllables[penultIdx] = accentSyllable(syllables[penultIdx], "/")
      }

    } else if (lastSyll ==~ syllLongByNature) {
          // last syllable long, accent must be paroxytone:
      syllables[penultIdx] = accentSyllable(penult, "/")

    } else {
      // last syllable short: check length of penult
      if (penult ==~ syllLongByNature ) {
        // properispomenon

	syllables[penultIdx] = accentSyllable(penult, "=")

      } else {
        // paroxytone:
	syllables[penultIdx] = accentSyllable(syllables[penultIdx], "/")
      }
    }
    return new AtticWord(syllables.join(""))
  }


  static AtticWord addRecessiveAccentShortFinal(AtticWord gw) {
    def syllables = gw.getSyllables()
    Integer lastIndex = syllables.size() - 1
    String lastSyll = syllables[lastIndex]

    switch(lastIndex) {
      case 0:
      syllables[lastIndex] = accentSyllable(syllables[lastIndex], "/")
      break

      case 1:

      Integer penultIdx = lastIndex - 1
      String penult = syllables[penultIdx]
      if (penult ==~ syllLongByNature ) {
        syllables[penultIdx] = accentSyllable(syllables[penultIdx], "=")
      } else {
        syllables[penultIdx] = accentSyllable(syllables[penultIdx], "/")
      }
      break

      default:
      Integer antepenultIdx = lastIndex - 2
      syllables[antepenultIdx] = accentSyllable(syllables[antepenultIdx], "/")
      break
    }
    return new AtticWord(syllables.join(""))
  }



  /** Adds recessive accent to a AtticWord.
  * @param gw Unaccented form to accent.
  * @returns A AtticWord with accent added.
  */
  static AtticWord addRecessiveAccent(AtticWord gw) {
    def syllables = gw.getSyllables()
    Integer lastIndex = syllables.size() - 1
    String lastSyll = syllables[lastIndex]

    if (hasFinalDiphthong(gw)) {
      // treat as short:  Smyth 169
      return addRecessiveAccentShortFinal(gw)
    } else if (lastSyll ==~ syllLongByNature) {
      // last syllable long:
      switch(lastIndex) {
        case 0:
        syllables[lastIndex] = accentSyllable(syllables[lastIndex], "=")
        break

        default:
        Integer penultIdx = lastIndex - 1
        syllables[penultIdx] = accentSyllable(syllables[penultIdx], "/")
        break
      }
      return new AtticWord(syllables.join(""))
    } else {
      // last syllable short
      return addRecessiveAccentShortFinal(gw)


    }
  }

  // makes best guess at what accent to apply to what syllable
  // based on accent pattern and string content of AtticWord

  static AtticWord accentWord(AtticWord gw, AccentPattern acc) {
    //System.err.println "Add accent to ${gw}, ${acc}"
    switch (acc) {
      case AccentPattern.RECESSIVE:
      return addRecessiveAccent(gw)
      break

      case AccentPattern.PENULT:
      return addPenultAccent(gw)
      break


      case AccentPattern.ULTIMA:
      throw new Exception("Accent: cannot accent ultima without morphological information about ${gw}.")
      break
    }
  }



  // Smyth 169 : final -ai and -oi are short
  static boolean hasFinalDiphthong(AtticWord gs) {
    String ascii = gs.toString()
    if ((ascii ==~ /.+ai$/) || (ascii ==~ /.+oi$/)) {
      return true
    } else {
      return false
    }
  }

}
