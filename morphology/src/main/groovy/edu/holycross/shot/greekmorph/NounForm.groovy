package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying the morphological form of a noun.
 */
class NounForm implements CitableId {

  /** Nouns are identified by predictable URNs in the
  * urn:cite:gmorph:form collection.  The object ID is formed
  * from the string "no" concatenated with digits for each of
  * the nominal identifiers gender, case, and number.
  */
  static String urnBase = "urn:cite:gmorph:form.no"


  /** Gender of the form. */
  Gender gender
  /** Case of the form. */
  GrammaticalCase cas
  /** Number of the form. */
  GrammaticalNumber num
  /** */
  PersistentAccent persistentAccent


  /** Constructor with full morphological identificaion of a noun.
  * @param g Gender of the form.
  * @param c Case of the form.
  * @param n Number of the form.
  */
  NounForm(Gender g, GrammaticalCase c, GrammaticalNumber n, PersistentAccent pa) {
    gender = g
    cas = c
    num = n
    persistentAccent = pa

  }



  NounForm(def parts) {
    System.err.println "Construct NounForm with " + parts
    gender = Gender.getByLabel(parts[0])
    cas = GrammaticalCase.getByLabel(parts[1])
    num = GrammaticalNumber.getByLabel(parts[2])
    persistentAccent = PersistentAccent.getByToken("<" + parts[3] + ">")

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
