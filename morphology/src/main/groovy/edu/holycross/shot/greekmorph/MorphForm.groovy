package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn


/**
 * A class identifying a morphological form.
 */
class MorphForm {

  AnalyticalType analyticalType
  CitableForm analysis

  /** Constructor verifies that analysis data are appropriate for type of analysis.
  * @param analyticalType The type of this analysis.
  * @param analysis The analysis data.
  * @throws Exception if analysisType is not consistent with the class of analysis.
  */
  MorphForm(AnalyticalType analyticalType, CitableForm analysis)
  throws Exception {
    switch(analyticalType) {
      // other AnalyticalType values to check:
      /*
      PARTICIPLE
      ININITIVE
      VERBAL_ADJECTIVE
      NOUN
      ADJECTIVE
      ADVERB
      INDECLINABLE
      */

      case AnalyticalType.CVERB:
        if (analysis instanceof VerbForm) {
        } else {
          throw new Exception("MorphForm: ${analyticalType} not consistent with analysis of class VerbForm")
        }
      break

      default:
      break
    }

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
