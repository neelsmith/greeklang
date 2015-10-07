package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString

/**
 * A class representing morphological analysis of a single token.
 */
class MorphologicalAnalysis {

  /** The analyzed string */
  GreekString str

  /** (Possibly empty) list of analyses, as MorphForm objects. */
  ArrayList analyses = []

  MorphologicalAnalysis(GreekString s, ArrayList analyses) {
    str = s
    this.analyses = analyses
  }

}
