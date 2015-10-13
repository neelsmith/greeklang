package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString

/**
 * A class representing the morphological analysis of a single token.
 * Analyzing a GreekString object produces two ordered lists in a
 * one-to-one relation: a set of morphological forms, and a matching
 * set of explanations.
 */
class MorphologicalAnalysis {

  /** The analyzed string. */
  GreekString s

  /** A (possibly empty) ordered list of analyses, as MorphForm objects. */
  ArrayList analyses = []

  /** A (possibly empty) ordered list of explanations, as AnalysisExplanation objects. */
  ArrayList explanations = []


  /** Constructor with all required components.
  * @param s The analyzed string.
  * @param analyses The list of morphological forms resulting
  * from the anlysis.
  * @param explanations The list of explanations, one for each form in
  * the list of analyses.
  */
  MorphologicalAnalysis(GreekString s, ArrayList analyses, ArrayList explanations) {
    str = s
    this.analyses = analyses
    this.explanations = explanations
  }

}
