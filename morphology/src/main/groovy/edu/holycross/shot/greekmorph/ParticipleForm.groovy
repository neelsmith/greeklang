package edu.holycross.shot.greekmorph



/**
 * A class identifying a morphological form.
 */
class ParticipleForm {

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

  String toString() {
    def labels = [tense.getLabel(), voice.getLabel(), gender.getLabel(), cas.getLabel(), num.getLabel()]
    return labels.join(" ")
  }

}
