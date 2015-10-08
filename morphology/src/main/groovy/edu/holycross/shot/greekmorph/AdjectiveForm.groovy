package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying a morphological form.
 */
class AdjectiveForm implements CitableForm {


  static String urnBase = "urn:cite:morph:form.aj"

  Gender gender
  GrammaticalCase cas
  GrammaticalNumber num
  Degree degree


  AdjectiveForm(Gender g, GrammaticalCase c, GrammaticalNumber n, Degree d) {
    gender = g
    cas = c
    num = n
    degree = d

  }

  CiteUrn getUrn() {
    String urnStr = urnBase + gender.ordinal() + cas.ordinal() + num.ordinal() + degree.ordinal()
    return new CiteUrn(urnStr)
  }

  String toString() {
    def labels = [gender.getLabel(), cas.getLabel(), num.getLabel(), degree.getLabel()]
    return labels.join(" ")
  }

}
