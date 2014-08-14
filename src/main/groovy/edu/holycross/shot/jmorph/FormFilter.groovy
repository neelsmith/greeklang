package edu.holycross.shot.jmorph



/**
 * 
 */
class FormFilter {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0




  FormFilter() {
  }


  static boolean formMatches(ArrayList formArray, MorphForm morphFilter) {
    return formMatches(formArray, morphFilter.toArrayOfString())
  }


  static boolean formMatches(ArrayList formArray, ArrayList filterForm) {
    boolean fullMatch = true
    formArray.eachWithIndex { props, i ->
      if (filterForm[i] != "")  {
	if (props != filterForm[i]) {
	  fullMatch = false
	}
      }
    }
    return fullMatch
  }



  static ArrayList filterList(ArrayList formsArrayList, MorphForm filter) {
    return filterList(formsArrayList, filter.toArrayOfString())
  }

  //  
  static ArrayList filterList(ArrayList formsArrayList, ArrayList filterForm) {
    ArrayList filtered = []

    formsArrayList.each { formArray ->
      /*
      boolean keep = true
      formArray.eachWithIndex { props, i ->
	if (filterForm[i] != "")  {
	  if (props != filterForm[i]) {
	    keep = false
	  }
	}
      }
      */
      System.err.println "CLASS OF FORM ARRAY IS " + formArray.getClass() + ", " + formArray
      if (formMatches(formArray,filterForm)) {
	filtered.add(formArray)
      }
    }
    return filtered
  }
  

}