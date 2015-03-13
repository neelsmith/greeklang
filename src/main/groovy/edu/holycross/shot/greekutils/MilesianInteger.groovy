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


  /** Ordered list of Unicode code points
   * in the source string. */
  ArrayList codePoints = []


  /** Decimal codepoint for space */
  static int space  = 32
  
  /** Decimal codepoint for comma */
  static int comma  = 44

  /** Decimal codepoint for upper-case mu */
  static int myriad = 924
  
  /** Constructor */
  MilesianInteger(MilesianString milStr)
  throws Exception {
    StringBuffer sb = new StringBuffer(milStr.toString())
    int max = sb.codePointCount(0, sb.length() - 1)
    int idx = 0
    int codePoint = sb.codePointAt(idx)
    while (idx <= max) {
      codePoint = sb.codePointAt(idx)
      if (codePoint == space) {
	// ignore
      } else if (MilesianString.isDigit(codePoint) || (codePoint == comma ))  {
	codePoints.add(codePoint)
      } else {
	throw new Exception("MilesianInteger: ${codePoint} is not a valid codepoint for a MilesianInteger.")
      }
      idx = sb.offsetByCodePoints(idx,1)
    }
    System.err.println "Initialized to code points " + codePoints
  }

  
  /** Converts value of source string to
   * Integer for values in range 1..19,999 .
   */
  Integer toInteger() {
    Integer total = -1
    boolean inThousands = codePoints.contains(comma)
    codePoints.each { cp ->
System.err.println "examine cp ${cp} w total " + total
      switch (cp) {
      case myriad:
      total = 10000;
      break
      
      case comma:
      inThousands = false
      break

      default:
      Integer cpValue = MilesianInteger.getDigitValue(cp)
      if (inThousands) {
	// ERROR IF cpValue > 9 !
	
	cpValue = cpValue *1000
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
    case 991:
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