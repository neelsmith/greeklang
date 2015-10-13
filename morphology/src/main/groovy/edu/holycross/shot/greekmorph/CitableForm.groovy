package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/** Interface for a CitableForm.
*/
public interface CitableForm {

  /** Gets a CITE URN corresponding to the identification.
  * @returns CiteUrn for the identification.
  */
  CiteUrn getUrn()
}
