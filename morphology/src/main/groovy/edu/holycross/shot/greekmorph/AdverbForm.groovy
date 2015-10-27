package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying the morphological form of an adverb.
 */
class AdverbForm implements CitableId {

  /** Adverbs are identified by predictable URNs in the
  * urn:cite:gmorph:form collection.  The object ID is formed
  * from the string "av" concatenated with a digit for
  * the identified degee.
  */
  static String urnBase = "urn:cite:gmorph:form.av"

  /** Degree of the adverb. */
  Degree degree

  /** Constructor with full morphological identificaion of an adverb.
  * @param d Degree of the form.
  */
  AdverbForm(Degree d) {
    degree = d
  }

  /** Gets a CITE URN corresponding to this identification.
  * @returns CiteUrn for this identification.
  */
  CiteUrn getUrn() {
    String urnStr = urnBase + degree.ordinal()
    return new CiteUrn(urnStr)
  }

  /** Formats a label for the form.
  * @returns A human-readable label for this form.
  */
  String toString() {
    return degree.getLabel()
  }

}
