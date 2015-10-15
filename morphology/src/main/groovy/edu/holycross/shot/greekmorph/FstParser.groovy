package edu.holycross.shot.greekmorph


/**
* Class wrapping a SFST.
*/
class FstParser {

  Integer debug = 0

  /** Path to FST toolkit's fst-infl parser. */
  String FSTINFL = "/usr/bin/fst-infl"
  /** Path to echo. */
  String ECHO = "/bin/echo"
  /** Path to sh. */
  String SH = "/bin/sh"

  /** Path to binary transducer. */
  String fstParser

  /** Constructor.
  * @param parserPath Full path to compiled SFST parser (.a file).
  */
  FstParser(String parserPath) {
    fstParser = parserPath
  }


  /** Parses a token with the SFST parser.
  * @param fstStr A single token.
  * @returns A list of zero or more morphological analysis objects.
  */
  String parseToken(FstToken fstToken) {
    return parseTokenStr(fstToken.getFstStr().toString())
  }

  /** Parses a literal string with the SFST parser.
  * @param fstStr A String in the format required
  * to form a FstToken.
  * @returns Raw string output of fst-infl.
  */
  String parseTokenStr(String fstStr) {
    def out = new StringBuffer()
    def err = new StringBuffer()

    // Protect angle brackets in FST multicharacter symbols
    // before submitting to sh:
    String protectedStr  = fstStr.replaceFirst(/[>]/, '\\\\>')
    protectedStr = protectedStr.replaceFirst(/[<]/, '\\\\<')
    def procList = [SH, "-c",  "${ECHO} ${protectedStr} | ${FSTINFL} ${fstParser}"]
    if (debug > 0) {System.err.println "FstParser: " + procList}
    def proc = procList.execute()
    proc.consumeProcessOutput(out, err)
    proc.waitFor()
    return out.toString()
  }

  /** Parses a list of tokens, one per line, with the SFST parser.
  * @param tokenList A list of strings, one per line, in the format required
  * to form a FstToken.
  * @returns A map of zero or more morphological analysis objects for each token.
  */
  LinkedHashMap parseTokens(String tokenList) {
    // Certainly would be faster to submit whole string list to fst-infl,
    // and then parse out results.
    ArrayList tokens = []
    tokenList.eachLine {
      tokens.add(it)
    }
    return parseTokens(tokens)
  }


  /** Parses A list of tokens, one per line, with the SFST parser.
  * @param tokenList A list of tokens in the format required
  * to form a FstToken.
  * @returns A map of zero or more morphological analysis objects for each token.
  */
  LinkedHashMap parseTokens(ArrayList tokenList) {
    LinkedHashMap analyses = [:]
    tokenList.each { t ->
      analyses[t]lk = parseToken(t)
    }
  }

}
