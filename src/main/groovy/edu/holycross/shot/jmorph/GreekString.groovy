package edu.holycross.shot.jmorph

/**
 * A class for working with a Greek string represented
 * in a subset of the TLG's beta code.
 *
 * Valid characters are:
 * alphabetic
 * 
 */
class GreekString {
  
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

  def diphthong = [
    "ai", "ei","oi",
    "a|", "h|", "w|",
    "au","eu", "ou",
    "hu", "ui"
  ]

  // Include beta-code diaeresis "+"
  def breathing = [')','(']
  def accent = ['/','\\','=']
  def quantity = ['_','^']



  String greekString


  /** Constructor verifies that
   * String contains only valid characters.
   * @param betaString Greek string, in beta code.
   * @throws Exception if not all characters in betaString are valid.
   */
  GreekString(String betaString) 
  throws Exception {
    Integer count = 0
    while (count < betaString.length() - 1) {
      if (!(validChar(betaString.substring(count,count+1)))) {
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
  boolean validChar(String ch) {
    if (
      (breathing.contains(ch))
      || (isAlphabetic(ch)) 
      || (accent.contains(ch)) 
      || (quantity.contains(ch))
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


  // num chars to include in syll
  // with vowel at pos count
  Integer countToInclude(String s, Integer startFrom) {
    Integer include = 0
    String lookAt = s.substring(startFrom)


    boolean done = false
    Integer max = lookAt.size() - 1
    Integer count = 0
    while ((!done) && (count < max))  {
      String ch = lookAt.substring(count,count + 1)
      if (isAccentBreathing(ch)) {
	include++;
      } else {
	if (lookAt.size() > count+2) {
	  if (diphthong.contains(ch + lookAt.substring(count+1,count+2))) {
	    include++;
	  }
	}
      }
      count++
    }
    println "Looked at " + lookAt + " and figured " + include   
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

      // are there characters to add?
      if (appendCount > 0) {
	syllable.append(ch)
	println "append ${appendCount}, so appending  " + ch + " to get " + syllable
	appendCount--
	println "Decrement appendcount  to " + appendCount

      } else {
	// basic case: have we seen a vowel?
	if (!vowelSeen) {

	  syllable.append(ch)
	  println "Count at 0 but no vowel yet: added to get " + syllable
	  if (vowel.contains(ch)) {
	    vowelSeen = true
	    appendCount = countToInclude(greekString, count)
	  }

	} else {
	  println "Count at 0 and already have a vowel! End syll." + syllable
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
      if (vowel.contains(syllable[0])) {
	syllables.add(syllable.toString())
      } else {
	String lastSyll = syllables[syllables.size() - 1] + syllable.toString()
	syllables[syllables.size() - 1] = lastSyll
      }
    }
    return syllables
  }


  /** Overrides default method.
   */
  String toString() {
    return this.greekString
  }

}