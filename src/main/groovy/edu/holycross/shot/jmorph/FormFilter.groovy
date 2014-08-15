package edu.holycross.shot.jmorph



/**
 * Class of static methods for filtering forms.  "Forms" are full specification of morphological
 * forms:  either MorphForm objects, or colon-delimited Strings or ArrayLists that validate
 * as MorphForms when used to construct a MorphForm object with boolean "check" parameter set to
 * true (the default).  "Filters" are MorphForm objects, or colon-delimited Strings or ArrayLists that
 * that may or may not validate as MorphForms when used to construct a MorphForm object with boolean 
 * "check" parameter set to true, but can create MorphForm objects when "check" == false.
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


  /** Determines if a valid MorphForm matches a filter specification.
   * @param formArray A fully valid morphological form specification.
   * @param morphFilter A filter expression, represented as a nine-element
   * MorphForm array.
   * @returns True if formArray matches the specification in morphFilter.
   */
  static boolean formMatches(MorphForm formObject,  ArrayList morphFilter) {
    return formMatches(formObject.toArrayOfString(), morphFilter)
  }



  /** Determines if a valid MorphForm matches a filter specification.
   * @param formArray A fully valid morphological form specification
   * represented as a nine-element MorphForm array.
   * @param morphFilter A filter expression, represented as a nine-element
   * MorphForm array.
   * @returns True if formArray matches the specification in morphFilter.
   */
  static boolean formMatches(ArrayList formArray, ArrayList filterForm) {
    boolean fullMatch = true
    formArray.eachWithIndex { props, i ->
      if (filterForm[i] != "")  {
	if (props?.toLowerCase() != filterForm[i]?.toLowerCase()) {
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
      if (formMatches(formArray,filterForm)) {
	filtered.add(formArray)
      }
    }
    return filtered
  }
  
}
