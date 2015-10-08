package edu.holycross.shot.greekmorph

public enum Degree {

  POSITIVE ("positive", "<pos>"),
  COMPARATIVE("comparative", "<comp>"),
  SUPERLATIVE("superlative", "<superl>")

  private String fstToken
  private String label

  private Degree(String label, String token) {
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
