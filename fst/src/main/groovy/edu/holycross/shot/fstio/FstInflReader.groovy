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

  /** Parses output of fst-infl from a File source. For each token, fst-infl
   * outputs a line beginning "> ".  Subsequent lines contain either
   * an analysis or begin with the string "no result".  This method identifies
   * a token, collects following analyses in a List, and when a new token is
   * seen, maps the previously seen token to the previously collected list.
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
	if (currentToken != "") {
	  analyses[currentToken] = currentAnalyses
	  // .clear() won't work!  Need a new ArrayList()
	  //currentAnalyses.clear()
	  currentAnalyses = new ArrayList()
	}
	currentToken = ln.replaceFirst(/> /, "")

      } else if (ln ==~ /no result.+/) {
	// failed to analyze token
      } else {
	currentAnalyses.add(ln)
      }
    }
    return analyses
  }
}
