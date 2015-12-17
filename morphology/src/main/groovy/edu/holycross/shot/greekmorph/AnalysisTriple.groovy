package edu.holycross.shot.greekmorph


import edu.harvard.chs.cite.CiteUrn

class AnalysisTriple {
  CiteUrn lexicalEntity
  MorphForm morphForm
  AnalysisExplanation analysisExplanation


  AnalysisTriple(CiteUrn lexEnt, MorphForm form, AnalysisExplanation explanation) {
    lexicalEntity = lexEnt
    morphForm = form
    analysisExplanation = explanation
  }


  String toString() {
    return "from ${lexicalEntity}, ${morphForm} (${analysisExplanation})"
  }

}
