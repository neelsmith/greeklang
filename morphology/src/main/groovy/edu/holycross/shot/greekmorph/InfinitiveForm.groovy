package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn


/**
 * A class identifying a morphological form.
 */
class InfinitiveForm implements CitableForm {


  static String urnBase = "urn:cite:morph:form.if"

  Tense tense
  Voice voice



  InfinitiveForm(Tense t, Voice v) {
    tense = t
    voice = v
  }

  CiteUrn getUrn() {
    String urnStr = urnBase + tense.ordinal() + voice.ordinal()
    return new CiteUrn(urnStr)
  }

  String toString() {
    def labels = [tense.getLabel(), voice.getLabel()]
    return labels.join(" ")
  }

}
