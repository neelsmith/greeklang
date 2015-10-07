package edu.holycross.shot.greekmorph

public enum GrammaticalCase {

  NOMINATIVE ("nominative", "<nom>"),
  GENITIVE("genitive", "<gen>"),
  DATIVE("dative", "<dat>"),
  ACCUSATIVE("accusative", "<acc>"),
  VOCATIVE("vocative", "<voc>")

  private String fstToken
  private String label

  private GrammaticalCase(String label, String token) {
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
