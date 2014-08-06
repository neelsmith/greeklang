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
  def breathing = [')','(']
  def accent = ['/','\\','=']
  def quantity = ['_','^']



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

}