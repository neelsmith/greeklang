package edu.holycross.shot.greekutils


/**
 * A class for working with text in Greek.  Instances may
 * be initialized with any encoding of Greek that Hugh Cayless'
 * transcoder recognizes;  static methods expect beta code strings.
 */
class GreekString {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0


  /** Immutable set of consonant characters. */
  static consonant = [
    'b','g','d',
    'z','q','k',
    'l','m','n',
    'c','p','r',
    's','t','f',
    'x','y'
  ]

  /** Immutable set of vowel characters. */
  static vowel = [
    'a', 'e','h',
    'i','o','u',
    'w'
  ]

  /** Immutable set of breathing characters. */
  static breathing = [')','(']

  /** Immutable set of accent characters. */
  static accent = ['/','\\','=']

  /** Immutable set of vowel quantity markers. */
  static quantity = ['_','^']

  /** Diaeresis in beta code. */
  static String diaeresis = "+"

  /** Beta code marker for upper case. */
  static String asterisk = "*"

  /** Pairs of vowels forming diphthongs. */
  static diphthong = [
    "ai", "ei","oi",
    "a|", "h|", "w|",
    "au","eu", "ou",
    "hu", "ui"
  ]

  /** Immutable set of punctuation characters. */
  static punctuation = [
    ".",  ";", ","
  ]


  /** The string in beta code form.*/
  String greekString


  /** Constructor verifies that
   * String contains only valid characters.
   * @param srcString Greek string, in beta code.
   * @throws Exception if not all characters in betaString are valid.
   */
  GreekString(String srcString) 
  throws Exception {
    Integer count = 0
    String betaString = srcString.toLowerCase()
    while (count < betaString.length() - 1) {
      if (!(isValidChar(betaString.substring(count,count+1)))) {
	System.err.println "Error parsing ${betaString}: failed on ${betaString.substring(count,count+1)} (char ${count})"
	throw new Exception("GreekString: invalid characer ${betaString.substring(count,count+1)}")
      }
      count++
    }
    this.greekString = betaString
  }


  /** Determines if a one-character long string is a valid GreekString
   * character.
   * @param ch String to check.
   * @returns true if character is valid, otherwise false.
   */ 
  static boolean isValidChar(String ch) {
    if (
      (GreekString.isAlphabetic(ch)) 
      || (GreekString.isAccentOrBreathing(ch)) 
      || (GreekString.isQuantity(ch))
      || (GreekString.isPunctuation(ch))
      || (ch == GreekString.diaeresis)
      || (ch == GreekString.asterisk)
    )  {
      return true
    } else {
      return false
    }
  }

  /** Determines if a one-character long string is an alphabetic
   * character.
   * @param ch String to check.
   * @returns true if character is alphabetic, otherwise false.
   */ 
  static boolean isAlphabetic(ch) {
    if (
      (GreekString.consonant.contains(ch))
      || (GreekString.vowel.contains(ch))
    ) {
      return true
    } else  {
      return false 
    }
  }

  /** Determines if a one-character long string is an accent
   * or breathing character.
   * @param ch String to check.
   * @returns true if character is accent or breathing, otherwise false.
   */   
  static boolean isAccentOrBreathing(ch) {
    if (
      (breathing.contains(ch))
      || (accent.contains(ch))
    ) {
      return true
    } else  {
      return false 
    }
  }


  /** Determines if a single-character String
   * is a vowel.
   * @param ch Character to examine.
   * @returns True if ch is a vowel.
   */
  static boolean isVowel (String ch) {
    return vowel.contains(ch)
  }


  /** Determines if a single-character String
   * is a punctuation character.
   * @param ch Character to examine.
   * @returns True if ch is a punctuation character.
   */
  static boolean isPunctuation (String ch) {
    return punctuation.contains(ch)
  }


  /** Determines if a single-character String
   * is a vowel-quantity character.
   * @param ch Character to examine.
   * @returns True if ch is a vowel quantity character.
   */
  static boolean isQuantity (String ch) {
    return quantity.contains(ch)
  }


  /** Determines if a StringBuffer contains a vowel character.
   * @param buff StringBuffer to examine.
   * @returns True if buff contains a vowel.
   */
  static boolean containsVowel (StringBuffer buff) {
    return containsVowel(buff.toString())
  }

  /** Determines if a String contains a vowel character.
   * @param s String to examine.
   * @returns True if s contains a vowel.
   */
  static boolean containsVowel (String s) {
    boolean vowelSeen = false
    s.each { ch ->
      if (vowel.contains(ch)) {
	vowelSeen = true
      }
    }
    return vowelSeen
  }


  /** Determines if a String is a diphthong.
   * @param s String to examine.
   * @returns True if s is a diphthong.
   */
  static boolean isDiphthong (String s) {
    return diphthong.contains(s)
  }


  /** Overrides default implementation of toString.
   * @returns Beta-code version of a Greek word.
   */
  String toString() {
    return this.greekString
  }

}