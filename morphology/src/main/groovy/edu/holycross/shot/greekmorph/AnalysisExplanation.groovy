package edu.holycross.shot.greekmorph

import edu.harvard.chs.cite.CiteUrn

class AnalysisExplanation {

  CiteUrn stem
  CiteUrn inflection

  AnalysisExplanation(CiteUrn stem, CiteUrn inflectionalPattern) {
    this.stem = stem
    this.inflection = inflectionalPatterns
  }
}
