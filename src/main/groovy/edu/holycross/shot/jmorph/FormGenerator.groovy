package edu.holycross.shot.jmorph

import edu.harvard.chs.cite.CiteUrn

/**
 * A class identifying a morphological form.
 */
class FormGenerator {

  Integer debug = 0

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0


  MorphSql db

  FormGenerator(MorphSql sqlDb) {
    db = sqlDb
  }


  /** Generates a specified form of a specified lexical entity.
   * @param lexEnt The lexical entity in question.
   * @param requestedForm The form to generate.
   * @returns An ArrayList of appropriate surface strings for the specified lexical
   * entity in the specified form.
   */
  ArrayList generate(CiteUrn lexEnt, MorphForm requestedForm) {
    ArrayList candidatesList = db.endingsForLexEnt(lexEnt)
    ArrayList usableList = []
    candidatesList.each {  candidate ->
      ArrayList candidateFormFilter = candidate[1].split(/:/)
      if (FormFilter.formMatches(requestedForm.toArrayOfString(), candidateFormFilter)) {
	usableList.add(candidate)
      }
    }
    def validForms = []
    usableList.each { rec ->
      // PROCESS HERE... FEED OFF BY PoS to appropriate method
      String raw =  rec[4] + rec[0]
      validForms.add(raw)
    }

    return validForms
  }




  ArrayList generate(CiteUrn lexEnt, MorphForm requestedForm, String tag) {
    ArrayList candidatesList = db.endingsForLexEnt(lexEnt, tag)
    ArrayList usableList = []
    candidatesList.each {  candidate ->
      ArrayList candidateFormFilter = candidate[1].split(/:/)
      if (FormFilter.formMatches(requestedForm.toArrayOfString(), candidateFormFilter)) {
	usableList.add(candidate)
      }
    }
    def validForms = []
    usableList.each { rec ->
      // PROCESS HERE... FEED OFF BY PoS to appropriate method
      String raw =  rec[4] + rec[0]
      validForms.add(raw)
    }

    return validForms
  }

}