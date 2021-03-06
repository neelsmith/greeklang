package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekOrthography
//import edu.holycross.shot.orthography.GreekString
import edu.unc.epidoc.transcoder.TransCoder

/**
* Class for string tokens meeting FST requirements.
*/
class FstToken {

  /** An epidoc trancoder. */
  TransCoder utf2beta = new TransCoder()

  /** A string in Greek orthography to analyze. */
  GreekOrthography greekStr


  /** An ASCII string in the format processed by the
  * morphological parser's FST. */
  String fstStr

  /** Constructor accepts a GreekString, and derives an ASCII
  * string for analysis by the morphological FST.  Accents are
  * stripped out; breathing and vowel quantity characters are converted to FST
  * multicharacter symbols.
  * @param s A GreekString to analyze.
  */
  FstToken(GreekOrthography s) {
    greekStr = s
    // strip out accents
    String convertedStr = greekStr.toString().replaceAll(/[=\\/\\\\]/,"")
    // replace direct call to Epidoc with GreekOrthography
    // method accepting potentially bad input!

    /*
    utf2beta.setParser("Unicode")
    utf2beta.setConverter("BetaCode")
     utf2beta.getString(greekStr.toString(true)).replaceAll(/[=\\/\\\\]/,"")//.toLowerCase()
*/
    // replace quantity and breathing markers with FST tokens:
    convertedStr = convertedStr.replaceAll(/\^/, "<sh>")
    convertedStr = convertedStr.replaceAll("_", "<lo>")
    convertedStr = convertedStr.replaceAll(/\(/, "<ro>")
    convertedStr = convertedStr.replaceAll(/\|/, "<isub>")
    fstStr = convertedStr.replaceAll(/\)/, "<sm>")
  }

  /** Formats token for intelligible reading.
  * @returns String juxtaposing unicode form of GreekString
  * with ASCII token in FST format.
  */
  String toString() {
    return "${greekStr.toString(true)}-${fstStr}"
  }

}
