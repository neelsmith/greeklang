package edu.holycross.shot.greekmorph

public enum AccentTag {

  RECESSIVE ("recessive accent or persistent accent on antepenult", "<antacc>"),
  PENULT("persistent accent on penult", "<penacc>"),
  UTLIMA("persistent accent on ultima", "<ultacc>")

  private String fstToken
  private String label
  static final Map codeMap

  static {
    codeMap = [:] as TreeMap
    values().each{ atype ->
      codeMap.put(atype.fstToken, atype)
    }
  }
  private AccentTag(String label, String token) {
    this.fstToken = token
    this.label = label
  }

  public String getToken() {
    return fstToken
  }


  public String getLabel() {
    return label
  }
}
