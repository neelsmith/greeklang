package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying a morphological form.
 */
class VerbalAdjectiveForm implements CitableForm {

  Gender gender
  GrammaticalCase cas
  GrammaticalNumber num


  VerbalAdjectiveForm(Gender g, GrammaticalCase c, GrammaticalNumber n) {
    gender = g
    cas = c
    num = n

  }

  CiteUrn getUrn() {
    System.err.println "getUrn() method not yet implemented"
    return null
  }

  String toString() {
    def labels = [gender.getLabel(), cas.getLabel(), num.getLabel()]
    return labels.join(" ")
  }

}
