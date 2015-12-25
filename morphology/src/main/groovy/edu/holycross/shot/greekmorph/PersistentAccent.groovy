package edu.holycross.shot.greekmorph

/** A class enumerating the grammatical number of substantives
* or verbs. Enumerated values may be expressed with human-readable
* labels, or in the multicharacter symbols used in the
* morphological parser's FST engine.
*/
public enum PersistentAccent {

  /** Singular */
  STEM_PENULT("accent persists on penult of stem", "<stempenacc>"),
  /** Plural */
  STEM_ULTIMA("accent persists on ultima of stem", "<stemultacc>"),
  /** Dual */
  INFLECTIONAL_ENDING("accent persists on inflectional ending", "<inflacc>")

  private String fstToken
  private String label
  private PersistentAccent(String label, String token) {
    this.fstToken = token
    this.label = label
  }

  /** Map of symbols used in FST to enumerated value. */
  static final Map codeMap
  static {
    codeMap = [:] as TreeMap
    values().each{ atype ->
      codeMap.put(atype.fstToken, atype)
    }
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
