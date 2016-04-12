package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying a morphological form.
 */
class VerbalAdjectiveForm implements CitableId {

  /** Verbal adjectives are identified by predictable URNs in the
  * urn:cite:gmorph:form collection.  The object ID is formed
  * from the string "va" concatenated with digits for each of
  * the adjectival identifiers gender, case, and number.
  */
  static String baseUrn = "urn:cite:gmorph:form.va"

  /** Gender of the form. */
  Gender gender
  /** Case of the form. */
  GrammaticalCase cas
  /** Number of the form. */
  GrammaticalNumber num

  /** Constructor with full morphological identificaion of a
  * verbal adjective.
  * @param g Gender of the form.
  * @param c Case of the form.
  * @param n Number of the form.
  */
  VerbalAdjectiveForm(Gender g, GrammaticalCase c, GrammaticalNumber n) {
    gender = g
    cas = c
    num = n
  }


  VerbalAdjectiveForm(def parts) {
    gender = Gender.getByLabel(parts[0])
    cas = GrammaticalCase.getByLabel(parts[1])
    num = GrammaticalNumber.getByLabel(parts[2])
  }

  /** Gets a CITE URN corresponding to this identification.
  * @returns CiteUrn for this identification.
  */
  CiteUrn getUrn() {
    String urnStr = baseUrn + gender.ordinal() + cas.ordinal() + num.ordinal()
    return new CiteUrn(urnStr)
  }

  /** Formats a label for the form.
  * @returns A human-readable label for this form.
  */
  String toString() {
    def labels = [gender.getLabel(), cas.getLabel(), num.getLabel()]
    return labels.join(" ")
  }

  boolean equals(VerbalAdjectiveForm form2) {
    return ((this.gender == form2.gender ) && (this.cas == form2.cas) && (this.num == form2.num))
  }
}
