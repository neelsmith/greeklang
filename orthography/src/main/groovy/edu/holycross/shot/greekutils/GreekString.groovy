package edu.holycross.shot.greekutils

import edu.unc.epidoc.transcoder.TransCoder
import java.text.Normalizer
import java.text.Normalizer.Form

/**
 * A class for working with text in Greek.  Instances may
 * be initialized with any encoding of Greek that Hugh Cayless'
 * transcoder recognizes;  static methods expect beta code strings.
 * Valid Greek characters are limited to the small set that can be
 * used to construct valid morphologically parseable lexical tokens, plus punctuation characters.
 * If your representation of Greek text includes other characaters, such
 * as numeric characters, or more exotic kinds of punctuatio, you will
 * have to strip those out before creating a GreekString object.
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
    'w','|'
  ]

  /** Immutable set of breathing characters. */
  static breathing = [')','(']

  /** Immutable set of accent characters. */
  static accent = ['/','\\','=']

  // these are not really orthographic, are they?
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
    ".",
    ";",
    ",",
    ":",
    "'"
  ]


  /** The string in beta code form.*/
  String greekString

  /** Constructor verifies that srcSring, supplied in an identified
   * system for encoding Greek, contains only valid characters
   * for a GreekString's underlying beta-code representation.
   * @param srcString Greek string, in beta code.
   * @param System for mapping Greek onto Unicode.  String value may
   * be any of the values for "sourceEncoding" supported by the
   * epidoc transcoder, such as "Unicode".
   * @throws Exception if not all characters in betaString are valid.
   */
  GreekString(String srcString, String greekMapping)  {
    TransCoder xcoder = new TransCoder()
    xcoder.setParser(greekMapping)
    xcoder.setConverter("BetaCode")

    Integer count = 0
    String betaString = xcoder.getString(srcString).toLowerCase()
    betaString = betaString.replaceAll("s1","s")
    System.err.println "Analyze " + srcString + " as " + greekMapping + " (len ${betaString} = " + betaString.length() + ")"

    while (count < betaString.length()) {
      if (!(isValidChar(betaString.substring(count,count+1)))) {
	System.err.println "Error parsing ${betaString}: failed on ${betaString.substring(count,count+1)} (char ${count})"
	System.err.println "GreekString:constructor with ${greekMapping} invalid character at position ${count}:  '" + betaString.substring(count,count+1) + "'"
	throw new Exception("GreekString:constructor with ${greekMapping} invalid character at position ${count}:  '" + betaString.substring(count,count+1) + "'")
      }
      count++
    }
    this.greekString = betaString

  }

  GreekString(String srcString, String greekMapping, boolean ignoreInvalid)  {
    TransCoder xcoder = new TransCoder()
    xcoder.setParser(greekMapping)
    xcoder.setConverter("BetaCode")

    Integer count = 0
    String betaString = xcoder.getString(srcString).toLowerCase()
    betaString = betaString.replaceAll("s1","s")
    this.greekString = betaString
  }

  /** Constructor verifies that srcSring contains only valid characters
   * for beta-code representation.
   * @param srcString Greek string, in beta code.
   * @throws Exception if not all characters in betaString are valid.
   */
  GreekString(String srcString)
  throws Exception {
    Integer count = 0
    String betaString = srcString.toLowerCase()
    while (count < betaString.length() ) {
      if (!(isValidChar(betaString.substring(count,count+1)))) {
	System.err.println "Error parsing ${betaString}: failed on ${betaString.substring(count,count+1)} (char ${count})"
	throw new Exception("GreekString: invalid characer ${betaString.substring(count,count+1)}")
      }
      count++
    }
    this.greekString = betaString
  }



  /* ************************************************************************************* */
  //
  //  ************  METHODS IDENTIFYING CHARACTER CLASSES   *****************************


  /** Determines if a one-character long string is a valid GreekString
   * character.
   * @param ch String to check.
   * @returns true if character is valid, otherwise false.
   */
  static boolean isValidChar(String ch) {
    Integer debug = 0
    if (debug> 0) {
      System.err.println "GreekString: check " + ch
    }
    if (
      (GreekString.isAlphabetic(ch))
      || (GreekString.isAccentOrBreathing(ch))
      || (GreekString.isQuantity(ch))
      || (GreekString.isPunctuation(ch))
      || (GreekString.isWhiteSpace(ch))
      || (ch == GreekString.diaeresis)
      || (ch == GreekString.asterisk)
    )  {
      if (debug > 0) { System.err.println "${ch} is OK!" }
      return true
    } else {
      System.err.println("GreekString: invalid beta code character ${ch}")
      return false
    }
  }

  /** Determines if a one-character long string is an alphabetic
   * character.
   * @param ch String to check.
   * @returns true if character is alphabetic, otherwise false.
   */
  static boolean isAlphabetic(String ch) {
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


  /** Determines if a one-character long string is an accent.
   * @param ch String to check.
   * @returns true if character is accent, otherwise false.
   */
  static boolean isAccent(ch) {
    return (accent.contains(ch))
  }


  /** Determines if a one-character long string is a breathing.
   * @param ch String to check.
   * @returns true if character is a breathing, otherwise false.
   */
  static boolean isBreathing(ch) {
    return (breathing.contains(ch))
  }


  /** Determines if a single-character String
   * is a consonant.
   * @param ch Character to examine.
   * @returns True if ch is a consonant.
   */
  static boolean isConsonant (String ch) {
    return consonant.contains(ch)
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



  static boolean isWhiteSpace (String ch) {
    return Character.isWhitespace(ch as char)
    //punctuation.contains(ch)
  }


  /** Determines if a single-character String
   * is a vowel-quantity character.
   * @param ch Character to examine.
   * @returns True if ch is a vowel quantity character.
   */
  static boolean isQuantity (String ch) {
    return quantity.contains(ch)
  }



  /** Determines if a String is a diphthong.
   * @param s String to examine.
   * @returns True if s is a diphthong.
   */
  static boolean isDiphthong (String s) {
    return diphthong.contains(s)
  }

  //
  //  ************  END METHODS IDENTIFYING CHARACTER CLASSES   **************************
  /* ************************************************************************************* */







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



  /** Removes accent characters from a String.
   * @param s String to modify.
   * @returns The string with all accent characters removed.
   */
  static String stripAccents(String s) {
    StringBuffer stripped = new StringBuffer()
    s.each { ch ->
      if (! isAccent(ch)) {
	stripped.append(ch)
      }
    }
    return stripped.toString()
  }


  static ArrayList tokenize(GreekString s) {
    ArrayList tokens = s.greekString.split(/\s/)
    return tokens
  }


  /** Overrides default implementation of toString.
   * @returns ASCII-only version of a Greek word.
   */
  String toString() {
    return this.greekString
  }


  /** Overrides default implementation of toString.
   * @param asUnicode True if output should be Unicode
   * in NFC form.
   * @returns ASCII-only version of a Greek word.
   */
  String toString(boolean asUnicode) {
    if (asUnicode) {
      TransCoder xcoder = new TransCoder()
      xcoder.setParser("BetaCode")
      xcoder.setConverter("UnicodeC")
      String u = xcoder.getString(this.greekString)
      u = Normalizer.normalize(u, Form.NFC)
      if (debugLevel > 1) {
	System.err.println "Before check, normalized " + u
      }
      // Override epidoc mapping of high stop
      // and Greek question mark:
      u  = u.replaceAll(/\u00B7/,"\u0387")
      u = u.replaceAll(/\u003B/,"\u037E")
      if (debugLevel > 1) {
	System.err.println "After check " + u
      }

      return u
    } else {
      return this.greekString
    }
  }

}
