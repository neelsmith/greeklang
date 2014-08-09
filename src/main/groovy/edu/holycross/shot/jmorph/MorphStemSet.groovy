package edu.holycross.shot.jmorph

import au.com.bytecode.opencsv.CSVReader
import java.sql.*
import org.sqlite.SQLite
import groovy.sql.Sql

/**
 * A class representing a morphological lexicon, or collection
 * of morphological stems.
 */
class MorphStemSet {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0

  groovy.sql.Sql stemsDb

  /** Constructor loads  data from a .csv formatted file.
   * @param csvFile CSV file with morphological stem data.
   * @throws Exception if can't load data from csvFile.
   */
  MorphStemSet(File csvFile) 
  throws Exception {
    stemsDb = Sql.newInstance("jdbc:sqlite:morphstems.db", "org.sqlite.JDBC")
    stemsDb.execute("drop table if exists morphstem")
    stemsDb.execute("create table morphstem (urn string primary key,lexurn string, lemma string, stem string, stemclass string,application string)")
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
	if (cols.size() == 6) {
	  def stemData = stemsDb.dataSet("morphstem")
	  stemData.add(urn: cols[0], lexurn: cols[1], lemma: cols[2],stem: cols[3], stemclass: cols[4], application: cols[5] )
	} else {
	 System.err.println "Skipping input line with ${cols.size()} data columns."
	}
      }
      count++;
    }
  }

}