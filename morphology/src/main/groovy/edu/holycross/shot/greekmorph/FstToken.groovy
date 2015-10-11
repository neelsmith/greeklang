package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString
import edu.unc.epidoc.transcoder.TransCoder

/**
* Class for string tokens meeting FST requirements.
*/
class FstToken {

  TransCoder utf2beta = new TransCoder()


  GreekString utf8Str
  GreekString fstStr

  /** Constructor accepts a Unicode GreekString, and converts to an ASCII
  * Greek string with accents stripped out, for analysis by the
  * morphological FST.
  * @param s A GreekString in Unicode format.
  */
  FstToken(GreekString s) {
    utf8Str = s
    utf2beta.setParser("Unicode")
    utf2beta.setConverter("BetaCode")
    fstStr = new GreekString(utf2beta.getString(s.toString(true)).replaceAll(/[=\\/\\\\]/,"").toLowerCase())
  }

  String toString() {
    return "${utf8Str}-${fstStr}"
  }

}
