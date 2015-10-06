package edu.holycross.shot.greekmorph

// import edu.unc.epidoc.transcoder.TransCoder

/**
* Class for string tokens meeting FST requirements.
*/
class FstToken {

  //TransCoder utf2beta = new TransCoder()

  // Use a GreekString for input?
  String utf8Str
  String fstStr

  /** Constructor. */
  FstToken(String s) {
    /*
    utf2beta.setParser("Unicode")
    utf2beta.setConverter("BetaCode")
    */
    // fstStr utf2beta.getString(s).replaceAll(/[=\\/\\\\]/,"").toLowerCase()
  }

}
