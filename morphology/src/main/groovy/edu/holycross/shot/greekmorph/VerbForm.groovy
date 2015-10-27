package edu.holycross.shot.greekmorph


import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying a morphological form.
 */
class VerbForm implements CitableId {

  /** Adjectives are identified by predictable URNs in the
  * urn:cite:gmorph:form collection.  The object ID is formed
  * from the string "aj" concatenated with digits for each of
  * the adjectival identifiers gender, case, number and degee.
  */
  static String baseUrn = "urn:cite:gmorph:form.cv"

  /** Person of the form. */
  Person person
  /** Number of the form. */
  GrammaticalNumber num
  /** Tense of the form. */
  Tense tense
  /** Mood of the form. */
  Mood mood
  /** Voice of the form. */
  Voice voice


  /** Constructor with full morphological identificaion of a
  * conjugated verb.
  * @param p Person of the form.
  * @param n Number of the form.
  * @param t Tense of the form.
  * @param m Mood of the form.
  * @param n Voice of the form.
  */
  VerbForm(Person p, GrammaticalNumber n, Tense t, Mood m, Voice v) {
    person = p
    num = n
    tense = t
    mood = m
    voice = v
  }

  /** Gets a CITE URN corresponding to this identification.
  * @returns CiteUrn for this identification.
  */
  CiteUrn getUrn() {
    String urnStr = baseUrn + person.ordinal() + num.ordinal() + tense.ordinal() + mood.ordinal() + voice.ordinal()
    return new CiteUrn(urnStr)
  }

  /** Formats a label for the form.
  * @returns A human-readable label for this form.
  */
  String toString() {
    def labels = [person.getLabel(), num.getLabel(), tense.getLabel(), mood.getLabel(), voice.getLabel()]
    return labels.join(" ")
  }

}
