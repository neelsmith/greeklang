package edu.holycross.shot.greekutils

import edu.unc.epidoc.transcoder.TransCoder
import java.text.Normalizer
import java.text.Normalizer.Form

/**
 * A class for working with numeric data in the Milesian notational system.
 */
class MilesianString {



   Integer debug = 0
   
  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0


  /** Immutable set of consonant characters. */

  
  static digit = [
    924, //	(39c)	Μ (upper case)
    927, //	(39f)	Ο (upper case)
    945, //	(3b1)	α
    946, //	(3b2)	β
    947, //	(3b3)	γ
    948, //	(3b4)	δ
    949, //	(3b5)	ε
    950, //	(3b6)	ζ
    951, //	(3b7)	η
    952, //	(3b8)	θ
    953, //	(3b9)	ι
    954, //	(3ba)	κ
    955, //	(3bb)	λ
    956, //	(3bc)	μ
    957, //	(3bd)	ν
    958, //	(3be)	ξ
    959, //	(3bf)	ο
    960, //	(3c0)	π
    961, //	(3c1)	ρ
    963, //	(3c3)	σ
    964, //	(3c4)	τ
    965, //	(3c5)	υ
    966, //	(3c6)	φ
    967, //	(3c7)	χ
    968, //	(3c8)	ψ
    969, //	(3c9)	ω
    987, //	(3db)	ϛ
    990, //	(3de)	Ϟ (upper case) ??
    993 //	(3e1)	ϡ
  ]

  
  static punct = [
    ',', "'", '"'
  ]


  static fract = [
    65909, //	(10175)	𐅵
    65911 //	(10177)	𐅷
  ]

  
  /** The string in beta code form.*/
  String milesianString

  /** Constructor verifies that srcString, supplied in an identified
   * system for encoding Greek, contains only valid characters
   * for a MilesianString's underlying representation.
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
  boolean isValidCP(int codePt) {
    if (digit.contains(codePt) || punct.contains(codePt) || fract.contains(codePt)) {
      return true
    } else {
      return false
    }
  }


  int getFollowingCP(int i, StringBuffer buff) {
    int nextIdx = buff.offsetByCodePoints(i,1)	
    int cp = buff.codePointAt(nextIdx)
    return(cp)
  }

  
  MilesianString(String srcString)
  throws Exception {
    StringBuffer sb = new StringBuffer(srcString)
    int max = sb.codePointCount(0, sb.length() - 1)
    int idx = 0
    int codePoint = sb.codePointAt(idx)
    while (idx < max) {
      codePoint = sb.codePointAt(idx)
      if (! isValidCP(codePoint)) {
	throw new Exception("MilesianString: invalid char at code point " + codePoint)
      }
      idx = sb.offsetByCodePoints(idx,1)
    }
    this.milesianString = srcString
  }
  

  /** Peeks ahead in a StringBuffer to find next code 
   * point after i.
   * @param buff StringBuffer to peek into.
   * @param i Index to start looking from.
   * @returns The next code point in buff, or null if 
   * none found.
   */
  int getFollowingCodePoint(StringBuffer buff, int i)
  throws Exception {
     int max = buff.codePointCount(0, buff.length() - 1)
     int nextIdx = buff.offsetByCodePoints(i,1)
     if (debug > 1) {
       System.err.println ("Check for fnext cp at idx " + nextIdx + " compared to " + max)
     }
     if (nextIdx <= max) {
       int cp = buff.codePointAt(nextIdx)
       return(cp)
     } else {
       throw new Exception("MilesianString: code point beyond maximum count.")
     }
   }

   
   /** Determines if a String is contained in the list of
    * valid MilesianString digits.
    * @param digitCh A single Unicode character to test.
    * @returns True if digitCh is in the list of 
    * valid digit characters.
    */
   static boolean isDigit(String digitCh) {
     StringBuffer buff = new StringBuffer(digitCh)
     int codePt = buff.codePointAt(0)
     return (MilesianString.digit.contains(codePt))
   }



   /** Overrides default toString method.
    * @returns String representation of MilesianString.
    */
   String toString() {
     return this.milesianString
   }


   /** Overrides default toString method, with
    * option to choose format of String.  If asBeta
    * is true, uses ASCII-only representation; otherwise,
    * uses representation from polytonic Greek section of 
    * Unicode.
    * @param asBeta True if String should be ASCII only.
    * @returns String representation of MilesianString.
    */
   String toString(boolean asBeta) {
     if (asBeta) {
       TransCoder xcoder = new TransCoder()
       xcoder.setParser("Unicode")
       xcoder.setConverter("BetaCode")
       return xcoder.getString(this.milesianString)
     } else {
       return this.milesianString
     }
   }
  

}