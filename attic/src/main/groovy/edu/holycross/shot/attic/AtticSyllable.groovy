package edu.holycross.shot.attic


/** A class for working with the syllables of AtticWords. */
class AtticSyllable {


  // ///////////////////////////////////////////////////
  // Regular expressions implementing the definition of syllables
  // in Smyth parag. 140, applied to orthography of pre-403 Attic


  // Regular expressions to split up succesive vowels:
  //
  /** Diphthong is split from a following vowel. */
  static java.util.regex.Pattern diphthong_vowel = ~/(AI|OI|EI|AU|EU|OU|UI)([AEIOU])/

  /** Vowel is split from a following diphthong. Breathing on
  * vowel possible if word-initial. */
  static java.util.regex.Pattern vowel_diphthong =
   ~/([AEIOU][_^]?)(AI|OI|EI|AU|EU|OU|UI)/


  /** Short vowel is split form a following vowel other than [iu].
  * Breathing on vowel possible if word-initial. */
  static java.util.regex.Pattern shortv_vowel = ~/([AEIOU][\^ ]?)([AEO])/

  /** Vowel long by nature followed by a vowel other than u.
  * Breathing on vowel possible if word-initial. */
  static java.util.regex.Pattern vowelwmacron_vowel = ~/([AEIOU][_])([AEIOU])/

  /** Upsilon followed by a vowel other than iota.
  * Breathing on upsilon possible if word-initial. */
  static java.util.regex.Pattern upsilon_vowel = ~/(U)([AEOU])/

  //
  // Regular expressions to split up consonant-vowel combinations.
  //
  /** Preceded by a vowel, the sequence mu-nu always starts a syllable. */
  static java.util.regex.Pattern mu_nu = ~/([AEIOU][_^]?)MN/

  /** Other than mu-nu, a liquid-consonant combination is split up
  * when it follows a vowel.
  */
  static java.util.regex.Pattern liquid_consonant = ~/([AEIOU][_^]?)([LMNR])([BGDZDZQPRSTFX]+)([^'])/

  /**  Double consonants are split. */
  static java.util.regex.Pattern double_consonant = ~/(B{2}|G{2}|D{2}|Z{2}|Q{2}|K{2}|L{2}|M{2}|N{2}|P{2}|R{2}|S{2}|T{2}|F{2}|X{2})([^'])/

  /** Other consonant clusters stay together. This regex *must*
  * be applied later in the pipeline than the preceding regexes
  * spliting on consonant patterns!*/
  static java.util.regex.Pattern consonant_cluster = ~/([AEIOU][_^]?)([BGDZKPSTFX][MNBGDGDZQKLPRSTFX]+)([^'])/

  /** In the pattern vowel-consonant-vowel, consonant begins
  * a new syllable. */
  static java.util.regex.Pattern vowel_consonantvowel = ~/([(AEIOU][_^]?)([BGDZQKLMNPRSTFX][AEIOU])/



  // treat this as source for an array of AtticWord objects?
  static ArrayList getSyllables(AtticString str) {
  }

  /** Splits an AtticWord into syllabes.
  * @param gw The AtticWord to syllabify.
  * @returns An ordered list of GreekStrings.
  */
  static ArrayList getSyllables(AtticWord gw) {
    ArrayList syllables = []

    String s = AtticSyllable.getSyllablicString(gw.stripAccents().toString())
    s.split(/#/).each {
      syllables.add(new AtticWord(it))
    }
  }

  /** Sequentially applies regular expressions to split the String
  * representation of a AtticWord into syllables, and inserts
  * a pound sign '#' to mark syllable boundaries.
  * The order of application of these regexes is significant.
  * @param gw The AtticWord to syllabify.
  * @returns A String with '#' characters separating syllables.
  */
  static String getSyllablicString(String syllabic) {
  /*
    // respect diaeresis
    syllabic = syllabic.replaceAll(diaeresis) { fullMatch, v1, v2, trail ->
      if (trail) {
        v1 + "#" + v2 + "#" + trail
      } else {
        v1 + "#" + v2
      }
    }
*/
    // mu-nu always starts a syllable
    syllabic = syllabic.replaceAll(mu_nu) { fullMatch, vow ->
      vow + "#MN"
    }
    // otherwise split liquids and consonants
    syllabic = syllabic.replaceAll(liquid_consonant) { fullMatch, vow, liq, stopcons, trail ->
      vow +  liq + "#" + stopcons + trail
    }
    // dipthong-vowel splits
    syllabic = syllabic.replaceAll(diphthong_vowel) { fullMatch, dipth, vow ->
      dipth + "#" + vow
    }
    // vowel-dipthong splits
    syllabic = syllabic.replaceAll(vowel_diphthong) {fullMatch, vow, dipth ->
      vow + "#" + dipth
    }
    // split short vowel followed by non-diphthong
    syllabic = syllabic.replaceAll(shortv_vowel) {fullMatch, v1, v2 ->
      v1 + "#" + v2
    }
    // apply twice because regex matches overlap if there are 3 successive vowels.
    syllabic = syllabic.replaceAll(shortv_vowel) {fullMatch, v1, v2 ->
      v1 + "#" + v2
    }

    /*
    // split long vowel by nature followed by non-diphthong
    syllabic = syllabic.replaceAll(longv_vowel) {fullMatch, v1, v2 ->
    v1 + "#" + v2
    }
    */
    // split long vowel marked with macron followed by non-diphthong
    syllabic = syllabic.replaceAll(vowelwmacron_vowel) {fullMatch, v1, v2 ->
    v1 + "#" + v2
    }
    // split upsilon followed by non-diphthong
    syllabic = syllabic.replaceAll(upsilon_vowel) {fullMatch, u, v ->
      u + "#" + v
    }
    // double consonants split
    syllabic = syllabic.replaceAll(double_consonant) { fullMatch, doubled, trail ->
      doubled[0] + "#" + doubled[1] + trail
    }

    // Otherwise, consonant clusters start a syllable
    syllabic = syllabic.replaceAll(consonant_cluster) { fullMatch, v, cons, trail ->
      v + "#" + cons + trail
    }

    // Must apply vowel-consonant-vowel pattern twice, because regex
    // matches can overlap.
    syllabic = syllabic.replaceAll(vowel_consonantvowel) { fullMatch, v, cv ->
      v + "#" + cv
    }
    syllabic = syllabic.replaceAll(vowel_consonantvowel) { fullMatch, v, cv ->
      v + "#" + cv
    }

    return syllabic
  }



  static getFinalAccentQuantities(AtticWord gw) {
    return getFinalAccentQuantities(gw, false)
  }

  static getFinalAccentQuantities(AtticWord gw, boolean forceFinalShort) {
    // list of final quantities from last backwards,
    // up to three total
    ArrayList quantities = []
  }




}
