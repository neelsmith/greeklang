package edu.holycross.shot.greekutils

import edu.unc.epidoc.transcoder.TransCoder
import java.text.Normalizer
import java.text.Normalizer.Form

/**
 * A class for working with numeric data in the Milesian notational system.
 */
class MilesianInteger {

  public Integer debug = 5
  
  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0


  /** Ordered list of Unicode code points
   * in the source string. */
  public ArrayList codePoints = []


  /** Value of the MilesianInteger as an Integer */
  Integer integerValue

  /** Decimal codepoint for upper-case mu */
  static int myriad = 924


  /** Constructor building MilesianInteger directly from String representation.
   * @param str String representation of a MilesianInteger.
   * @throws Exception if str is not valid .
   */
  MilesianInteger(String str)
  throws Exception {
    int max = str.codePointCount(0, str.length())
    int idx = 0
    int codePoint = str.codePointAt(idx)
    int count = 0
    while (count < max) {
      codePoint = str.codePointAt(idx)
      if ((codePoint == MilesianString.space) || (codePoint == MilesianString.singleq)) {
	// ignore
	  
      } else if (MilesianString.isDigit(codePoint) || (codePoint == MilesianString.comma ) )  {
	codePoints.add(codePoint)
      } else {
	throw new Exception("MilesianInteger: ${codePoint} is not a valid codepoint for a MilesianInteger.")
      }
      idx = str.offsetByCodePoints(idx,1)
      count++
    }
    if (debug > 0) { System.err.println "Initialized to code points " + codePoints

    }

    // validate by converting to integer:
    try {
      this.integerValue = MilesianInteger.toInteger(codePoints)
      if (debug > 0) { System.err.println "Integer value " + this.integerValue }
    } catch (Exception e) {
      System.err.println("MilesianInteger: exception forming integer from code points ${codePoints}")
      throw e
    }
    
  }

  
  /** Constructor building from a MilesianString. */
  MilesianInteger(MilesianString milStr)
  throws Exception {
    StringBuffer sb = new StringBuffer(milStr.toString())
    int max = sb.codePointCount(0, sb.length() - 1)
    int idx = 0
    int codePoint = sb.codePointAt(idx)
    while (idx <= max) {
      codePoint = sb.codePointAt(idx)
      if (codePoint == MilesianString.space) {
	// ignore
      } else if (MilesianString.isDigit(codePoint) || (codePoint == MilesianString.comma ))  {
	codePoints.add(codePoint)
      } else {
	throw new Exception("MilesianInteger: ${codePoint} is not a valid codepoint for a MilesianInteger.")
      }
      idx = sb.offsetByCodePoints(idx,1)
    }
    if (debug > 0)  {System.err.println "Initialized to code points " + codePoints}
    // validate by converting to integer:
    try {
      this.integerValue = MilesianInteger.toInteger(codePoints)
    } catch (Exception e) {
      throw e
    }

  }

  
  /** Converts value of an ArrayList of codepoints to
   * an Integer for values in range 1..19,999 .
   */
  static Integer toInteger(ArrayList cpList)
  throws Exception {
    Integer debug = 5
    if (debug > 0) {
      System.err.println "Converting cpList ${cpList} to integer"
    }
    def columns = ["myriad": false,"thousands": false,"hundreds": false ,"tens": false, "ones": false]
    
    Integer total = -1
    boolean inThousands = cpList.contains(MilesianString.comma)
    
    cpList.each { cp ->
      if (debug > 0) { System.err.println "examine cp ${cp} w total " + total + ", in thousands? " + inThousands} 

      switch (cp) {
	
      case myriad:
      total = 10000;
      if (columns["myriad"] || columns["thousands"] || columns["hundreds"] || columns["tens"] || columns["ones"]) {
	throw new Exception("MilesianInteger: invalid syntax")
      }
      columns["myriad"] = true
      break
      
      case MilesianString.comma:
      inThousands = false
      break

      default:
      Integer cpValue = MilesianInteger.getDigitValue(cp)
      if (debug > 0) { System.err.println "Value for digit is ${cpValue}"}
      if (inThousands) {
	// ERROR IF cpValue > 9 !
	if (cpValue > 9) {
	  throw new Exception("MilesianInteger: bad syntax, digit for value ${cpValue} not allowed here")
	}
	cpValue = cpValue *1000
	if (columns["thousands"] || columns["hundreds"] || columns["tens"] || columns["ones"]) {
	  throw new Exception("MilesianInteger: invalid syntax")
	}
	columns["thousands"] = true
      } else {
	if (debug > 0) {System.println "Checking below thousand with value ${cpValue}"}
	if (cpValue > 99) {
	  if (debug > 0) {
	    System.err.println "cpValue > 0, so test expr: "
	    System.err.println "true? " +   (columns["hundreds"] || columns["tens"] || columns["ones"]) 
	}
	  if (columns["hundreds"] || columns["tens"] || columns["ones"]) {
	    if (debug > 0) { System.err.println "Throw an EXCEPTION!"}
	    throw new Exception("MilesianInteger: invalid syntax")
	  }
	  columns["hundreds"] = true
	
	} else if (cpValue > 9) {
	  if (columns["tens"] || columns["ones"]) {
	    throw new Exception("MilesianInteger: invalid syntax")
	  }
	  columns["tens"] = true

	} else if (cpValue > 0) {
	  if (debug > 0) {
	    System.err.println "cpValue > 0"
	  }
	  if (columns["ones"]) {
	    throw new Exception("MilesianInteger: invalid syntax")
	  }
	  columns["ones"] = true
	}
      }
      if (total == -1) {
	total = cpValue
      } else {
	total =  total + cpValue
      }
      break
      }
    }
      
    if (total == -1) {
      throw new Exception("MilesianString: not a valid integer value.")
    } else {
      return total
    }
  }
    

  /** Determines Integer value for a single
   * digit character identified by Unicode
   * codepoint number in decimal numbers.
   * @param digit Codepoint of the character to 
   * look at.
   * @returns Integer value of this character in
   * the Milesian notation.
   * @throws Exception if digit is not the
   * codepoint for a valid MilesianInteger digit. 
   */
  static Integer getDigitValue(int digit)
  throws Exception {
    switch (digit) {
    case 924:
    return 10000
    break
    
    case 927:
    return 0
    break
    
    case 945:
    return 1
    break
    
    case 946:
    return 2
    break
    
    case 947:
    return 3
    break
    
    case 948:
    return 4
    break
    
    case 949:
    return 5
    break
    
    case 950:
    return 7
    break
    case 951:
    return 8
    break
    
    case 952:
    return 9
    break
    
    case 953:
    return 10
    break
    
    case 954:
    return 20
    break
    
    case 955:
    return 30
    break
    
    case 956:
    return 40
    break
    
    case 957:
    return 50
    break
    
    case 958:
    return 60
    break
    
    case 959:
    return 70
    break
    
    case 960:
    return 80
    break
    
    case 961:
    return 100
    break
    
    case 963:
    return 200
    break
    
    case 964:
    return 300
    break
    
    case 965:
    return 400
    break
    
    case 966:
    return 500
    break
    
    case 967:
    return 600
    break
    
    case 968:
    return 700
    break
    
    case 969:
    return 800
    break

    // 3db
    case 987: 
    return 6
    break


    // 3de
    case 985:
    return 90
    break

    // 3e1
    case 993:
    return 900
    break

    default:
    throw new Exception("MilesianInteger: ${digit} is not a valid codepoint.")
    break
    
    }
  }

}