package edu.holycross.shot.phonology

import edu.holycross.shot.greekutils.GreekWord

class Syllabifier {

    // ///////////////////////////////////////////////////
    // Regular expressions implementing the definition of syllables
    // in Smyth parag. 140.


    /** Diphthong followed by a vowel. */
    static java.util.regex.Pattern diphthong_vowel = ~/(ai[\)\(]?|oi[\)\(]?|ei[\)\(]?|au[\)\(]?|eu[\)\(]?|ou[\)\(]?|hu[\)\(]?|wu[\)\(]?|ui[\)\(]?)([aeiouhw])/

    /** Vowel followed by a diphthong. */
    static java.util.regex.Pattern vowel_diphthong = ~/([\)\(aeiouhw])(ai|oi|ei|au|eu|ou|hu|wu|ui)/


    // split successive vowels otherwise
    // ALL VOWELS : [aehiouw]
    // Short vowel followed by vowel [aeo] followed by NOT [iu]
    java.util.regex.Pattern sv = ~/([aeo[\)\(]?])([aehow])/

    // Long vowel fllowd by vowel [hw] followed by NOT u
    java.util.regex.Pattern lv = ~/([hw[\)\(]?])([aehiow])/
    // u followed by NOT i
    java.util.regex.Pattern uv = ~/u([aehouw])/

    // mn starts a syllable
    java.util.regex.Pattern mn = ~/([\)\(aeiouhw\|\+])mn/
    // but otherwise, split when liquidy syllable ender follows a vowel:
    java.util.regex.Pattern split_ender = ~/([\)\(aeiouhw\|\+])([lmnr])([bgdzqkcprstfxy]+)/
    // split double consonants
    java.util.regex.Pattern dubble = ~/(b{2}|g{2}|d{2}|z{2}|q{2}|k{2}|l{2}|m{2}|n{2}|p{2}|r{2}|s{2}|t{2}|f{2}|x{2})/
    // other consonant clusters stay together.  Apply this rule later in pipline!
    java.util.regex.Pattern consclust = ~/([\)\(aeiouhw\|\+])([bgdzqkpcstfxy][mnbgdzqklcprstfxy]+)/
    // vowel-consonant-vowel
    java.util.regex.Pattern vcv = ~/([\)\(aeiouhw\|\+])([bgdzqklmncprstfxy][aeiouhw])/


  static String getSyllablicString(GreekWord gw) {
    String syllabic = gw.toString()


    // dipthong-vowel splits
    syllabic = syllabic.replaceAll(diphthong_vowel) { fullMatch, dipth, vow ->
      dipth + "#" + vow
    }

    return syllabic
  }

}
