package edu.holycross.shot.jmorph

import au.com.bytecode.opencsv.CSVReader
import java.sql.*
import org.sqlite.SQLite
import groovy.sql.Sql

/**
 * A class representing morphological endings.
 */
class MorphEndings {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0

  groovy.sql.Sql endingsDb

  /** Constructor loads  data from a .csv formatted file.
   * @param csvFile CSV file with morphological stem data.
   * @throws Exception if can't load data from csvFile.
   */
  MorphEndings(File csvFile) 
  throws Exception {
    endingsDb = Sql.newInstance("jdbc:sqlite:endings.db", "org.sqlite.JDBC")
    endingsDb.execute("drop table if exists endings")
    endingsDb.execute("create table endings (urn string primary key,ending string, form string,formset string)")
    loadCsv(csvFile)
  }


  /** Reads data from csv file and loads into SQL database.
   * @param f File with csv export of data.
   * @throws Exception if unable to load data from f.
   */
  void loadCsv(File f) 
  throws Exception {
    Integer count = 0
    CSVReader reader = new CSVReader(new FileReader(f))        
    reader.readAll().each { cols ->

      if (count == 0) {
	// skip header line
      } else {
	if (cols.size() == 4) {
	  def endingsData = endingsDb.dataSet("endings")
	  endingsData.add(urn: cols[0], ending: cols[1], form: cols[2],formset: cols[3])
	} else {
	 System.err.println "Skipping input line with ${cols.size()} data columns."
	}
      }
      count++;
    }
  }

}