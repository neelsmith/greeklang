package edu.holycross.shot.fstio

/**
* Class for parsing output of SFST toolkit's fst-infl parser.
*/
class FstInflReader {

  ArrayList accentedForms = []
  ArrayList fstTokens = []

  LinkedHashMap analyses = [:]

  /** Constructor. */
  FstInflReader() {
    // do nothing
  }

  /** Parses output of fst-infl from a File source.
  * @param fstInflFile File with output from fst-infl.
  * @returns A map of analyses keyed by tokens.  Each entry
  * contains a (possibly empty) ArrayList.
  */
  LinkedHashMap readFstInflFile(File fstInflFile) {
    LinkedHashMap analyses = [:]
    ArrayList currentAnalyses = []
    String currentToken = ""
    fstInflFile.eachLine { ln ->
      if (ln[0] == '>') {
          if (currentAnalyses.size() > 0) {
            analyses[currentToken] = currentAnalyses
            currentAnalyses.clear()
          }
          currentToken = ln.replaceFirst(/> /, "")
          //currentAnalyses[currentToken] = [null]

        } else if (ln ==~ /no result.+/) {
          // failure
        } else {
          currentAnalyses.add(ln)
        }
    }
    return analyses
  }
}
