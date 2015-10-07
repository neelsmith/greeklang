package edu.holycross.shot.greekmorph

public enum AnalyticalType {

  CVERB ("conjugated verb", "<verb>"),
  PARTICIPLE ("participle", "<ptcpl>"),
  ININITIVE ("infinitive", "<infin>"),
  VERBAL_ADJECTIVE ("verbal adjective", "<vadj>"),
  NOUN("noun", "<noun>"),
  ADJECTIVE("adjective", "<adj>"),
  ADVERB("adverb", "<adv>"),
  INDECLINABLE("indeclinable form", "<indecl>"),


  private String fstToken
  private String label

  private AnalyticalType(String label, String token) {
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
