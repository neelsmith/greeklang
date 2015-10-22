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

    /** Diphthong followed by a vowel. */
    static java.util.regex.Pattern diphthong_vowel = ~/(ai[\)\(]?|oi[\)\(]?|ei[\)\(]?|au[\)\(]?|eu[\)\(]?|ou[\)\(]?|hu[\)\(]?|wu[\)\(]?|ui[\)\(]?)([aeiouhw])/

    /** Vowel followed by a diphthong. */
    static java.util.regex.Pattern vowel_diphthong = ~/([\)\(aeiouhw])(ai|oi|ei|au|eu|ou|hu|wu|ui)/

    /** Vowel short by nature followed by a vowel other than [iu]. */
    static java.util.regex.Pattern short_vowel = ~/([aeo[\)\(]?])([aehow])/

    /** Vowel long by nature followed by a vowel other than u. */
    static java.util.regex.Pattern long_vowel = ~/([hw[\)\(]?])([aehiow])/

    /** Upsilon followed by a vowel other than iota. */
    static java.util.regex.Pattern upsilon_vowel = ~/u([aehouw])/

    //
    // Regular expressions to split up consonant-vowel combinations.
    //

    /** Sequence mu-nu starts a syllable. */
    static java.util.regex.Pattern mn = ~/([\)\(aeiouhw\|\+])mn/

    /** Other than mu-nu, split up a liquid-consonant combination when it
    * follows a vowel.
    */
    static java.util.regex.Pattern liquid_consonant = ~/([\)\(aeiouhw\|\+])([lmnr])([bgdzqkcprstfxy]+)/



    // split double consonants
    java.util.regex.Pattern dubble = ~/(b{2}|g{2}|d{2}|z{2}|q{2}|k{2}|l{2}|m{2}|n{2}|p{2}|r{2}|s{2}|t{2}|f{2}|x{2})/
    // other consonant clusters stay together.  Apply this rule later in pipline!
    java.util.regex.Pattern consclust = ~/([\)\(aeiouhw\|\+])([bgdzqkpcstfxy][mnbgdzqklcprstfxy]+)/
    // vowel-consonant-vowel
    java.util.regex.Pattern vcv = ~/([\)\(aeiouhw\|\+])([bgdzqklmncprstfxy][aeiouhw])/


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

    // mn always starts a syllable
    syllabic = syllabic.replaceAll(mn) { fullMatch, vow ->
      vow + "#mn"
    }
    // otherwise split liquids and consonants
    syllabic = syllabic.replaceAll(liquid_consonant) { fullMatch, vow, liq, stopcons ->
      vow +  liq + "#" +stopcons
    }

  /*

  // dipthong-vowel splits
  sylls = sylls.replaceAll(dv) { fullMatch, dipth, vow ->
    dipth + "#" + vow
  }
  if (verbose) { println "\tafter dv " + sylls }
*/

  // dipthong-vowel splits
  syllabic = syllabic.replaceAll(diphthong_vowel) { fullMatch, dipth, vow ->
    dipth + "#" + vow
  }



/*

  // vowel-dipthong splits
  sylls = sylls.replaceAll(vd) {fullMatch, vow, dipth ->
    vow + "#" + dipth
  }
  if (verbose) { println "\tafter vd " + sylls }

  // adjacent vowels to split:
  // short followed by non-diphthong
  sylls = sylls.replaceAll(sv) {fullMatch, v1, v2 ->
    v1 + "#" + v2
  }
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
