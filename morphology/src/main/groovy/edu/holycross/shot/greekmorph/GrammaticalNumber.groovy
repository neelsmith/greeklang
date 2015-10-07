package edu.holycross.shot.greekmorph

public enum GrammaticalNumber {

  SINGULAR("singular", "<sg>"),
  DUAL("dual", "<dual>"),
  PLURAL("plural", "<pl>")

  private String fstToken
  private String label

  private GrammaticalNumber(String label, String token) {
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
