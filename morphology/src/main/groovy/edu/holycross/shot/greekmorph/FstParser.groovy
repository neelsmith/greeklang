package edu.holycross.shot.greekmorph


/**
* Class wrapping a SFST.
*/
class FstParser {

  Integer debug = 1

  String FSTINFL = "/usr/bin/fst-infl"
  String ECHO = "/bin/echo"
  String SH = "/bin/sh"

  /** Path to binary transducer. */
  String fstParser

  /** Constructor.
  * @param parserPath Full path to compiled SFST parser (.a file).
  */
  FstParser(String parserPath) {
    fstParser = parserPath
  }


  /** Parses fstStr with the SFST parser.
  * @param fstStr A single token in the format required for this project.
  * @returns A list of zero or more morphological analysis objects.
  */
  String parseToken(FstToken fstToken) {
    return parseTokenStr(fstToken.getFstStr().toString())
  }

  /** Parses fstStr with the SFST parser.
  * @param fstStr A single token in the format required for this project.
  * @returns Raw string output of fst-infl.
  */
  String parseTokenStr(String fstStr) {
    def out = new StringBuffer()
    def err = new StringBuffer()

    String protectedStr  = fstStr.replaceFirst(/[)]/, '\\\\)')
    protectedStr = protectedStr.replaceFirst(/[(]/, '\\\\(')
    // RIGHT HERE: NEED TO PROTECT ) or (
    def procList = [SH, "-c",  "${ECHO} ${protectedStr} | ${FSTINFL} ${fstParser}"]
    if (debug > 0) {System.err.println "FstParser: " + procList}
    def proc = procList.execute()
    proc.consumeProcessOutput(out, err)
    proc.waitFor()
    return out.toString()
  }

  /** Parses a list of tokens, one per line, with the SFST parser.
  * @param tokenList A list of tokens, one per line, in the format required for this project.
  * @returns A map of zero or more morphological analysis objects for each token.
  */
  LinkedHashMap parseTokens(String tokenList) {
    //   Fasterr to submit whole string list to fst-infl, and
    // parse out results?
    ArrayList tokens = []
    tokenList.eachLine {
      tokens.add(it)
    }
    return parseTokens(tokens)
  }


  /** Parses A list of tokens, one per line, with the SFST parser.
  * @param tokenList A list of tokens in the format required for this project.
  * @returns A map of zero or more morphological analysis objects for each token.
  */
  LinkedHashMap parseTokens(ArrayList tokenList) {
    LinkedHashMap analyses = [:]
    tokenList.each { t ->
      analyses[t]lk = parseToken(t)
    }
  }

}
