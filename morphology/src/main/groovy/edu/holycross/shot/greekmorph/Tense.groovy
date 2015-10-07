package edu.holycross.shot.greekmorph

public enum Tense {

  PRESENT("present", "<pres>"),
  IMPERFECT("imperfect", "<impft>"),
  FUTURE("future", "<fut>"),
  AORIST("aorist", "<aor>"),
  PERFECT("perfect", "<pft>"),
  PLUPERFECT("pluperfect", "<plupft>")

  private String fstToken
  private String label

  private Tense(String label, String token) {
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
