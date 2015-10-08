package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn


/**
 * A class identifying a morphological form.
 */
class InfinitiveForm implements CitableForm {

  Tense tense
  Voice voice



  InfinitiveForm(Tense t, Voice v) {
    tense = t
    voice = v
  }

  CiteUrn getUrn() {
    System.err.println "getUrn() method not yet implemented"
    return null
  }
  
  String toString() {
    def labels = [tense.getLabel(), voice.getLabel()]
    return labels.join(" ")
  }

}
