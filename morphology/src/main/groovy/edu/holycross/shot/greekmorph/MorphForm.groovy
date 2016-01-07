package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn


/**
 * A class identifying a morphological form.
 */
class MorphForm {

  /** The analytical pattern that applies to this analysis. */
  AnalyticalType analyticalType

  /** The type-specific analysis. */
  CitableId analysis

  /** Constructor verifies that analysis data are appropriate for
  * the specified type of analysis.
  * @param analyticalType The type of this analysis.
  * @param analysis The analysis data.
  * @throws Exception if analysisType is not consistent with the class of analysis.
  */
  MorphForm(AnalyticalType analyticalType, CitableId analysis)
  throws Exception {
    switch(analyticalType) {
      case AnalyticalType.CVERB:
        if (analysis instanceof VerbForm) {
        } else {
          throw new Exception("MorphForm: ${analyticalType} not consistent with analysis of class VerbForm")
        }
      break
      case AnalyticalType.PARTICIPLE:
        if (analysis instanceof ParticipleForm) {
        } else {
          throw new Exception("MorphForm: ${analyticalType} not consistent with analysis of class ParticipleForm")
        }
      break
      case AnalyticalType.INFINITIVE:
        if (analysis instanceof InfinitiveForm) {
        } else {
          throw new Exception("MorphForm: ${analyticalType} not consistent with analysis of class InfinitiveForm")
        }
      break
      case AnalyticalType.VERBAL_ADJECTIVE:
        if (analysis instanceof VerbalAdjectiveForm) {
        } else {
          throw new Exception("MorphForm: ${analyticalType} not consistent with analysis of class VerbalAdjectiveForm")
        }
      break
      case AnalyticalType.NOUN:
        if (analysis instanceof NounForm) {
        } else {
          throw new Exception("MorphForm: ${analyticalType} not consistent with analysis of class NounForm")
        }
      break
      case AnalyticalType.ADJECTIVE:
        if (analysis instanceof AdjectiveForm) {
        } else {
          throw new Exception("MorphForm: ${analyticalType} not consistent with analysis of class AdjectiveForm")
        }
      break
      case AnalyticalType.ADVERB:
        if (analysis instanceof AdverbForm) {
        } else {
          throw new Exception("MorphForm: ${analyticalType} not consistent with analysis of class AdverbForm")
        }
      break
      case AnalyticalType.INDECLINABLE:
        if (analysis instanceof IndeclinableForm) {
        } else {
          throw new Exception("MorphForm: ${analyticalType} not consistent with analysis of class IndeclinableForm")
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
