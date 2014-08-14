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


  static ArrayList filterList(ArrayList formsArrayList, MorphForm filter) {
    return filterList(formsArrayList, filter.toArrayOfString())
  }

  //  
  static ArrayList filterList(ArrayList formsArrayList, ArrayList filterForm) {
    ArrayList filtered = []

    formsArrayList.each { formArray ->
      boolean keep = true
      formArray.eachWithIndex { props, i ->
	if (filterForm[i] != "")  {
	  if (props != filterForm[i]) {
	    keep = false
	  }
	}
      }
      if (keep) {
	filtered.add(formArray)
      }
    }

    return filtered
  }
  

}