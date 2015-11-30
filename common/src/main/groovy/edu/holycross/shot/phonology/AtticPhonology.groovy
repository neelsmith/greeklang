package edu.holycross.shot.phonology

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

/** A class for working with the phonology of GreekWords. */
class AtticPhonology {

  /** Immutable set of consonant characters. */
  static consonant = [
    'b','g','d',
    'z','q','k',
    'l','m','n',
    'p','r',
    's','t','f',
    'x','h'
  ]

  /** Immutable set of vowel characters. */
  static vowel = [
    'a', 'e',
    'i','o','u'
  ]


  /** Immutable set of accent characters. */
  static accent = ['/','\\','=']

  // these are not really orthographic, are they?
  /** Immutable set of vowel quantity markers. */
  static quantity = ['_','^']



  /** Elision mark in ascii. */
  static String elision = "'"


  /** Pairs of vowels forming diphthongs. */
  static diphthong = [
    "ai", "ei","oi",

    "au","eu", "ou",
    "hu", "ui"
  ]

  /** Determines if a character is the elision character.
  * @param ch A 1-character String.
  * @returns True if ch is the elision character.
  */
  /*
  static boolean isElision(String ch) {
    return ch == elision
  }*/

  /** Determines if a character is a breathing character.
  * @param ch A 1-character String.
  * @returns True if ch is a breathing character.
  */
  /*
  static boolean isBreathing(String ch) {
    return breathing.contains(ch)
  }
*/
  /** Determines if a character is an accent.
  * @param ch A 1-character String.
  * @returns True if ch is an accent.
  */
  static boolean isAccent(String ch) {
    return accent.contains(ch)
  }


  /** Determines if a character is a consonant.
  * @param ch A 1-character String.
  * @returns True if ch is a consonant.
  */
  static boolean isConsonant(String ch) {
    return consonant.contains(ch)
  }


  /** Determines if a character is a vowel.
  * @param ch A 1-character String.
  * @returns True if ch is a vowel.
  */
  static boolean isVowel(String ch) {
    return vowel.contains(ch)
  }


  static boolean isAlpha(String ch) {
    if (isVowel(ch) || isConsonant(ch) ) {
      return true
    } else {
      return false
    }
  }


  /** Determines if a string is a diphthong.
  * @param ch String to check.
  * @returns True if s is a diphthong.
  */
  static boolean isDiphthong(String s) {
    return diphthong.contains(s)
  }


  /** Determines if a character is a markers for vowel
  * quantity (macron or breve).
  * @param ch A 1-character String.
  * @returns True if ch is a a quantity marker.
  */
  static boolean isQuantity(String ch) {
    return quantity.contains(ch)
  }


}
