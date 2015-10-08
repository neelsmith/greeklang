package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn


/**
 * A class identifying a morphological form.
 */
class MorphForm {

  AnalyticalType analyticalType
  CitableForm analysis


  MorphForm(AnalyticalType analyticalType, CitableForm analysis) {
    this.analyticalType = analyticalType
    this.analysis = analysis
  }

  /** Computes the CiteUrn for a given form.
  */
  CiteUrn urnForForm() {
    analysis.getUrn()
  }

  CiteUrn getLexicalEntity() {
    
  }

  /** Formats human-readable analysis.
  * @returns Human-readable analysis.
  */
  String toString() {
    return analyticalType.toString() + ": " + analysis.toString()
  }
}
