package edu.holycross.shot.greekmorph

public enum Gender {

  MASCULINE ("masculine", "<masc>"),
  FEMININE("feminine", "<fem>"),
  NEUTER("neuter", "<neut>")

  private String fstToken
  private String label
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

  private Gender(String label, String token) {
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
