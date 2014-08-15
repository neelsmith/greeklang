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
  Integer FRANTIC = 5
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



    // filter these candidates against:
    // 1. limits on the stem value (application filer from morphstems)
    // 2. limits on the ending value (from endings)

    if (debug > WARN) {
      System.err.println "FormGenerator: for ${lexEnt}, generate form : " + requestedForm.toArrayOfString()
    }

    ArrayList usableList = []
    candidatesList.each {  candidate ->
      if (debug > FRANTIC) {
	System.err.println "CANDIDATE STRUCT: " + candidate      
      }	

      ArrayList candidateFormFilter = candidate[1].split(/:/)
      ArrayList candidateStemFilter = candidate[5].split(/:/)
      
      if (
	(FormFilter.formMatches(requestedForm.toArrayOfString(), candidateFormFilter)) && 
	(FormFilter.formMatches(requestedForm.toArrayOfString(),candidateStemFilter ))
      ) {
	usableList.add(candidate)
	if (debug > WARN) {
	  System.err.println "Mathch of candidate " + candidateFormFilter
	  System.err.println " with req'ed form" + requestedForm.toArrayOfString()
	  System.err.println "so added " + candidate
	  
	  System.err.println "Usable list size now " + usableList.size()
	}

      }
    }
    def validForms = []
    if (debug > WARN) {
      System.err.println "FormGenerator:  got ${usableList.size()} usable candidates : " + usableList
    }
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