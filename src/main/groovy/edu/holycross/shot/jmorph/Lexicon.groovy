package edu.holycross.shot.jmorph

import au.com.bytecode.opencsv.CSVReader
import java.sql.*
import org.sqlite.SQLite
import groovy.sql.Sql

/**
 * A class for working with an inventory of Greek lexical entities.
 */
class Lexicon {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0

  groovy.sql.Sql lexiconDb

  /** Constructor loads lexicon data from a .csv formatted file.
   * @param csvFile CSV file with lexicon data.
   * @throws Exception if can't load data from csvFile.
   */
  Lexicon(File csvFile) 
  throws Exception {
    lexiconDb = Sql.newInstance("jdbc:sqlite:lexicon.db", "org.sqlite.JDBC")
    lexiconDb.execute("drop table if exists lexicon")
    lexiconDb.execute("create table lexicon (urn string primary key, lemma string, shortdef string)")

    loadCsv(csvFile)
  }


  void loadCsv(File f) {
    Integer count = 0
    CSVReader reader = new CSVReader(new FileReader(f))        
    reader.readAll().each { cols ->

      if (count == 0) {
	// skip header line
      } else {
	if (cols.size() == 3) {
	  def lexEntries = lexiconDb.dataSet("lexicon")
	  lexEntries.add(urn: cols[0], lemma: cols[1], shortdef: cols[2])
	} else {
	 System.err.println "Skipping input line with ${cols.size()} data columns."
	}
      }
      count++;
    }
  }

}