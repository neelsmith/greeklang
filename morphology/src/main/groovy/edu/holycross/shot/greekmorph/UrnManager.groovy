package edu.holycross.shot.greekmorph


import edu.harvard.chs.cite.CiteUrn

/**
* A class for managing abbreviations and fully expanded URNs.
* Note that collection ID values must be unique in the context of the
* UrnManager, note merely unique within the context of the
* CITE namespace.
*/
class UrnManager {

  /** Map of individual collection IDs to full Collection URN
  * Strings.
  */
  LinkedHashMap abbrToUrnMap = [:]

  /** Constructor loading initial data from a file.
  * @param csvMap A `.csv` file with one header row and two or more columns.
  * The first column has the identifier for the collection component of a URN;
  * the second column has the full URN for the Collection.
  */
  UrnManager(File csvMap) {
    addCsvFile(csvMap)
  }

  /** Adds data from a .csv file to abbrToUrnMap.
  * @param f A `.csv` file with one header row and two or more columns.
  * The first column has the identifier for the collection component of a URN;
  * the second column has the full URN for the Collection.
  * @throws Exception if String can't be read as a CITE URN.
  */
  void addCsvFile(File f)
  throws Exception  {
    Integer lineCount = 0
    f.eachLine { ln ->
      if (lineCount > 0) {
        def cols = ln.split(",")
        if (cols.size() < 2) {
          throw new Exception("UrnManager: could not parse line ${ln}")
        }
        String abbr = cols[0]
        try {
          CiteUrn urn = new CiteUrn(cols[1])
          if (urn.getCollection() != abbr) {
            throw new Exception("UrnManager: ${abbr} does not match ${cols[1]}")
          }
          abbrToUrnMap[abbr] = urn
        } catch (Exception e) {
          throw e
        }
      }
      lineCount++
    }
  }

  /** Returns collection-level CITE URN for
  * a unique Collection ID value.
  * @param abbr Collection ID to look up.
  * @returns CiteUrn object for the collection.
  */
  CiteUrn getUrn(String abbr) {
    return abbrToUrnMap[abbr]
  }


}
