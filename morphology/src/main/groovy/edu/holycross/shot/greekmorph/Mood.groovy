package edu.holycross.shot.greekmorph

public enum Mood {

  INDICATIVE("indicative", "<indic>"),
  SUBJUNCTIVE("subjunctive", "<subj>"),
  OPTATIVE("optative", "<opt>"),
  IMPERATIVE("imperative", "<imptv>")

  private String fstToken
  private String label

  private Mood(String label, String token) {
    this.fstToken = token
    this.label = label
  }
  static final Map codeMap

  static {
    codeMap = [:] as TreeMap
    values().each{ atype ->
      codeMap.put(atype.fstToken, atype)
    }
  }

  static getByToken(String fstToken) {
    return codeMap[fstToken]
  }

  public String getToken() {
    return fstToken
  }

  public String getLabel() {
    return label
  }
}
