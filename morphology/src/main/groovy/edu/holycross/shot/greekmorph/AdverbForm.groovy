package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying a morphological form.
 */
class AdverbForm implements CitableForm {

  Degree degree


  AdverbForm(Degree d) {
    degree = d
  }

  CiteUrn getUrn() {
    System.err.println "getUrn() method not yet implemented"
    return null
  }

  String toString() {
    return degree.getLabel()
  }

}
