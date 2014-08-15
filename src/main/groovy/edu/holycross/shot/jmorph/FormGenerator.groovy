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
   * @returns An appropriate surface string for the specified lexical
   * entity in the specified form.
   */
  String generate(CiteUrn lexEnt, MorphForm requestedForm) {
    ArrayList candidatesList = db.endingsForLexEnt(lexEnt)
    if (debug > WARN) {
      System.err.println "Considering ${candidatesList.size()} possible endings"
    }
    ArrayList usableList = []
    candidatesList.each {  candidate ->
      ArrayList candidateFormFilter = candidate[1].split(/:/)
      if (debug > WARN) {
	System.err.println "Checking ${requestedForm.toArrayOfString()} against " + candidateFormFilter
      }
      if (FormFilter.formMatches(requestedForm.toArrayOfString(), candidateFormFilter)) {
	usableList.add(candidate)
      }
    }
    if (debug > WARN) {
      System.err.println "Filtered to get ${usableList.size()} possible endings"
    }
    return usableList
  }

}