package edu.holycross.shot.jmorph

/**
 * A class for working with a Greek word represented
 * in a subset of the TLG's beta code.
 *
 * Valid beta-code characters are:
 * alphabetic
 * breathings
 * accents
 * diaeresis
 * asterisk to mark upper case
 * 
 */
class GreekWord {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0


  
  def consonant = [
    'b','g','d',
    'z','q','k',
    'l','m','n','c',
    'p','r','s','t',
    'f','x','y'
  ]
  def vowel = [
    'a', 'e','h','i','o',
    'u','w'
  ]

  def breathing = [')','(']
  def accent = ['/','\\','=']
  def quantity = ['_','^']
  String diaeresis = "+"
  String asterisk = "*"


  /** Pairs of vowels forming diphthongs. */
  def diphthong = [
    "ai", "ei","oi",
    "a|", "h|", "w|",
    "au","eu", "ou",
    "hu", "ui"
  ]



  /** The word in beta code form.*/
  String greekString


  /** Constructor verifies that
   * String contains only valid characters.
   * @param betaString Greek string, in beta code.
   * @throws Exception if not all characters in betaString are valid.
   */
  GreekWord(String betaString) 
  throws Exception {
    Integer count = 0
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
  boolean isValidChar(String ch) {
    if (
      (breathing.contains(ch))
      || (isAlphabetic(ch)) 
      || (accent.contains(ch)) 
      || (quantity.contains(ch))
      || (ch == diaeresis)
      || (ch == asterisk)
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
  boolean isAlphabetic(ch) {
    if (
      (consonant.contains(ch))
      || (vowel.contains(ch))
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
  boolean isAccentBreathing(ch) {
    if (
      (breathing.contains(ch))
      || (accent.contains(ch))
    ) {
      return true
    } else  {
      return false 
    }
  }


  /**  Scans from a vowel within greekString to see how many 
   * further characters belong in the same syllable.
   * @param startFrom Index of character to start scanning from.
   * @returns Number of following characters belonging to the same
   * syllable as the indexed vowel.
   * @throws Exception if the indexed starting character is not
   * a vowel.
   */
  Integer countToInclude(Integer startFrom) 
  throws Exception {
    return countToInclude(this.greekString, startFrom)
  }

  /**  Scans from a vowel within a word to see how many 
   * further characters belong in the same syllable.
   * @param s The word to scan.
   * @param startFrom Index of character to start scanning from.
   * @returns Number of following characters belonging to the same
   * syllable as the indexed character.
   * @throws Exception if the indexed starting character is not
   * a vowel.
   */
  Integer countToInclude(String s, Integer startFrom) 
  throws Exception {
    String startChar = s.substring(startFrom,startFrom + 1)
    if (! vowel.contains(startChar)) {
      throw new Exception("GreekWord:countToInclude: ${startChar} is not a vowel.")
    }


    Integer include = 0
    boolean accentSeen = false
    String lookAt = s.substring(startFrom)


    boolean done = false
    Integer max = lookAt.size() - 1
    Integer count = 0
    while ((!done) && (count < max))  {
      String ch = lookAt.substring(count,count + 1)

      if (accentSeen && vowel.contains(ch)) {
	// then new syllable: do not include

      } else if (isAccentBreathing(ch)) {
	accentSeen = true
	include++;


      } else {
	if (lookAt.size() > count+2) {
	  if (diphthong.contains(ch + lookAt.substring(count+1,count+2))) {
	    if (lookAt.size() > count+3) {
	      if (lookAt.substring(count+2,count+3) == "+") {
		// no diphthong if diaeresis follows
	      } else {
		include++;
	      }
	    }
	  }
	}
      }
      count++
    }
    if (debugLevel > WARN) {println "Looked at " + lookAt + " and figured " + include   }
    return include
	  //already have vowel, so see if we need
	// to add this char to syllable or not.
	// possibilities:
	// - diphthong
	// - √ accents
	// - consonant cluster

	//needDiphthong = true
	//}

  }

  /** Breaks up syllables of GreekString into an ArrayList.

Syllables must have a vowel.
Scan L->R, and when we see a vowel, figure out if we need to append
more characters to it.

   * @returns An ArrayList of Strings, one per syllable.
   */
  ArrayList getSyllables() {
    def syllables = []

    boolean vowelSeen = false
    StringBuffer syllable = new StringBuffer()

    Integer appendCount = 0
    Integer count = 0
    while (count < this.greekString.size()) {
      String ch = this.greekString.substring(count,count+1)

      if (debugLevel > WARN) { println "Analyze character ${ch} at appendCoiunt ${appendCount}"}


      // are there characters to add?
      if (appendCount > 0) {
	syllable.append(ch)
	if (debugLevel > WARN) { println "append ${appendCount}, so appending  " + ch + " to get " + syllable }
	appendCount--
	if (debugLevel > WARN) { println "Decrement appendcount  to " + appendCount}
	

	if (appendCount == 0) {
	  syllables.add(syllable.toString())
	  if (debugLevel > WARN) {	  println "AppendCount at 0, so calling  it a syllable: " + syllables}
	  syllable.setLength(0)
	  vowelSeen = false
	}

      } else {
	// basic case: have we seen a vowel?
	if (!vowelSeen) {

	  syllable.append(ch)
	  if (debugLevel >= VERBOSE ) { println "Count at 0 but no vowel yet: added to get " + syllable }
	  if (vowel.contains(ch)) {
	    vowelSeen = true
	    appendCount = countToInclude(greekString, count)
	  }

	} else {
	  if (debugLevel > WARN) { println "Count at 0 and already have a vowel! End syll." + syllable }
	  // finished peekahead, but have seen a vowel
	  // so end of syll!
	  syllables.add(syllable.toString())
	  syllable.setLength(0)
	  syllable.append(ch)	  
	  vowelSeen = false
	}
      }

      // look at number of trailing consonants and decide whether
      // to split now or later...
      count++
    }

    // Add any left-over letters to end of 
    // last syllable:
    if (syllable.toString().size() > 0 ) {
      if (containsVowel(syllable)){
	syllables.add(syllable.toString())
      } else {
	String lastSyll = syllables[syllables.size() - 1] + syllable.toString()
	syllables[syllables.size() - 1] = lastSyll
      }
    }
    return syllables
  }

  boolean containsVowel (StringBuffer buff) {
    return containsVowel(buff.toString())
  }
  boolean containsVowel (String s) {
    boolean vowelSeen = false
    s.each { ch ->
      if (vowel.contains(ch)) {
	vowelSeen = true
      }
    }
    return vowelSeen
  }

  /** Overrides default implementation.
   * @returns Beta-code version of a Greek word.
   */
  String toString() {
    return this.greekString
  }

}