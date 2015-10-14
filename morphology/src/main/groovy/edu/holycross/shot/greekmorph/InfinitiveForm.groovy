package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn


/**
 * A class identifying the morphological form of a verb
 * in the infintive.
 */
class InfinitiveForm implements CitableForm {

  /** Infinitive verb forms are identified by predictable URNs in the
  * urn:cite:gmorph:form collection.  The object ID is formed
  * from the string "if" concatenated with digits for each of
  * the identifiers tense and voice.
  */
  static String urnBase = "urn:cite:gmorph:form.if"

  /** Tense of the form. */
  Tense tense
  /** Voice of the form. */
  Voice voice


  /** Constructor with full morphological identificaion of an adjective.
  * @param t Tense of the form.
  * @param v Voice of the form.
  */
  InfinitiveForm(Tense t, Voice v) {
    tense = t
    voice = v
  }

  /** Gets a CITE URN corresponding to this identification.
  * @returns CiteUrn for this identification.
  */
  CiteUrn getUrn() {
    String urnStr = urnBase + tense.ordinal() + voice.ordinal()
    return new CiteUrn(urnStr)
  }

  /** Formats a label for the form.
  * @returns A human-readable label for this form.
  */
  String toString() {
    def labels = [tense.getLabel(), voice.getLabel()]
    return labels.join(" ")
  }

}
