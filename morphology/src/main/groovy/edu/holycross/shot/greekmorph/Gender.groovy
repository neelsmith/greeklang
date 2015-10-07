package edu.holycross.shot.greekmorph

public enum Gender {

  MASCULINE ("masculine", "<masc>"),
  FEMININE("feminine", "<fem>"),
  NEUTER("neuter", "<neut>")

  private String fstToken
  private String label

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
