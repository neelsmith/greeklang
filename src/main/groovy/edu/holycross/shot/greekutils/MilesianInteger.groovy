package edu.holycross.shot.greekutils

import edu.unc.epidoc.transcoder.TransCoder
import java.text.Normalizer
import java.text.Normalizer.Form

/**
 * A class for working with numeric data in the Milesian notational system.
 */
class MilesianInteger {

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


  /** The string in beta code form.*/
  String milesianString

  /** Constructor verifies that srcString, supplied in an identified
   * system for encoding Greek, contains only valid characters
   * for a MilesianString's underlying beta-code representation.
   */
  MilesianInteger(String srcString, String greekMapping)  {
    /*
    TransCoder xcoder = new TransCoder()
    xcoder.setParser(greekMapping)
    xcoder.setConverter("BetaCode")
    
    Integer count = 0
    String betaString = xcoder.getString(srcString).toLowerCase()
    betaString = betaString.replaceAll("s1","s")
    while (count < betaString.length() - 1) {
      if (!(isValidChar(betaString.substring(count,count+1)))) {
	System.err.println "Error parsing ${betaString}: failed on ${betaString.substring(count,count+1)} (char ${count})"
	System.err.println "GreekString:constructor with ${greekMapping} invalid character at position ${count}:  '" + betaString.substring(count,count+1) + "'"
	throw new Exception("GreekString:constructor with ${greekMapping} invalid character at position ${count}:  '" + betaString.substring(count,count+1) + "'")
      }
      count++
    }
    this.greekString = betaString
    */
  }

  /** Constructor verifies that srcSring contains only valid characters
   * for beta-code representation.
   * @param srcString Greek string, in beta code.
   * @throws Exception if not all characters in betaString are valid.
   */
  MilesianInteger(String srcString) 
  throws Exception {
    /*
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
    */
  }


}