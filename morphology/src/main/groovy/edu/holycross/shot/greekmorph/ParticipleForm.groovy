package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying the morphological form of a participle.
 */
class ParticipleForm implements CitableId {

  /** Participles are identified by predictable URNs in the
  * urn:cite:gmorph:form collection.  The object ID is formed
  * from the string "pc" concatenated with digits for each of
  * the adjectival identifiers tense, voice, gender, case, and number.
  */
  static String urnBase = "urn:cite:gmorph:form.pc"

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



  ParticipleForm(def  partsList) {
    if (partsList.size() != 5) {
      System.err.println "ParticipleForm: cannot construct from list of size ${partsList.size()}"
      System.err.println "List was: " + partsList
      throw new Exception("ParticipleForm: cannot construct from list of size ${partsList.size()}")

    }
    System.err.println "PF: List was: " + partsList

    tense = Tense.getByLabel(partsList[0])
    voice = Voice.getByLabel(partsList[1])
    gender = Gender.getByLabel(partsList[2])
    cas = GrammaticalCase.getByLabel(partsList[3])
    num = GrammaticalNumber.getByLabel(partsList[4])
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

  boolean equals(ParticipleForm form2) {
    return ((this.tense == form2.tense ) && (this.voice == form2.voice) && (this.gender == form2.gender) && (this.cas == form2.cas) && (this.num == form2.num) )
  }

}
