package edu.holycross.shot.greekmorph



/**
 * A class identifying a morphological form.
 */
class AdverbForm {

  Degree degree


  AdverbForm(Degree d) {
    degree = d
  }


  String toString() {
    return degree.getLabel()
  }

}
