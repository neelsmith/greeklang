package edu.holycross.shot.greekmorph

/** A class enumerating the degree quality of adjectives
* and adverbs.  Enumerated values may be expressed with human-readable
* labels, or in the multicharacter symbols used in the
* morphological parser's FST engine.
*/
public enum Degree {

  /** Positive degree. */
  POSITIVE ("positive", "<pos>"),
  /** Comparative degree. */
  COMPARATIVE("comparative", "<comp>"),
  /** Superlative degree. */
  SUPERLATIVE("superlative", "<superl>")

  private String fstToken
  private String label

  /** Map of symbols used in FST to enumerated value. */
  static final Map codeMap

  static {
    codeMap = [:] as TreeMap
    values().each{ atype ->
      codeMap.put(atype.fstToken, atype)
    }
  }


  private Degree(String label, String token) {
    this.fstToken = token
    this.label = label
  }


  /** Gets the enumerated value identified
  * by a FST token.
  * @param fstToken FST string for an
  * enumerated value.
  * @returns The enumerated value.
  */
  static getByToken(String fstToken) {
    return codeMap[fstToken]
  }

  /** Gets the symbol for this value used in FST string. */
  public String getToken() {
    return fstToken
  }

  /** Gets a human-readable label for this value. */
  public String getLabel() {
    return label
  }
}
