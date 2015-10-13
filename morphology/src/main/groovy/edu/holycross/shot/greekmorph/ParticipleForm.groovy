package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying the morphological form of a participle.
 */
class ParticipleForm implements CitableForm {

  /** Participles are identified by predictable URNs in the
  * urn:cite:morph:form collection.  The object ID is formed
  * from the string "pc" concatenated with digits for each of
  * the adjectival identifiers tense, voice, gender, case, and number.
  */
  static String urnBase = "urn:cite:morph:form.pc"

  /** Tense of the form. */
  Tense tense
  /** Voice of the form. */
  Voice voice
  /** Gender of the form. */
  Gender gender
  /** Case of the form. */
  GrammaticalCase cas
  /** Number of the form. */
  GrammaticalNumber num



  /** Constructor with full morphological identificaion of a participle.
  * @param t Tense of the form.
  * @param v Voice of the form.
  * @param g Gender of the form.
  * @param c Case of the form.
  * @param n Number of the form.
  */
  ParticipleForm(Tense t, Voice v, Gender g, GrammaticalCase c, GrammaticalNumber n) {
    tense = t
    voice = v
    gender = g
    cas = c
    num = n
  }

  /** Gets a CITE URN corresponding to this identification.
  * @returns CiteUrn for this identification.
  */
  CiteUrn getUrn() {
    String urnStr = urnBase + tense.ordinal() + voice.ordinal() + gender.ordinal() + cas.ordinal() + num.ordinal()
    return new CiteUrn(urnStr)
  }

  /** Formats a label for the form.
  * @returns A human-readable label for this form.
  */
  String toString() {
    def labels = [tense.getLabel(), voice.getLabel(), gender.getLabel(), cas.getLabel(), num.getLabel()]
    return labels.join(" ")
  }

}
