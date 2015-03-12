package edu.holycross.shot.greekutils

import edu.unc.epidoc.transcoder.TransCoder
import java.text.Normalizer
import java.text.Normalizer.Form

/**
 * A class for working with numeric data in the Milesian notational system.
 */
class MilesianString {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0


  /** Immutable set of consonant characters. */
  static digit = [
    'α',
    'β','γ','δ',
    'ε','ϛ','ζ',
    'η','θ','ι',

    
    'κ','λ','μ',
    'ν','ξ','ο',
    'π','Ϟ',

    'ρ','σ','τ',
    'υ','φ','χ',
    'ψ','ω','ϡ',

    'Μ'

  ]

  static punct = [
    ',', "'", '"'
  ]


  static fract = [
    '𐅵', '𐅷'
    ]



  
  /** The string in beta code form.*/
  String milesianString

  /** Constructor verifies that srcString, supplied in an identified
   * system for encoding Greek, contains only valid characters
   * for a MilesianString's underlying beta-code representation.
   */
  MilesianString(String srcString, String greekMapping)  {
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
   * for representation using Unicode Greek range.
   * @param srcString Milesian string in Unicode Greek range.
   * @throws Exception if not all characters are valid.
   */
  MilesianString(String srcString) 
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


  static boolean isDigit(String digitCh) {
    return (MilesianString.digit.contains(digitCh))
  }

  

}