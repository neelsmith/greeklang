package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

/**
*/
class AnalysisExplanation {

  /** The morphological stem.*/
  CiteUrn stem
  /** The inflectional pattern.*/
  CiteUrn inflection

  /** Constructor requires URNs for morphological stem
  * and inflectional pattern.
  * @param stem The morphological stem.
  * @param inflectionalPattern The inflectional pattern.
  */
  AnalysisExplanation(CiteUrn stem, CiteUrn inflectionalPattern) {
    this.stem = stem
    this.inflection = inflectionalPattern
  }

  /** Overrides default implementation of toString.
  * @returns A human-readable listing of explanatory URNs.
  */
  String toString() {
    return "stem ${stem}, inflection ${inflection}"
  }
}
