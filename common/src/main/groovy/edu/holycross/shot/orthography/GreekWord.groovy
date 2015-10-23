package edu.holycross.shot.greekutils


/**
 * A class for working with a Greek word.
 */
class GreekWord {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0




  /** The word in ascii format.*/
  GreekString asciiWord


  /** Constructor verifies that
   * String contains only valid characters.
   * @param srcString Greek string, in ascii.
   * @throws Exception if not all characters in srcString are valid.
   */
  GreekWord(String srcString)
  throws Exception {
    Integer count = 0
    this.asciiWord = new GreekString(srcString)
  }

  /**  Scans from a vowel within asciiWord to see how many
   * further characters belong in the same syllable.
   * @param startFrom Index of character to start scanning from.
   * @returns Number of following characters belonging to the same
   * syllable as the indexed vowel.
   * @throws Exception if the indexed starting character is not
   * a vowel.
   */
  Integer countToInclude(Integer startFrom)
  throws Exception {
    return countToInclude(this.asciiWord.toString(), startFrom)
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
  static Integer countToInclude(String s, Integer startFrom)
  throws Exception {
    String startChar = s.substring(startFrom,startFrom + 1)
    if (! GreekString.isVowel(startChar)) {
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

      if (accentSeen && GreekString.isVowel(ch)) {
	// then new syllable: do not include

      } else if (GreekString.isAccentOrBreathing(ch)) {
	accentSeen = true
	include++;


      } else {
	if (lookAt.size() > count+2) {
	  if (GreekString.isDiphthong(ch + lookAt.substring(count+1,count+2))) {
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
    //if (debugLevel > WARN) {println "Looked at " + lookAt + " and figured " + include   }
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




  /** Breaks up asciiWord into syllables.
   * Syllables must have a vowel, so we scan the string from left to
   * right,  and whenever we see a vowel, determine how many subsequent
   * characters belong to the same syllable.
   * @param wd A single Greek word in ascii encoding.
   * @returns An ArrayList of ascii strings, one per syllable.
   */
  ArrayList getSyllables() {
    return getSyllables(this.asciiWord.toString())
  }


  /** Breaks up a Greek word in ascii into syllables.
   * Syllables must have a vowel, so we scan the string from left to
   * right,  and whenever we see a vowel, determine how many subsequent
   * characters belong to the same syllable.
   * @param wd A single Greek word in ascii encoding.
   * @returns An ArrayList of ascii strings, one per syllable.
   */
  static ArrayList getSyllables(String wd) {
    def syllables = []

    boolean vowelSeen = false
    StringBuffer syllable = new StringBuffer()

    Integer appendCount = 0
    Integer count = 0
    while (count < wd.size()) {
      String ch = wd.substring(count,count+1)

      //if (debugLevel > WARN) { println "Analyze character ${ch} at appendCoiunt ${appendCount}"}


      // are there characters to add?
      if (appendCount > 0) {
	syllable.append(ch)
	//if (debugLevel > WARN) { println "append ${appendCount}, so appending  " + ch + " to get " + syllable }
	appendCount--
	//if (debugLevel > WARN) { println "Decrement appendcount  to " + appendCount}


	if (appendCount == 0) {
	  syllables.add(syllable.toString())
	  //if (debugLevel > WARN) {	  println "AppendCount at 0, so calling  it a syllable: " + syllables}
	  syllable.setLength(0)
	  vowelSeen = false
	}

      } else {
	// basic case: have we seen a vowel?
	if (!vowelSeen) {

	  syllable.append(ch)
	  //if (debugLevel >= VERBOSE ) { println "Count at 0 but no vowel yet: added to get " + syllable }
	  if (GreekString.isVowel(ch)) {
	    vowelSeen = true
	    appendCount = countToInclude(wd, count)
	  }

	} else {
	  //if (debugLevel > WARN) { println "Count at 0 and already have a vowel! End syll." + syllable }
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
      if (GreekString.containsVowel(syllable)){
	syllables.add(syllable.toString())
      } else {
	String lastSyll = syllables[syllables.size() - 1] + syllable.toString()
	syllables[syllables.size() - 1] = lastSyll
      }
    }
    return syllables
  }



  /** Overrides default implementation of toString.
   * @returns ASCII version of a Greek word.
   */
  String toString() {
    return this.asciiWord.toString()
  }

   String toString(boolean asUnicode) {
     if (asUnicode) {
       GreekString s = new GreekString(this.asciiWord.toString())
       System.err.println ("GreekWord: Got ${s}, as uni = " + s.toString(asUnicode))
       return s.toString(asUnicode)
    } else {
       return this.asciiWord.toString()
    }
   }

}
