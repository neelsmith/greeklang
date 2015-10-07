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

  public String getToken() {
    return fstToken
  }

  public String getLabel() {
    return label
  }
}
