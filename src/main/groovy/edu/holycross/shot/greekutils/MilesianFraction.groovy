package edu.holycross.shot.greekutils

import edu.unc.epidoc.transcoder.TransCoder
import java.text.Normalizer
import java.text.Normalizer.Form

/**
 * A class for working with numeric data in the Milesian notational system.
 */
class MilesianFraction {

  Integer debug = 5

  
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


  BigDecimal fractionValue



  
  /** Constructor verifies that srcString, supplied in an identified
   * system for encoding Greek, contains only valid characters
   * for a MilesianString's underlying beta-code representation.
   */
/*  MilesianFraction(String srcString, String greekMapping)  {
    // to be added...
    }*/



  BigDecimal getFractionValue() {
    return getFractionValue(3)  
  }
  
  BigDecimal getFractionValue(Integer places) {
    Integer placeFactor =  10**places
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
      // convert abbrs to convetional unit fraction form:
      int cp = srcString.codePointAt(0)
      if (debug > 0 )  { System.err.println "Check initialize code point ${cp}"}

      
      switch (cp) {
      case 65909:
      if (debug > 0) { System.err.println "Initial char is 1/2"}
      
      initializeString = "β "
      transcription = "1/2"
      fractionValue = 1 / 2
      break
      
      case 65911:
      initializeString = "β ϛ "
      transcription = "1/2 + 1/6"
      fractionValue = (1/2)  + (1/6)
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
      if (debug > 0) { System.err.println "MilesianFraction: checking unit " + unit}
      unit = unit.replaceAll(/"/, '')
      
      MilesianInteger mInt = new MilesianInteger(unit)
      if (transcription == "") {
	transcription = "1/${mInt.integerValue}"
	fractionValue = 1 / mInt.integerValue
	
      } else {
	transcription = transcription + " + 1/${mInt.integerValue}"
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

    }
  }




}