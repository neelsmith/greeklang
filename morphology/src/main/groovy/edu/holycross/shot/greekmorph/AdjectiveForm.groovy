package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying the morphological form of an adjective.
 */
class AdjectiveForm implements CitableId {


  /** Adjectives are identified by predictable URNs in the
  * urn:cite:gmorph:form collection.  The object ID is formed
  * from the string "aj" concatenated with digits for each of
  * the adjectival identifiers gender, case, number and degee.
  */
  static String urnBase = "urn:cite:gmorph:form.aj"



  /** Gender of the form. */
  Gender gender
  /** Case of the form. */
  GrammaticalCase cas
  /** Number of the form. */
  GrammaticalNumber num
  /** Degree of the form. */
  Degree degree
  /** */
  PersistentAccent persistentAccent

  /** Constructor with full morphological identificaion of an adjective.
  * @param g Gender of the form.
  * @param c Case of the form.
  * @param n Number of the form.
  * @param d Degree of the form.
  */
  AdjectiveForm(Gender g, GrammaticalCase c, GrammaticalNumber n, Degree d, PersistentAccent a ) {
    gender = g
    cas = c
    num = n
    degree = d
    persistentAccent = a
  }


//  [masculine, nominative, singular, positive, inflacc]
  AdjectiveForm(def parts ) {
    System.err.println "Construct AdjectiveForm with " + parts
    gender = Gender.getByLabel(parts[0])
    cas = GrammaticalCase.getByLabel(parts[1])
    num = GrammaticalNumber.getByLabel(parts[2])
    degree = Degree.getByLabel(parts[3])
    persistentAccent = PersistentAccent.getByToken("<" + parts[4] + ">")
  }

  /** Gets a CITE URN corresponding to this identification.
  * @returns CiteUrn for this identification.
  */
  CiteUrn getUrn() {
    String urnStr = urnBase + gender.ordinal() + cas.ordinal() + num.ordinal() + degree.ordinal()
    return new CiteUrn(urnStr)
  }

  /** Formats a label for the form.
  * @returns A human-readable label for this form.
  */
  String toString() {
    def labels = [gender.getLabel(), cas.getLabel(), num.getLabel(), degree.getLabel()]
    return labels.join(" ")
  }
  boolean equals(AdjectiveForm form2) {
    return ((this.gender == form2.gender ) && (this.num == form2.num) && (this.cas == form2.cas) && (this.degree == form2.degree) )
  }
}
