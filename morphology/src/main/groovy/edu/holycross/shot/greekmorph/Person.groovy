package edu.holycross.shot.greekmorph

public enum Person {

  FIRST("first person", "<1st>"),
  SECOND("second person", "<2nd>"),
  THIRD("third person", "<3rd>")

  private String fstToken
  private String label

  private Person(String label, String token) {
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
