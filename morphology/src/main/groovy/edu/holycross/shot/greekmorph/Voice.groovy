package edu.holycross.shot.greekmorph

public enum Voice {

  ACTIVE ("active", "<act>"),
  MIDDLE("middle", "<mid>"),
  PASSIVE("passive", "<pass>")

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
  private Voice(String label, String token) {
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
