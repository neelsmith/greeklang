package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/** Interface for a CitableId.
*/
public interface CitableId {

  /** Gets a CITE URN corresponding to the identification.
  * @returns CiteUrn for the identification.
  */
  CiteUrn getUrn()
}
