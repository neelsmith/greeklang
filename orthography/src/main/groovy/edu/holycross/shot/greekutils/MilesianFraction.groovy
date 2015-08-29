package edu.holycross.shot.greekutils

import edu.unc.epidoc.transcoder.TransCoder
import java.text.Normalizer
import java.text.Normalizer.Form

/**
 * A class for working with numeric data in the Milesian notational system.
 */
class MilesianFraction {

  Integer debug = 0

  
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


  /** Ordered list of individual unit fractions
   * expressed as integers giving the denominator.
   */
  ArrayList unitFracts = []
  
  /** The string in beta code form.*/
  String milesianString


  /** Transcription as an expression for sum of unit fractions in
   * Arabic numbers.   */
  public String transcription

  /** Decimal value of the fraction expression. */
  BigDecimal fractionValue

  
  /** Constructor verifies that srcString, supplied in an identified
   * system for encoding Greek, contains only valid characters
   * for a MilesianString's underlying beta-code representation.
   */
/*  MilesianFraction(String srcString, String greekMapping)  {
    // to be added...
    }*/

  String xscribe() {
    return this.transcription;
  }

  /** Formats decimal value of the fraction
   * to the default of 3 significant digits. 
   */
  BigDecimal getFractionValue()
  throws Exception {
    return getFractionValue(3)  
  }


  /** Formats decimal value of the fraction
   * to a specified number of significant places. 
   * @param places Number of places to round to.
   * @returns A BigDecimal rounded to places number
   * of digits.
   * @throws Exception of fractionValue is null
   */
  BigDecimal getFractionValue(Integer places)
  throws Exception {
    Integer placeFactor =  10**places
    if (fractionValue == null) {
      throw new Exception("MilesianFraction: cannot get null fractionValue")
    }
    return (Math.round(fractionValue * placeFactor) / placeFactor)
  }
  
  /** Constructor verifies that srcSring contains only valid characters
   * for beta-code representation.
   * @param srcString Greek string, in beta code.
   * @throws Exception if not all characters in betaString are valid.
   */
  MilesianFraction(String srcString) 
  throws Exception {
    this.transcription = ""
    // check for initialize abbr. char
    String initializeString
    if (srcString.codePointCount(0,srcString.length()) < srcString.length()) {
      // convert abbreviation chars to convetional unit fraction form:
      int cp = srcString.codePointAt(0)
      switch (cp) {
      case 65909:
      if (debug > 0) { System.err.println "Initial char is 1/2"}
      
      initializeString = "β "
      transcription = "1/2"
      fractionValue = 0 // 1 / 2
      break
      
      case 65911:
      initializeString = "β ϛ "
      transcription = "1/2 + 1/6"
      fractionValue = 0 // (1/2)  + (1/6)
      break

      default:
      // throw Exception
      break
      }
      
      // offset to second code point:
      int startIdx = srcString.offsetByCodePoints(0,1)
      initializeString = initializeString + srcString.subSequence(startIdx,srcString.length())
      
    } else {
      initializeString = srcString
    }
    

    this.unitFracts = initializeString.split(/[ ]+/)
    // throw out " marker
    Integer largestSoFar = 0
    // check syntax for order:
    unitFracts.each { unit ->

      unit = unit.replaceAll('"', '')
      
      if (debug > 0) { System.err.println "MilesianFraction: checking unit #" + unit + "#; try to make int"}
      if (unit.size() > 0) {
	MilesianInteger mInt = new MilesianInteger(unit)
	if (debug > 0) {
	  System.err.println "Made int with value " + mInt.integerValue
	  System.err.println ", curr transcriptoin is #"  + transcription + "# and xcr size is " + transcription.size()
	}

      
	if (transcription.size() == 0) {
	  if (debug > 0) {System.err.println "Int val is " + mInt.integerValue	}
	  transcription = "1/${mInt.integerValue}"
	  fractionValue = 1 / mInt.integerValue

	  if (debug > 0) {"Initializing fractionValue as ${ 1 / mInt.integerValue} to ${fractionValue}"}
	
	} else {
	  transcription = transcription + " + 1/${mInt.integerValue}"
	  if (debug > 0) {"Adding ${ 1 / mInt.integerValue} to ${fractionValue}"}
	  fractionValue += 1 / mInt.integerValue
	}

	if (largestSoFar == 0) {
	  largestSoFar = mInt.integerValue


	} else {
	  // denominators must increase:
	  if (mInt.integerValue <= largestSoFar) {
	    throw new Exception("MilesianFraction: syntax error in ${srcString}")
	  }
	}
      } // empty unit, e.g., " char that has been eliminated.

    }
  }




}