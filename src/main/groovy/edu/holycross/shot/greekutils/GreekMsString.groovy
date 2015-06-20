package edu.holycross.shot.greekutils

import edu.unc.epidoc.transcoder.TransCoder
import java.text.Normalizer
import java.text.Normalizer.Form

class GreekMsString extends GreekString {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0


  /** Immutable set of punctuation characters allowed in MSS. */
  static msPunctuation = [
    "·", "⁑" , "⁚"
  ]


  // combining macron, combining breve
  // combining diaeresis
  // floating grave: 
  static msQuantityOrBreathing = [
    "`"
  ]

  


  String greekString
  
  GreekMsString(String srcString, String greekMapping)  {
    super(srcString, greekMapping)

    TransCoder xcoder = new TransCoder()
    xcoder.setParser(greekMapping)
    xcoder.setConverter("BetaCode")
    
    Integer count = 0
    String betaString = xcoder.getString(srcString).toLowerCase()
    betaString = betaString.replaceAll("s1","s")


    while (count < betaString.length() - 1) {
      if (!(isValidMsChar(betaString.substring(count,count+1)))) {
	System.err.println "Error parsing ${betaString}: failed on ${betaString.substring(count,count+1)} (char ${count})"
	System.err.println "GreekString:constructor with ${greekMapping} invalid character at position ${count}:  '" + betaString.substring(count,count+1) + "'"
	throw new Exception("GreekString:constructor with ${greekMapping} invalid character at position ${count}:  '" + betaString.substring(count,count+1) + "'")
      }
      count++
    }
    this.greekString = betaString

  }


  /** Constructor verifies that srcSring contains only valid characters
   * for beta-code representation.
   * @param srcString Greek string, in beta code.
   * @throws Exception if not all characters in betaString are valid.
   */

  /*
  GreekMsString(String srcString)  throws Exception {
    Integer count = 0
    String betaString = srcString.toLowerCase()
    while (count < betaString.length() - 1) {
      if (!(isValidMsChar(betaString.substring(count,count+1)))) {
	System.err.println "Error parsing ${betaString}: failed on ${betaString.substring(count,count+1)} (char ${count})"
	throw new Exception("GreekString: invalid characer ${betaString.substring(count,count+1)}")
      }
      count++
    }
    this.greekString = betaString
    }*/



  /** Determines if a single-character String
   * is a specially allowed MS punctuation character.
   * @param ch Character to examine.
   * @returns True if ch is a punctuation character.
   */
  static boolean isMsPunctuation (String ch) {
    boolean validPunct = false
    GreekMsString.msPunctuation.each { s ->
      if (s == ch) {
	validPunct = true
      }
    }
    return validPunct
  }




  /** Determines if a single-character String
   * is a specially allowed MS quantity or breathing character.
   * @param ch Character to examine.
   * @returns True if ch is a quantity or breathing character.
   */
  static boolean isMsQuantityOrBreathing (String ch) {
    boolean validChar = false
    GreekMsString.msQuantityOrBreathing.each { s ->
      if (s == ch) {
	validChar = true
      }
    }
    return validChar
  }



 
  static boolean isValidMsChar(String ch) {
    System.err.println "checkin MsChar ${ch}"
    System.err.println "is it msPunct? " + GreekMsString.isMsPunctuation(ch)
    if (
      (GreekString.isAlphabetic(ch)) 
      || (GreekString.isAccentOrBreathing(ch)) 
      || (GreekString.isQuantity(ch))
      || (GreekString.isPunctuation(ch))
      || (GreekString.isWhiteSpace(ch))
      || (ch == GreekString.diaeresis)
      || (ch == GreekString.asterisk)
      // Additional tests specific to MS orthography:
      || (GreekMsString.isMsPunctuation(ch))
      || (GreekMsString.isMsQuantityOrBreathing(ch))
    )  {
      return true
    } else {
      System.err.println("GreekMsString: invalid beta code character ${ch}")
      return false
    }
  }





}