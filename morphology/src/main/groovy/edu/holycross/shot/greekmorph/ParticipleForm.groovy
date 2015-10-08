package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying a morphological form.
 */
class ParticipleForm implements CitableForm {


  static String urnBase = "urn:cite:morph:form.pc"
  Tense tense
  Voice voice
  Gender gender
  GrammaticalCase cas
  GrammaticalNumber num

  ParticipleForm(Tense t, Voice v, Gender g, GrammaticalCase c, GrammaticalNumber n) {
    tense = t
    voice = v
    gender = g
    cas = c
    num = n
  }

  CiteUrn getUrn() {
    String urnStr = urnBase + tense.ordinal() + voice.ordinal() + gender.ordinal() + cas.ordinal() + num.ordinal()
    return new CiteUrn(urnStr)
  }

  String toString() {
    def labels = [tense.getLabel(), voice.getLabel(), gender.getLabel(), cas.getLabel(), num.getLabel()]
    return labels.join(" ")
  }

}
