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


  /** Immutable set of digit characters, identified
   * by decimal code point in Unicode character set. 
   */
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
    991, //	(3de)	
    993 //	(3e1)	ϡ
  ]



  // **** Other code points *** //

  /** Single quote character. */
  static int singleq = 39
  /** Double quote character. */
  static int doubleq = 34
  /** Space character. */
  static int space = 32
  /** Comma. */
  static int comma = 44


  /** Immutable set of valid puncutation characters. */
  static punct = [
    space,
    comma,
    singleq,
    doubleq
  ]


  // **** Special abbreviated fraction characters  *** //

  /** Abbreviation for one half.*/
  static int onehalf = 65909 //	(U 10175)	𐅵
  
  /** Abbreviation for two thirds.*/
  static twothirds = 65911 //	(10177)	𐅷

  /** Immutable set of valid abbreviations for fractions. */
  static fract = [
    onehalf,
    twothirds
  ]

  
  
  /** The string in unicode form.*/
  String milesianString

  /** Number of Unicode code points in milesianString. */
  int cpMax
  

  /** Determines if milesianString has a fraction component.
   * @returns True if the number includes a fractional component.
   */
  boolean hasFraction() {
    boolean fractionSeen = false
    
    int idx = 0
    int codePoint = milesianString.codePointAt(idx)
    int count = 0
    while (count < cpMax) {
      codePoint = sb.codePointAt(idx)
      if (codePoint == doubleq) {
	fractionSeen = true
      }
      idx = milesianString.offsetByCodePoints(idx, 1)
      count++
    }
    return fractionSeen
  }


  /** Determines if milesianString has an integer component.
   * @returns True if the number includes an integer component.
   */
  boolean hasIntegerPart() {
    boolean fractionSeen = false
    boolean singleQSeen = false
    int idx = 0
    int codePoint = milesianString.codePointAt(idx)
    int count = 0
    while (count < cpMax) {
      codePoint = milesianString.codePointAt(idx)
      if (codePoint == MilesianString.doubleq) {
	fractionSeen = true
	
      } else if (codePoint == MilesianString.singleq) {
	singleQSeen = true
	
      }
      idx = milesianString.offsetByCodePoints(idx, 1)
      count++
    }

    if ((singleQSeen) || (fractionSeen == false)) {
      return true
    } else {

      
      return false
    }
  }




  String getFractionPart() {

    int substrIdx = -1
    int idx = 0
    int codePoint = milesianString.codePointAt(idx)
    int count = 0
    if (debug > 0) {
      System.err.println "getFractionPart: analyse " + cpMax + " code points."
    }
    while (count < (cpMax)) {
      if (debug > 0) { System.err.println "getFractionPart: get cp at " + idx + " for count " + count }
      codePoint = milesianString.codePointAt(idx)
      if (debug > 0) { System.err.println "getFractionPart: codepoint " + codePoint + " at idx " + idx + " w max " + cpMax }
      if (codePoint == MilesianString.singleq) {
	if (debug > 0) { System.err.println "\tfound s quote, so make substr idx " + idx}
	substrIdx = idx + 1
      }

      if (codePoint == MilesianString.doubleq) {
	if (substrIdx == - 1) {
	  substrIdx = 0
	}
      }
      
      if (debug >  0) { System.err.print "\tadvance idx to "}
      idx = milesianString.offsetByCodePoints(idx,1)
      if (debug > 0)  { System.err.println idx}
      count++
    }
    if (substrIdx == -1) {
      if (debug > 0) { System.err.println "NO fraction part."}
      throw new Exception("MilesianString: no fraction part")
    } else {
      if (debug  > 0) { System.err.println "getFrationPart: returning " + milesianString.substring(substrIdx, milesianString.length() )}
      return (milesianString.substring(substrIdx, milesianString.length() ))
    }
  }

  
  /** Extracts integer component from a MilesianString
   */
  String getIntegerPart() {
    int substrIdx = milesianString.offsetByCodePoints(milesianString.length() - 1, 1)
    if (debug > 0) {System.err.println "getIntegerPat: initial substridx is " + substrIdx}
    int idx = 0
    int codePoint = milesianString.codePointAt(idx)
    int count = 0
    while (count < cpMax) {
      codePoint = milesianString.codePointAt(idx)
      if (debug > 0) { System.err.println "Codepoint " + codePoint + " at idx " + idx + " w max " + cpMax}
      if (codePoint == MilesianString.singleq) {
	if (debug > 0) { System.err.println "\tfound s quote, so make substr idx " + idx }
	substrIdx = idx + 1
      }
      idx = milesianString.offsetByCodePoints(idx,1)
      count++
    }

    if (debug > 0) { System.err.println "getIntegerPart: get subsr from 0 to  " + substrIdx}
    return (milesianString.substring(0, substrIdx))
  }

  

  /** Determines if codePt is a valid code point
   * for a MilesianString.
   * @parm codePt The code point to examine.
   * @returns True if codePt is a valid code point.
   */
  static boolean isValidCP(int codePt) {
    if (digit.contains(codePt) || punct.contains(codePt) || fract.contains(codePt)) {
      return true
    } else {
      return false
    }
  }
  
  /** Constructor creating a MilesianString from a String value.
   * @param srcString String representation of a MilesianString.
   * @throws Exception if srcString is not valid.
   */
  MilesianString(String srcString)
  throws Exception {
    this.milesianString = srcString
    cpMax = milesianString.codePointCount(0, milesianString.length())
    if (debug > 0) {
      System.err.println "Consructor: ${cpMax} code points for " + milesianString
    }
    MilesianInteger mInt = null
    MilesianFraction mFract = null
    try {
      mInt = new MilesianInteger(this.getIntegerPart())
    } catch (Exception e) {
      //throw e
      System.err.println "NO INTEGER"
      mInt = null
    }

    try {
      mFract = new MilesianFraction(this.getFractionPart())
    } catch (Exception e) {
      mFract = null
    }

    if ((mInt == null) && (mFract == null)) {
      System.err.println "MilesianString: could not find a valid integer or fraction component in " + srcString
      throw new Exception ("MilesianString: could not find a valid integer or fraction component in ${srcString}")
    } else {
    System.err.println "NO PROBLEM"
    }
  }


  /** Constructor verifies that srcString, supplied in an identified
   * system for encoding Greek, contains only valid characters
   * for a MilesianString's underlying representation.
   */
  MilesianString(String srcString, String greekMapping)  {
    // to be added ...
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


  /** Determines if a code point represents a character
   * in the list of valid MilesianString digits.
   * @param codePt Code point to examine.
   * @returns True if codePt is in the list of 
   * valid code points.
   */
  static boolean isDigit(int codePt) {
     return (MilesianString.digit.contains(codePt))
  }



  /** Determines if a code point represents a character
   * in the list of valid MilesianString digits.
   * @param codePt Code point to examine.
   * @returns True if codePt is in the list of 
   * valid code points.
   */
  static boolean isDigit(Integer codePt) {
    return (MilesianString.digit.contains(codePt as int))
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