package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying a morphological form.
 */
class AdverbForm implements CitableForm {


  static String urnBase = "urn:cite:morph:form.av"
  Degree degree


  AdverbForm(Degree d) {
    degree = d
  }

  CiteUrn getUrn() {
    String urnStr = urnBase + degree.ordinal()
    return new CiteUrn(urnStr)
  }

  String toString() {
    return degree.getLabel()
  }

}
