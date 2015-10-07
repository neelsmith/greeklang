package edu.holycross.shot.greekmorph



/**
 * A class identifying a morphological form.
 */
class MorphForm {

  AnalyticalType analyticalType
  Object analysis


  MorphForm(AnalyticalType analyticalType, Object analysis) {
    this.analyticalType = analyticalType
    // should really check that type and object are in sync...
    switch (analysis.class) {
      case edu.holycross.shot.greekmorph.VerbForm:
      case edu.holycross.shot.greekmorph.ParticipleForm:
      case edu.holycross.shot.greekmorph.InfinitiveForm:
      case edu.holycross.shot.greekmorph.VerbalAdjectiveForm:
      case edu.holycross.shot.greekmorph.NounForm:
      case edu.holycross.shot.greekmorph.AdjectiveForm:
      case edu.holycross.shot.greekmorph.AdverbForm:
      this.analysis = analysis
      break

      default:
      throw new Exception("MorphForm: unrecognized class ${analysis.class}")
      break
    }
  }


}
