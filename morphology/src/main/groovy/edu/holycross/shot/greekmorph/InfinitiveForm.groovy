package edu.holycross.shot.greekmorph



/**
 * A class identifying a morphological form.
 */
class InfinitiveForm {

  Tense tense
  Voice voice



  InfinitiveForm(Tense t, Voice v) {
    tense = t
    voice = v
  }


  String toString() {
    def labels = [tense.getLabel(), voice.getLabel()]
    return labels.join(" ")
  }

}
