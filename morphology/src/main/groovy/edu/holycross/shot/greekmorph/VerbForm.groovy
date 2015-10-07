package edu.holycross.shot.greekmorph



/**
 * A class identifying a morphological form.
 */
class VerbForm {

  Person person
  GrammaticalNumber num
  Tense tense
  Mood mood
  Voice voice

  VerbForm(Person p, GrammaticalNumber n, Tense t, Mood m, Voice v) {
    person = p
    num = n
    tense = t
    mood = m
    voice = v
  }

  /** Constructor building object from formatted string code.
  * @param analysisCode
  * @throws Exception if analysisCode is not valid.
  */
  VerbForm(String analysisCode)
  throws Exception {

  }

  String toString() {
    def labels = [person.getLabel(), num.getLabel(), tense.getLabel(), mood.getLabel(), voice.getLabel()]
    return labels.join(" ")
  }

}
