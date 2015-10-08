package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString

/**
 * A class representing morphological analysis of a single token.
 */
class MorphologicalAnalysis {

  /** The analyzed string */
  GreekString str



  /** (Possibly empty) ordered list of analyses, as MorphForm objects. */
  ArrayList analyses = []

  /** (Possibly empty) ordered list of explanations, as AnalysisExplanation objects. */
  ArrayList explanations = []

  MorphologicalAnalysis(GreekString s, ArrayList analyses, ArrayList explanations) {
    str = s
    this.analyses = analyses
    this.explanations = explanations
  }

}
