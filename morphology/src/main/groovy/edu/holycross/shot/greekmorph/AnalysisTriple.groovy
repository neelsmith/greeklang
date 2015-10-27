package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString
import edu.harvard.chs.cite.CiteUrn

class AnalysisTriple {
  MorphForm morphForm
  AnalysisExplanation analysisExplanation
  CiteUrn lexicalEntity

  AnalysisTriple(CiteUrn lexEnt, MorphForm form, AnalysisExplanation explanation) {
    lexicalEntity = lexEnt
    morphForm = form
    analysisExplanation = explanation
  }

}
