package edu.holycross.shot.greekmorph



/**
 * A class identifying a morphological form.
 */
class VerbalAdjectiveForm {

  Gender gender
  GrammaticalCase cas
  GrammaticalNumber num


  VerbalAdjectiveForm(Gender g, GrammaticalCase c, GrammaticalNumber n) {
    gender = g
    cas = c
    num = n

  }


  String toString() {
    def labels = [gender.getLabel(), cas.getLabel(), num.getLabel()]
    return labels.join(" ")
  }

}
