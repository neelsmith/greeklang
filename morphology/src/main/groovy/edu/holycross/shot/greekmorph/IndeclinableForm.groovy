package edu.holycross.shot.greekmorph


import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying a morphological form.
 */
class IndeclinableForm implements CitableId {
  static CiteUrn indeclinableUrn = new CiteUrn("urn:cite:gmorph:form.indeclinable")

  IndeclinableForm(){}

  CiteUrn getUrn() {
    return indeclinableUrn
  }
  String toString() {
    return ("indeclinable")
  }
}
