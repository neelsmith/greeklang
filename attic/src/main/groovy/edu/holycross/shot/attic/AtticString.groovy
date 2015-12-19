package edu.holycross.shot.attic

import edu.unc.epidoc.transcoder.TransCoder
import java.text.Normalizer
import java.text.Normalizer.Form

import edu.holycross.shot.orthography.GreekOrthography

// account for:
/*
- aspirate H
- E = e, h, ei
- O = o, w, ou
- instead of c, y, XS and FS
- very early, some QOPPA.  Not included here.
*/


/**
 * A class for working with Greek text written in the alphabet used in Athens
 * before 403 BCE.
 */
class AtticString implements GreekOrthography, Comparable<AtticString>{

  // Temporary constructs for debugging:
  Integer debugLevel = 0


  // Regular expressions to work with mappings of breathings
  // in different encoding systems.
  //
  /** RE identifying Epidoc transcoder's representation of rough breathing. */
  static java.util.regex.Pattern aspirate_epidoc = ~/^([AEIOU]+)[\\(]/

  /** RE identifying initial rough breathing in AtticString ascii encoding. */
  static java.util.regex.Pattern aspirate_attic = ~/^H([AEIOU])/

  /** RE identifying initial diphthong  NOT followed by rough breathing in
  * lower-case ASCII encoding used by Epidoc transcoder. */
  static java.util.regex.Pattern initial_diphthong_epidoc = ~/^([aeiou]{2})([^\\(])/

  /** RE identifying initial vowel NOT followed by rough breathing in
  * lower-case ASCII encoding used by Epidoc transcoder. */
  static java.util.regex.Pattern initial_vowel_epidoc = ~/^([aeiou])([^\\(])/





  /** Immutable set of punctuation characters. */
  public static ArrayList punctuation = [
    ".",
    ":"
  ]

  /** RE matching AtticString punctuation characters. */
  static  punctuationRE = ~/[\.:]+/

  /** Immutable set of code point values for valid white-space characters. */
  public static ArrayList whiteSpace = [
    9,10,12,13,32
  ]

  /** Ordered map of beta-code alphabetic characters for use in comparator */
  static HashMap asciiOrder = [
    0:'A',1:'B',2:'G',3:'D',4:'E',
    5:'Z',7:'Q',8:'I',9:'K',
    10:'L',11:'M',12:'N',14:'O',
    15:'P',16:'R',17:'S',18:'T',19:'U',
    20:'F',21:'X',22: 'H'
  ]

  /** The string in ascii form.*/
  String atticString

  /** True if AtticString is validly encoded. */
  boolean validString

  /** Implementation of method required for GreekOrthography interface.
  * True if AtticString is validly encoded. */
  boolean isValid() {
    return validString
  }

  /** Formats a String in AtticString representation to use
  * the Epidoc transcoder's representation of rough breathing.
  * @param s The String to reformat.
  * returns A String formatting the aspirate according to the
  * ASCII conventions used by the Epidoc transcoder.
  */
  static String atticToEpidocAspirate(String s) {
    //System.err.println "atticToEpidocAspirate: check for rough breathing on attic " + s.toLowerCase()
    String breathe = s.replaceAll(aspirate_attic) { fullMatch, vow ->
      vow + "("
    }
    //System.err.println "Yields epidoc  formatting  = "   + breathe
    return breathe
  }

  /** Formats a String in the Epidoc transcoder's representation of rough breathing
  * to the format used by AtticString objects.
  * @param s The String to reformat.
  * returns A String formatting the aspirate in the AtticString format.
  */
  static String epidocToAtticAspirate(String s) {
    //System.err.println "epidocToAtticAspirate: work on " + s

    //aspirate_epidoc
    String breathe = s.replaceAll(aspirate_epidoc) { fullMatch, vow ->
      "H" + vow
    }
    return breathe
  }


  /**
  * Converts a string in the Unicode Greek mapping of AtticStrings
  * to the corresponding ASCII-only mapping.
  * @param s String to convert.
  * @returns A String in the ASCII-only encoding of AtticString values.
  */
  static String asciiForUcode(String s) {
    String normalized = Normalizer.normalize(s.toUpperCase(), Form.NFC)
    String adjustedUcode = adjustVowelAccentCombo(s, true)
    //System.err.println "asciiForUcode: adjusted vowel/acc to " + adjustedUcode

  //  adjusted = epidocToAtticAspirate(adjusted)
    //System.err.println "Changed epidoc to attic aspirate" + adjusted
    TransCoder xcoder = new TransCoder()
    xcoder.setParser("Unicode")
    xcoder.setConverter("BetaCode")


    String transcode = xcoder.getString(adjustedUcode).replaceAll("S1","S")
    transcode = transcode.replaceFirst('\\)', "")

    //System.err.println "Submit to  aspirate check " + transcode
    transcode = epidocToAtticAspirate(transcode)
    //System.err.println "Transcoded as " + transcode
    // rough breathing!

    //transcode =  atticToEpidocAspirate(transcode)

    return transcode
  }


  /** Converts a String as output by Epidoc transcoder to use
  * AtticString formatting of breathing.
  * @param s String to convert.
  * @returns A String value using AtticString formatting for breathing.
  */
  static String epidocSmoothBreathingToAttic(String s) {
    //System.err.println "Cehck for smooth breathing on epidoc format " + s
    String lc = s.toLowerCase()


    String breathe = lc.replaceFirst(initial_diphthong_epidoc) { fullMatch, vowels, cons ->
      //System.err.println "Yes have diphthong with full match ${fullMatch} and vowelse  " + vowels
      vowels + ")"  + cons
    }

    if (breathe == lc) {
      breathe = breathe.replaceFirst(initial_vowel_epidoc) { fullMatch, vow, cons ->
        vow + ")" + cons
      }
    }
    //System.err.println "Breathe is " + breathe

    return breathe
  }


  /**  Converts a string in the ASCII-only  mapping of AtticStrings to the corresponding Unicode Greek mapping.
  * @param s The String to convert.
  * @retrurns A String in the Unicode Greek encoding of AtticString values.
  */
  static String ucodeForAscii(String s) {
    //System.err.println "ucodeForAscii: get ucode for " + s
   String adjustRough = atticToEpidocAspirate(s)
   //System.err.println "Adjusted attic to epidoc aspirate" + adjustRough
   String adjusted = asciiVowelAccToUni(adjustRough.toLowerCase())
   //System.err.println "Adjusted vowel+perispomenon combos to " + adjusted
   adjusted = epidocSmoothBreathingToAttic(adjusted)

   //System.err.println "ucodeForAscii: after checking breathing, xcoding " + adjusted

    TransCoder xcoder = new TransCoder()

    xcoder.setParser("BetaCode")
    xcoder.setConverter("UnicodeC")
    return xcoder.getString(adjusted)
  }


  /** Replaces ASCII-only vowel-accent combinations not converted by
  * Epidoc transcoder to corresponding encoding in the Unicode Greek range.
  * Since the ASCII characters "E" and "O" correspond only to epsilon and
  * omicron in the ASCII transliteration of literary Ionic Greek, the
  * Epidoc transcoder does not support making them perispomenon.
  * The ASCII sequences are here converted to the equivalent Unicode
  * character followed by the combining form of the perispomenon.
  * @param s ASCII string to convert.
  * @returns A String Unicode Greek substitutions for "E=" and "O=",
  * in form NFC.
  */
  static String asciiVowelAccToUni(String s) {
    Normalizer.normalize(s.toUpperCase().replaceAll("E=", "ε͂").replaceAll("O=", "ο͂"), Form.NFC)
  }


  /** Maps encodings of epsilon or omicron followed by perispomenon between ASCII-only and Unicode Greek encoding of an AtticString.
  * @param s String value to map to other encoding.
  * @param inUnicode True if s is in Unicode Greek encoding, otherwise
  * s is in ASCII-only encoding.
  * @returns A String value with instances of epsilon or omicron followed by
  * perispomenon converted to the other encoding system for AtticString values.
  */
  static String adjustVowelAccentCombo(String s, boolean inUnicode) {
    if (inUnicode) {
      String nfcStyle = Normalizer.normalize(s.toLowerCase(),Form.NFC)
      return s.replaceAll( "ε͂","E=").replaceAll( "ο͂", "O=")

    } else {
      return asciiVowelAccToUni(s)
    }
  }

  /** Constructor verifies that scSring contains only valid characters
   * for constructing an AtticString in one of the two defined encodings,
   * ASCII-only, or encoding using characters from the Unicode range of
   * polytonic Greek.
   * @param inUnicode True if srcString is in the Unicode Greek range encoding,
   * otherwise srcString is in the ASCII-only encoding.
   * @throws Exception if not all characters in srcString are valid.
   */
  AtticString(String srcString, boolean inUnicode)  {
    Integer count = 0
    String asciiString = ""

    if (inUnicode) {
      asciiString = asciiForUcode(srcString.toLowerCase())
    } else {
      asciiString = srcString.toUpperCase()
    }
    while (count < asciiString.length()) {
      if (!(isValidChar(asciiString.substring(count,count+1)))) {
	System.err.println "Error parsing ${asciiString}: failed on ${asciiString.substring(count,count+1)} (char ${count})"
	System.err.println "AtticString:constructor with Unicode = ${inUnicode} invalid character at position ${count}:  '" + asciiString.substring(count,count+1) + "'"
	throw new Exception("AtticString:constructor with Unicode = ${inUnicode} invalid character at position ${count}:  '" + asciiString.substring(count,count+1) + "'")
      }
      count++
    }
    this.atticString = asciiString.replaceAll(/\s+/," ")
    validString = true
  }





  /** Constructor checkes that scSring contains only valid characters
   * for constructing an AtticString in one of the two defined encodings,
   * ASCII-only, or encoding using characters from the Unicode range of
   * polytonic Greek, and records the result of that check in the isValid
   * member variable.
   * @param inUnicode True if srcString is in the Unicode Greek range encoding,
   * otherwise srcString is in the ASCII-only encoding.
   * @param ignoreInvalid True if constructor should still return an object
   * when input is not valid.
   * @throws Exception if not all characters in srcString are valid, and
   * ignoreInvalid is false.
   */
  AtticString(String srcString, boolean inUnicode, boolean ignoreInvalid)  {
    String asciiString = ""
    if (inUnicode) {
      asciiString = asciiForUcode(srcString.toLowerCase())
    } else {
      asciiString = srcString.toUpperCase()
    }
    this.atticString = asciiString.replaceAll(/\s+/," ")


    validString = true
    int count = 0
    while (count < asciiString.length() ) {
      if (!(isValidChar(asciiString.substring(count,count+1)))) {
        if (! ignoreInvalid) {
  System.err.println "Error parsing ${asciiString}: failed on ${asciiString.substring(count,count+1)} (char ${count})"
  throw new Exception("AtticString: invalid characer ${asciiString.substring(count,count+1)}")
}
  validString = false
      }
      count++
    }
  }

  /** Constructor verifies that srcSring contains only valid characters
   * for ascii representation.
   * @param srcString Greek string, in ascii.
   * @throws Exception if not all characters in srcString are valid.
   */
  AtticString(String srcString)
  throws Exception {
    Integer count = 0
    String asciiString = srcString.toUpperCase()
    while (count < asciiString.length() ) {
      if (!(isValidChar(asciiString.substring(count,count+1)))) {
	System.err.println "Error parsing ${asciiString}: failed on ${asciiString.substring(count,count+1)} (char ${count})"
	throw new Exception("AtticString: invalid characer ${asciiString.substring(count,count+1)}")
      }
      count++
    }
    this.atticString = asciiString.replaceAll(/\s+/," ")
    validString = true
  }



  /* ************************************************************************************* */
  //
  //  ************  METHODS IDENTIFYING CHARACTER CLASSES   *****************************


  /** Determines if a one-character long string is a valid AtticString
   * character.
   * @param ch String to check.
   * @returns true if character is valid, otherwise false.
   */
  static boolean isValidChar(String ch) {
    Integer debug = 0
    if (debug> 0) {
      System.err.println "AtticString: check " + ch
    }
    if (
      (AtticString.isAlphabetic(ch))
      || (AtticString.isAccentOrBreathing(ch))
      || (AtticString.isQuantity(ch))
      || (AtticString.isPunctuation(ch))
      || (AtticString.isWhiteSpace(ch))
      || (ch == AtticPhonology.elision)
    )  {
      if (debug > 0) { System.err.println "${ch} is OK!" }
      return true
    } else {
      System.err.println("AtticString: invalid ascii character ${ch}")
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
      (AtticString.isConsonant(ch))
      || (AtticString.isVowel(ch))
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
  static boolean isAccentOrBreathing(String ch) {
    if (
      (ch == "H")
      || (AtticPhonology.isAccent(ch))
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
    return (AtticPhonology.isAccent(ch))
  }


  /** Determines if a one-character long string is a breathing.
   * @param ch String to check.
   * @returns true if character is a breathing, otherwise false.
   */
  static boolean isBreathing(ch) {
    return (ch == "H")
  }


  /** Determines if a single-character String
   * is a consonant.
   * @param ch Character to examine.
   * @returns True if ch is a consonant.
   */
  static boolean isConsonant (String ch) {
    return AtticPhonology.isConsonant(ch)
  }


  /** Determines if a single-character String
   * is a vowel.
   * @param ch Character to examine.
   * @returns True if ch is a vowel.
   */
  static boolean isVowel (String ch) {
    return AtticPhonology.isVowel(ch)
  }


  /** Determines if a single-character String
   * is a vowel-quantity character.
   * @param ch Character to examine.
   * @returns True if ch is a vowel quantity character.
   */
  static boolean isQuantity (String ch) {
    return AtticPhonology.isQuantity(ch)
  }


  /** Determines if a String is a diphthong.
   * @param s String to examine.
   * @returns True if s is a diphthong.
   */
  static boolean isDiphthong (String s) {
    return AtticPhonology.isDiphthong(s)
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
   * is a white-space character.
   * @param ch Character to examine.
   * @returns True if ch is a white-space character.
   */
  static boolean isWhiteSpace (String ch) {
    return Character.isWhitespace(ch as char)
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
      if (isVowel(ch)) {
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


  /** Splits a AtticString object into an ordered
  * list of white-space-delimited AtticStrings.
  * @returns List of AtticStrings.
  */
  ArrayList tokenize() {
    return AtticString.tokenize(this)
  }

  /** Splits a AtticString object into an ordered
  * list of white-space-delimited AtticStrings.
  * @param s The AtticString to split up.
  * @returns List of AtticStrings.
  */
  static ArrayList tokenize(AtticString s) {
    ArrayList tokens = []
    s.atticString.split(/\s+/).each {
      String token = it.toString().replaceAll(punctuationRE, '')
      tokens.add(new AtticString(token))
    }
    return tokens
  }


  /** Overrides default implementation of toString.
   * @returns ASCII-only version of a Greek word.
   */
  String toString() {
    return this.atticString
  }


  /** Overrides default implementation of toString with signature
  * required for GreekOrthography interface.
  * @param asUnicode True if output should be Unicode
  * in NFC form.
  * @returns ASCII-only version of a Greek word.
  */
  String toString(boolean asUnicode) {
    if (asUnicode) {
      TransCoder xcoder = new TransCoder()
      xcoder.setParser("BetaCode")
      xcoder.setConverter("UnicodeC")
      String wBreath = epidocSmoothBreathingToAttic(this.atticString)
//System.err.println "TRANSCODE " + wBreath
      String u = xcoder.getString(wBreath)
      u = Normalizer.normalize(u, Form.NFC)
      if (debugLevel > 1) {
	//System.err.println "Before check, normalized " + u
      }
      // Override epidoc mapping of high stop
      // and Greek question mark:
      u  = u.replaceAll(/\u00B7/,"\u0387")
      u = u.replaceAll(/\u003B/,"\u037E")
      if (debugLevel > 1) {
	//System.err.println "After check " + u
      }

      return u
    } else {
      return this.atticString
    }
  }






    /////////////////////////////////////////////////////////////////////
    // COMPARISON METHODS ///////////////////////////////////////////////



    /** Compares a pair of one-character long Strings using the
    * ordered map in asciiOrder.
    * @return  -1 if s1 < s2, 0 if s1 == s2, 1 if s1 > s2
    */
    static private int charComp (String s1, String s2) {
      def mapEntry1 =   asciiOrder.find {it.value == s1.toLowerCase()}
      def mapEntry2 =   asciiOrder.find{it.value == s2.toLowerCase()}
      if ((!mapEntry1) || (!mapEntry2)) {
        // non-comparing character:  ignore
        // by treating as equal
        return 0
      }
      if (mapEntry1.key == mapEntry2.key) {
        return 0
      } else if (mapEntry1.key > mapEntry2.key) {
        return 1
      } else {
        return -1
      }
    }

    /** Implements required comparison method for Comparable interface.
    * @param atticStr An AtticString to compare to this.
    * @returns -1, 0 or 1 depening on whether atticStr is less than,
    * equivalent to or greater than this object.
    */
    @Override
    int compareTo(AtticString atticStr) {
      String s2 = atticStr.toString()

      int idx1 = 0
      int idx2 = 0
      int maxChars = 0
      if (atticString.size() > s2.size()) {
        maxChars = s2.size()
      } else {
        maxChars = atticString.size()
      }

      boolean done = false
      while (!done) {
        // skip over non-alphabetic chars:
        while (
        (! AtticString.isAlphabetic(atticString[idx1])) &&
        (idx1 < (maxChars -1))
        ) {
          idx1++
        }
        while (
        (! AtticString.isAlphabetic(s2[idx2])) &&
        (idx2 < (maxChars - 1))
        ) {
          idx2++
        }

        // compare pair of alphabetic chars:
        def cComp = charComp(atticString[idx1],s2[idx2])
        if (cComp != 0) {
  	return cComp
        } else {
  	idx1++;
  	idx2++;
        }
        if ((idx1 >= (maxChars - 1) ) || (idx2 >= (maxChars -1))) {
  	done = true
        }
      }


      // two tokens matched for all chars, but
      // if one is longer, it sorts later:
      if (atticString.size() > s2.size()) {
        return 1
      } else if (atticString.size() == s2.size()) {
        return 0
      } else {
        return -1
      }
    }



}
