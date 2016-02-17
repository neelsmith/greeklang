package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekOrthography

/** Interface for a GreekParser.
*/
public interface GreekParser {

  /** Gets a morphological analysis for a GreekString.
  */
  MorphologicalAnalysis parseGreekString(GreekOrthography greekString)
}
