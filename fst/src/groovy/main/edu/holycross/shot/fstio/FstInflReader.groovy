package edu.holycross.shot.fstio



import static org.junit.Assert.*
import org.junit.Test

/**
* Class for parsing output of SFST toolkit's fst-infl parser.
*/
class FstInflReader {

  ArrayList accentedForms = []
  ArrayList fstTokens = []

  /** Constructor. */
  FstInflReader() {}

  void readFstInflFile(File fstInflFile) {
    fstInlFile.eachLine { ln ->
      if (ln[0] == '>') {
          String tokenStr = ln.replaceFirst(/> /, "")
          fstTokens.add(tokenStr)
      }
    }
  }
}
