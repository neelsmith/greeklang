package edu.holycross.shot.hexameter


/**
*/
public enum FootMeter {

  /** Masculine gender. */
  DACTYL ("dactyl", "-^^"),
  /** Feminine gender. */
  SPONDEE("spondee", "--"),
  /** Neuter gender. */
  ANCEPS("anceps", "-x")

  private String stringified
  private String label


  /** Map of symbols used in FST to enumerated value. */
  static final Map codeMap

  static {
    codeMap = [:] as TreeMap
    values().each{ ftType ->
      codeMap.put(ftType.stringified, ftType)
    }
  }



  private FootMeter(String label, String strToken) {
    this.stringified = strToken
    this.label = label
  }
  /** Gets the enumerated value identified
  * by a FST token.
  * @param fstToken FST string for an
  * enumerated value.
  * @returns The enumerated value.
  */
  static getByToken(String strToken) {
    return codeMap[strToken]
  }


  /** Gets the symbol for this value used in FST string. */
  public String getToken() {
    return strToken
  }

  /** Gets a human-readable label for this value. */
  public String getLabel() {
    return label
  }
}
