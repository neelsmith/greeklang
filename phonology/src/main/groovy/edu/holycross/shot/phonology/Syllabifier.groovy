package edu.holycross.shot.phonology

import edu.holycross.shot.greekutils.GreekWord

/** A class for splitting GreekWords into syllables. */
class Syllabifier {

    // ///////////////////////////////////////////////////
    // Regular expressions implementing the definition of syllables
    // in Smyth parag. 140.
    //
    // Diaeresis is the one editorial mark that explicitly identifies
    // puncutation
    /** Split vowel with diaeresis from preceding vowel. */
    static java.util.regex.Pattern diaeresis =  ~/([aeiouhw][\)\(]?)([iu][\)\(]?\+)/

    // Regular expressions to split up succesive vowels:
    //
    /** Diphthong is split from a following vowel.  Breathing on
    * diphthong possible if word-initial. */
    static java.util.regex.Pattern diphthong_vowel = ~/(ai[\)\(]?|oi[\)\(]?|ei[\)\(]?|au[\)\(]?|eu[\)\(]?|ou[\)\(]?|hu[\)\(]?|wu[\)\(]?|ui[\)\(]?)([aeiouhw])/

    /** Vowel is split from a following diphthong. Breathing on
    * vowel possible if word-initial. */
    static java.util.regex.Pattern vowel_diphthong = ~/([\)\(aeiouhw])(ai|oi|ei|au|eu|ou|hu|wu|ui)/

    /** Short vowel is split form a following vowel other than [iu].
    * Breathing on vowel possible if word-initial. */
    static java.util.regex.Pattern shortv_vowel = ~/([aeio][\)\(]?)([aehow])/

    /** Vowel long by nature followed by a vowel other than u.
    * Breathing on vowel possible if word-initial. */
    static java.util.regex.Pattern longv_vowel = ~/([hw][\)\(]?)([aehiow])/

    /** Upsilon followed by a vowel other than iota.
    * Breathing on upsilon possible if word-initial. */
    static java.util.regex.Pattern upsilon_vowel = ~/(u[\)\(])([aehouw])/

    //
    // Regular expressions to split up consonant-vowel combinations.
    //
    /** Preceded by a vowel, the sequence mu-nu always starts a syllable. */
    static java.util.regex.Pattern mu_nu = ~/([\)\(aeiouhw\|\+])mn/

    /** Other than mu-nu, a liquid-consonant combination is split up
    * when it follows a vowel.
    */
    static java.util.regex.Pattern liquid_consonant = ~/([\)\(aeiouhw\|\+])([lmnr])([bgdzqkcprstfxy]+)([^'])/

    /**  Double consonants are split. */
    static java.util.regex.Pattern double_consonant = ~/(b{2}|g{2}|d{2}|z{2}|q{2}|k{2}|l{2}|m{2}|n{2}|p{2}|r{2}|s{2}|t{2}|f{2}|x{2})([^'])/

    /** Other consonant clusters stay together. This regex *must*
    * be applied later in the pipeline than the preceding regexes
    * spliting on consonant patterns!*/
    static java.util.regex.Pattern consonant_cluster = ~/([\)\(aeiouhw\|\+])([bgdzqkpcstfxy][mnbgdzqklcprstfxy]+)([^'])/

    /** In pattern vowel-consonant-vowel, consonant begins
    * a new syllable. */
    static java.util.regex.Pattern vowel_consonantvowel = ~/([\)\(aeiouhw\|\+])([bgdzqklmncprstfxy][aeiouhw])/


    /** Splits a GreekWord into syllabes.
    * @param gw The GreekWord to syllabify.
    * @returns An ordered list of Strings.
    */
    static ArrayList getSyllables(GreekWord gw) {
      String s = Syllabifier.getSyllabicString(gw)
      return s.split(/#/)
    }


  /** Sequentially applies regular expressions to split the String
  * representation of a GreekWord into syllables.
  * The order of application of these regexes is significant.
  * @param gw The GreekWord to syllabify.
  * @returns A String with '#' characters separating syllables.
  */
  static String getSyllablicString(GreekWord gw) {
    String syllabic = gw.toString()

    // respect diaeresis
    syllabic = syllabic.replaceAll(diaeresis) { fullMatch, v1, v2 ->
      v1 + "#" + v2
    }

    // mu-nu always starts a syllable
    syllabic = syllabic.replaceAll(mu_nu) { fullMatch, vow ->
      vow + "#mn"
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
    // split long vowel followed by non-diphthong
    syllabic = syllabic.replaceAll(longv_vowel) {fullMatch, v1, v2 ->
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

  // In 2 passes, replace vowel-consonant-vowel pattern
  syllabic = syllabic.replaceAll(vowel_consonantvowel) { fullMatch, v, cv ->
    v + "#" + cv
  }
  syllabic = syllabic.replaceAll(vowel_consonantvowel) { fullMatch, v, cv ->
    v + "#" + cv
  }

    return syllabic
  }

}
