package edu.holycross.shot.greekmorph


/**
* Class wrapping a SFST.
*/
class FstParser {

  String FSTINFL = "/usr/bin/fst-infl"
  String parser
  /** Constructor.
  * @param parserPath Full path to compiled SFST parser (.a file).
  */
  FstParser(String parserPath) {
    parser = parserPath
  }

  /** Parses fstStr with the SFST parser.
  * @param fstStr A single token in the format required for this project.
  * @returns A list of zero or more morphological analysis objects.
  */
  ArrayList parseToken(String fstStr) {
    def analyses = []
    // 1. run fstStr through FSTINFL
    // 2. parse the results and construct appropriate analysis objects

    return analyses
  }

  /** Parses A list of tokens, one per line, with the SFST parser.
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
