package edu.holycross.shot.greekmorph



/**
 * A class identifying a morphological form.
 */
class AdjectiveForm {

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


  String toString() {
    def labels = [gender.getLabel(), cas.getLabel(), num.getLabel(), degree.getLabel()]
    return labels.join(" ")
  }

}
