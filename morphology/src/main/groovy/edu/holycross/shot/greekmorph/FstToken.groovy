package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString
import edu.unc.epidoc.transcoder.TransCoder

/**
* Class for string tokens meeting FST requirements.
*/
class FstToken {

  TransCoder utf2beta = new TransCoder()

  // Use a GreekString for input?
  GreekString utf8Str
  GreekString fstStr

  /** Constructor. */
  FstToken(GreekString s) {
    utf8Str = s
    utf2beta.setParser("Unicode")
    utf2beta.setConverter("BetaCode")
    fstStr = new GreekString(utf2beta.getString(s.toString(true)).replaceAll(/[=\\/\\\\]/,"").toLowerCase())
  }

}
