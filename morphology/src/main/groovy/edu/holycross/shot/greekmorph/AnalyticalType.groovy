package edu.holycross.shot.greekmorph

/** A class enumerating the analytical patterns that
* can be applied to Greek strings. Enumerated values may be
* expressed with human-readable labels, or in the multicharacter
* symbols used in the morphological parser's FST engine.
*/
public enum AnalyticalType {

  /** Conjugated verb analyzed with PNTMV */
  CVERB ("conjugated verb", "<verb>"),
  /** Participle analyzed with TVGCN */
  PARTICIPLE ("participle", "<ptcpl>"),
  /** Infinitie form of verb analyzed with TV */
  INFINITIVE ("infinitive", "<infin>"),
  /** Verbal adjective analyzed with GCN */
  VERBAL_ADJECTIVE ("verbal adjective", "<vadj>"),
  /** Noun analyzed with GCN */
  NOUN("noun", "<noun>"),
  /** Adjective analyzed with GCND */
  ADJECTIVE("adjective", "<adj>"),
  /** Adverb analyzed with D */
  ADVERB("adverb", "<adv>"),
  /** Indeclinable form */
  INDECLINABLE("indeclinable form", "<indecl>")


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
  private AnalyticalType(String label, String token) {
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

  /** Gets a human-readable label for this value. */
  public String toString() {
    return label
  }

}
