package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString
import edu.holycross.shot.orthography.GreekOrthography

/**
 * A class representing the morphological analysis of a single token.
 * Analyzing a GreekString object produces two ordered lists in a
 * one-to-one relation: a set of morphological forms, and a matching
 * set of explanations.
 */
class MorphologicalAnalysis {

  /** The analyzed string. */
  GreekOrthography greekString

  /** A (possibly empty) list of AnalysisTriple objects. */
  ArrayList analyses



  /** Constructor with all required components.
  * @param s The analyzed string.
  * @param analyses The list of morphological forms resulting
  * from the anlysis.
  * @param explanations The list of explanations, one for each form in
  * the list of analyses.
  */
  MorphologicalAnalysis(GreekOrthography s, ArrayList analyses) {
    this.greekString = s
    this.analyses = analyses
  }

}
