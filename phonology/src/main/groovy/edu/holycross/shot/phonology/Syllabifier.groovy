package edu.holycross.shot.phonology

import edu.holycross.shot.greekutils.GreekWord

/** A class for splitting GreekWords into syllables. */
class Syllabifier {

    // ///////////////////////////////////////////////////
    // Regular expressions implementing the definition of syllables
    // in Smyth parag. 140.
    //
    // Regular expressions to split up succesive vowels:
    //

    /** Diphthong is split from a following vowel. */
    static java.util.regex.Pattern diphthong_vowel = ~/(ai[\)\(]?|oi[\)\(]?|ei[\)\(]?|au[\)\(]?|eu[\)\(]?|ou[\)\(]?|hu[\)\(]?|wu[\)\(]?|ui[\)\(]?)([aeiouhw])/

    /** Vowel is split from a following diphthong. */
    static java.util.regex.Pattern vowel_diphthong = ~/([\)\(aeiouhw])(ai|oi|ei|au|eu|ou|hu|wu|ui)/

    /** Vowel short by nature is split form a following vowel other than [iu]. */
    static java.util.regex.Pattern shortv_vowel = ~/([aeo][\)\(]?)([aehow])/

    /** Vowel long by nature followed by a vowel other than u. */
    static java.util.regex.Pattern longv_vowel = ~/([hw[\)\(]?])([aehiow])/

    /** Upsilon followed by a vowel other than iota. */
    static java.util.regex.Pattern upsilon_vowel = ~/u([aehouw])/

    //
    // Regular expressions to split up consonant-vowel combinations.
    //

    /** Preceded by a vowel, the sequence mu-nu always starts a syllable. */
    static java.util.regex.Pattern mu_nu = ~/([\)\(aeiouhw\|\+])mn/

    /** Other than mu-nu, a liquid-consonant combination is split up
    * when it follows a vowel.
    */
    static java.util.regex.Pattern liquid_consonant = ~/([\)\(aeiouhw\|\+])([lmnr])([bgdzqkcprstfxy]+)/

    /**  Double consonants are split. */
    static java.util.regex.Pattern double_consonant = ~/(b{2}|g{2}|d{2}|z{2}|q{2}|k{2}|l{2}|m{2}|n{2}|p{2}|r{2}|s{2}|t{2}|f{2}|x{2})/





    // other consonant clusters stay together.  Apply this rule later in pipline!
    java.util.regex.Pattern consclust = ~/([\)\(aeiouhw\|\+])([bgdzqkpcstfxy][mnbgdzqklcprstfxy]+)/
    // vowel-consonant-vowel
    java.util.regex.Pattern vcv = ~/([\)\(aeiouhw\|\+])([bgdzqklmncprstfxy][aeiouhw])/


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

    // mu-nu always starts a syllable
    syllabic = syllabic.replaceAll(mu_nu) { fullMatch, vow ->
      vow + "#mn"
    }
    // otherwise split liquids and consonants
    syllabic = syllabic.replaceAll(liquid_consonant) { fullMatch, vow, liq, stopcons ->
      vow +  liq + "#" +stopcons
    }
    // dipthong-vowel splits
    syllabic = syllabic.replaceAll(diphthong_vowel) { fullMatch, dipth, vow ->
      dipth + "#" + vow
    }
    // vowel-dipthong splits
    syllabic = syllabic.replaceAll(vowel_diphthong) {fullMatch, vow, dipth ->
      vow + "#" + dipth
    }
    println "Before shortv: " + syllabic
    // split short vowel followed by non-diphthong
    syllabic = syllabic.replaceAll(shortv_vowel) {fullMatch, v1, v2 ->
      v1 + "#" + v2
    }
    println "After shortv: " + syllabic
  /*
  if (verbose) { println "\tafter sv " + sylls }
  // long followed by non-diphthong
  sylls = sylls.replaceAll(lv) {fullMatch, v1, v2 ->
    v1 + "#" + v2
  }
  // upsilon followed by non-diphthong
  sylls = sylls.replaceAll(uv) {fullMatch, v ->
    "u#" + v
  }

  // double consonants split
  sylls = sylls.replaceAll(dubble) { fullMatch, doubled ->
    doubled[0] + "#" + doubled[1]
  }
  if (verbose) { println "\tafter dubble " + sylls }

  // Otherwise, consonant clusters start a syllable
  sylls = sylls.replaceAll(consclust) { fullMatch, v, cons ->
      v + "#" + cons
  }
  if (verbose) { println "\tafter consclust " + sylls }

  // In 2 passes, replace vowel-consonant-vowel pattern
  sylls = sylls.replaceAll(vcv) { fullMatch, v, cv ->
    v + "#" + cv
  }
  sylls = sylls.replaceAll(vcv) { fullMatch, v, cv ->
    v + "#" + cv
  }
  if (verbose) { println "\tafter 2 passes of vcv " + sylls }


*/
    return syllabic
  }

}
