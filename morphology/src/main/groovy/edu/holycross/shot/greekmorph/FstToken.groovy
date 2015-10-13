package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString
import edu.unc.epidoc.transcoder.TransCoder

/**
* Class for string tokens meeting FST requirements.
*/
class FstToken {

  /** An epidoc trancoder. */
  TransCoder utf2beta = new TransCoder()

  /** A GreekString to analyze. */
  GreekString greekStr
  /** An ASCII string in the format processed by the
  * morphological parser's FST. */
  String fstStr

  /** Constructor accepts a GreekString, and derives an ASCII
  * string for analysis by the morphological FST.  Accents are
  * stripped out, and some characters are converted to FST
  * multicharacter symbols.
  * @param s A GreekString to analyze.
  */
  FstToken(GreekString s) {
    greekStr = s
    utf2beta.setParser("Unicode")
    utf2beta.setConverter("BetaCode")
    fstStr = utf2beta.getString(greekStr.toString(true)).replaceAll(/[=\\/\\\\]/,"").toLowerCase()
    // CONVERT:
    // breathings () to <ro><sm>
    // quantity ^_ to <sh><lo>
  }

  /** Formats token for intelligible reading.
  * @returns String juxtaposing unicode form of GreekString
  * with ASCII token in FST format.
  */
  String toString() {
    return "${greekStr.toString(true)}-${fstStr}"
  }

}
