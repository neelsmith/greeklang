package edu.holycross.shot.attic



/** A class for working with the phonology of GreekWords. */
class AtticPhonology {

  /** Immutable set of consonant characters. */
  public static ArrayList consonant = [
    'B','G','D',
    'Z','Q','K',
    'L','M','N',
    'P','R',
    'S','T','F',
    'X','H'
  ]

  /** Immutable set of vowel characters. */
  public static ArrayList vowel = [
    'A', 'E',
    'I','O','U'
  ]


  /** Immutable set of accent characters. */
  public static ArrayList accent = ['/','\\','=']

  // these are not really orthographic, are they?
  /** Immutable set of vowel quantity markers. */
  public static ArrayList quantity = ['_','^']



  /** Elision mark in ascii. */
  static String elision = "'"

  /** Since unicode can't handle E= or O= we pass along
  * these subsistutes. */
  static mockUni = ["Ê", "Ô"]

  static isMockUnicode(String ch) {
      return mockUni.contains(ch)
  }

  /** Determines if a character is the elision character.
  * @param ch A 1-character String.
  * @returns True if ch is the elision character.
  */
  /*
  static boolean isElision(String ch) {
    return ch == elision
  }*/


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




  /** Determines if a character is a markers for vowel
  * quantity (macron or breve).
  * @param ch A 1-character String.
  * @returns True if ch is a a quantity marker.
  */
  static boolean isQuantity(String ch) {
    return quantity.contains(ch)
  }

  static ArrayList getVowels() {
    return vowel
  }


  static ArrayList getConsonants() {
    return consonant
  }

}
