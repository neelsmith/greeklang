package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying the morphological form of a pronoun.
 */
class PronounForm implements CitableId {


  /** Adjectives are identified by predictable URNs in the
  * urn:cite:gmorph:form collection.  The object ID is formed
  * from the string "aj" concatenated with digits for each of
  * the adjectival identifiers gender, case, number and degee.
  */
  static String urnBase = "urn:cite:gmorph:form.pn"



  /** Gender of the form. */
  Gender gender
  /** Case of the form. */
  GrammaticalCase cas
  /** Number of the form. */
  GrammaticalNumber num
  /** */
  PersistentAccent persistentAccent

  /** Constructor with full morphological identificaion of an adjective.
  * @param g Gender of the form.
  * @param c Case of the form.
  * @param n Number of the form.
  * @param d Degree of the form.
  */
  PronounForm(Gender g, GrammaticalCase c, GrammaticalNumber n, PersistentAccent a ) {
    gender = g
    cas = c
    num = n
    persistentAccent = a
  }

  /** Gets a CITE URN corresponding to this identification.
  * @returns CiteUrn for this identification.
  */
  CiteUrn getUrn() {
    String urnStr = urnBase + gender.ordinal() + cas.ordinal() + num.ordinal()
    return new CiteUrn(urnStr)
  }

  /** Formats a label for the form.
  * @returns A human-readable label for this form.
  */
  String toString() {
    def labels = [gender.getLabel(), cas.getLabel(), num.getLabel()]
    return labels.join(" ")
  }

}
