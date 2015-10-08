package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying a morphological form.
 */
class NounForm implements CitableForm {


  static String urnBase = "urn:cite:morph:form.no"
  Gender gender
  GrammaticalCase cas
  GrammaticalNumber num


  NounForm(Gender g, GrammaticalCase c, GrammaticalNumber n) {
    gender = g
    cas = c
    num = n

  }

  CiteUrn getUrn() {
    String urnStr = urnBase + gender.ordinal() + cas.ordinal() + num.ordinal()
    return new CiteUrn(urnStr)
  }

  String toString() {
    def labels = [gender.getLabel(), cas.getLabel(), num.getLabel()]
    return labels.join(" ")
  }

}
