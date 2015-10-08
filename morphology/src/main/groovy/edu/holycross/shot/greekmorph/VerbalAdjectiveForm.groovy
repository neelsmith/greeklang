package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying a morphological form.
 */
class VerbalAdjectiveForm implements CitableForm {

  static String baseUrn = "urn:cite:morph:form.va"
  Gender gender
  GrammaticalCase cas
  GrammaticalNumber num


  VerbalAdjectiveForm(Gender g, GrammaticalCase c, GrammaticalNumber n) {
    gender = g
    cas = c
    num = n

  }

  CiteUrn getUrn() {
    String urnStr = baseUrn + gender.ordinal() + cas.ordinal() + num.ordinal()
    return new CiteUrn(urnStr)
  }

  String toString() {
    def labels = [gender.getLabel(), cas.getLabel(), num.getLabel()]
    return labels.join(" ")
  }

}
