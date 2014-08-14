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

  String generate(CiteUrn lexEnt, MorphForm requestedForm) {
    ArrayList endingsList = db.endingsForLexEnt(lexEnt)
    if (debug > WARN) {
      System.err.println "Considering ${endingsList.size()} possible endings"
    }
    ArrayList usableList = []
    endingsList.each {  el ->
      ArrayList formArray = el[1].split(/:/)
      if (FormFilter.formMatches(formArray,requestedForm)) {
	usableList.add(filtered[0])
      }
    }
    if (debug > WARN) {
      System.err.println "Filtered to get ${usableList.size()} possible endings"
    }
    return usableList
  }

}