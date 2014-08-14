package edu.holycross.shot.jmorph

import edu.harvard.chs.cite.CiteUrn


import au.com.bytecode.opencsv.CSVReader
import java.sql.*
import org.sqlite.SQLite
import groovy.sql.Sql

/**
 * A class for working with morphological data sets using in an
 * SQL system.
 */
class MorphSql {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0


  /** Sqlite database system for Greek morphological parsing. */
  groovy.sql.Sql morphDb

  /** Empty constructor initializes sqllite database instance.
   */
  MorphSql() {
    this.morphDb = Sql.newInstance("jdbc:sqlite:jmorph.db", "org.sqlite.JDBC")
  }


  /** Constructor destructively initializes sqllite from source files
   * for four required tables.  Existing tables are dropped, recreated,
   * and new data loaded from the source tables.  Source tables are in
   * csv format with a header line that is ignored.
   * @param stemCsv Database of morphological stems.
   * @param endingsCsv Database of morphological endings.
   * @param stemTypes Specific types of morphological stems, linked to
   * broader inflectional classes.  While the broader inflectional class
   * determines what set of endings to apply, the specific stem type
   * determines in more detail how those endings are applied.
   * @param inflClassesCsv Database of broader inflectional classes
   * determining what endings to apply
   */
  MorphSql(File stemCsv, File endingsCsv, File stemTypesCsv, File inflClassesCsv) {
    this.morphDb = Sql.newInstance("jdbc:sqlite:jmorph.db", "org.sqlite.JDBC")
    loadStems(stemCsv)
    loadEndings(endingsCsv)
    loadStemTypes(stemTypesCsv)
    loadInflectionalClasses(inflClassesCsv)
  }



  ArrayList endingsForLexEnt(CiteUrn lexicalEntityUrn) {
    return  endingsForLexEnt(lexicalEntityUrn.toString()) 
  }

  // returns array of ending+form+class lists
  ArrayList endingsForLexEnt(String lexicalEntityString) {
    ArrayList endings = []

    String query = """
select ic.label AS inflclass, e.ending AS ending, e.form  AS form
FROM morphstem m, endings e, stemtype st, inflclass ic
WHERE m.stemclass =  st.urn AND st.inflclass = ic.urn AND st.inflclass = e.formset
AND m.lexurn = '""" + lexicalEntityString + "'"

    morphDb.eachRow(query) { r ->
      def record = []
      record.add(r.ending)
      record.add(r.form)
      record.add(r.inflclass)
      endings.add(record)
    }
    return endings
  }



  // returns array of ending+form+class lists
  ArrayList endingsForLexEnt(CiteUrn lexicalEntity, String tag) {
    return endingsForLexEnt(lexicalEntity.toString(), tag)
  }


  ArrayList endingsForLexEnt(String lexicalEntityString, String tag) {
    ArrayList endings = []

    String query = """
select ic.label AS inflclass, e.ending AS ending, e.form  AS form
FROM morphstem m, endings e, stemtype st, inflclass ic, tags t
WHERE m.stemclass =  st.urn AND st.inflclass = ic.urn AND st.inflclass = e.formset AND e.urn = t.ending
AND m.lexurn = '""" + lexicalEntityString + "' AND t.tag = '"  + tag + "'"

    morphDb.eachRow(query) { r ->
      def record = []
      record.add(r.ending)
      record.add(r.form)
      record.add(r.inflclass)
      endings.add(record)
    }
    return endings
  }



  /** Loads morphological stem types from a csv file. 
   * Replaces any existing data by recreating the inflclass
   * table before loading new data from csvFile.
   * @param csvFile File with endings data in csv format.
   */
  void loadInflectionalClasses(File csvFile) {
    morphDb.execute("drop table if exists inflclass")
    morphDb.execute("create table inflclass (urn string primary key,label string)")
    def inflClassData = morphDb.dataSet("inflclass")

    Integer count = 0
    CSVReader reader = new CSVReader(new FileReader(csvFile))        
    reader.readAll().each { cols ->
      if (count == 0) {
	// skip header line
      } else {
	if (cols.size() == 2) {
	  inflClassData.add(urn: cols[0], label: cols[1])
	} else {
	 System.err.println "Skipping input line with ${cols.size()} data columns."
	}
      }
      count++;
    }    
  }


  /** Loads morphological stem types from a csv file. 
   * Replaces any existing data by recreating the stemtype
   * table before loading new data from csvFile.
   * @param csvFile File with endings data in csv format.
   */
  void loadStemTypes(File csvFile) {
    morphDb.execute("drop table if exists stemtype")
    morphDb.execute("create table stemtype (urn string primary key,label string, inflclass string)")
    def stemTypeData = morphDb.dataSet("stemtype")

    Integer count = 0
    CSVReader reader = new CSVReader(new FileReader(csvFile))        
    reader.readAll().each { cols ->
      if (count == 0) {
	// skip header line
      } else {
	if (cols.size() == 3) {
	  stemTypeData.add(urn: cols[0], label: cols[1], inflclass: cols[2])
	} else {
	 System.err.println "Skipping input line with ${cols.size()} data columns."
	}
      }
      count++;
    }    
  }

  /** Loads morphological stems data from a csv file. 
   * Replaces any existing data by recreating the morphstem
   * table before loading new data from csvFile.
   * @param csvFile File with endings data in csv format.
   */
  void loadStems(File csvFile) {
    morphDb.execute("drop table if exists morphstem")
    morphDb.execute("create table morphstem (urn string primary key,lexurn string, lemma string, stem string, stemclass string,application string)")
    def stemData = morphDb.dataSet("morphstem")

    Integer count = 0
    CSVReader reader = new CSVReader(new FileReader(csvFile))        
    reader.readAll().each { cols ->
      if (count == 0) {
	// skip header line
      } else {
	if (cols.size() == 6) {
	  stemData.add(urn: cols[0], lexurn: cols[1], lemma: cols[2],stem: cols[3], stemclass: cols[4], application: cols[5] )
	} else {
	 System.err.println "Skipping input line with ${cols.size()} data columns."
	}
      }
      count++;
    }
  }


  /** Loads morphological endings data from a csv file. 
   * Replaces any existing data by recreating the endings
   * table before loading new data from csvFile.
   * @param csvFile File with endings data in csv format.
   */
  void loadEndings(File csvFile) 
  throws Exception {
    morphDb.execute("drop table if exists endings")
    morphDb.execute("create table endings (urn string primary key,ending string, form string,formset string)")
    def endingsData = morphDb.dataSet("endings")

    Integer count = 0
    CSVReader reader = new CSVReader(new FileReader(csvFile))        
    reader.readAll().each { cols ->
      if (count == 0) {
	// skip header line
      } else {
	if (cols.size() == 4) {
	  endingsData.add(urn: cols[0], ending: cols[1], form: cols[2],formset: cols[3])
	} else {
	  System.err.println "Skipping input line with ${cols.size()} data columns."
	}
      }
      count++;
    }
  }


  /** Loads lexicon data from a csv file.  By default, replaces
   * any existing lexicon, by using the overloaded signature
   * to ask explicitly to load the lexicon by replacing, not
   * appending, existing data.
   * @param csvFile File with lexicon data in csv format.
   */
  void loadLexicon(File csvFile) {
    loadLexicon(csvFile, false)
  }
   
  /** Loads lexicon data from a csv file. 
   * @param append True if existing lexicon data should be 
   * kept.  If append is false, the lexicon table is recreated
   * with only the data from csvFile.
   * @param csvFile File with lexicon data in csv format.
   */
  void loadLexicon(File csvFile, boolean append) {
    if (! append) {
      morphDb.execute("drop table if exists lexicon")
      morphDb.execute("create table lexicon (urn string primary key, lemma string, shortdef string)")
    }
    def lexEntries = morphDb.dataSet("lexicon")

    Integer count = 0
    CSVReader reader = new CSVReader(new FileReader(csvFile))        
    reader.readAll().each { cols ->
      if (count == 0) {
	// skip header line
      } else {
	if (cols.size() == 3) {
	  lexEntries.add(urn: cols[0], lemma: cols[1], shortdef: cols[2])
	} else {
	 System.err.println "Skipping input line with ${cols.size()} data columns."
	}
      }
      count++;
    }
  }



 /** Loads tag data from a csv file. 
   * @param csvFile File with lexicon data in csv format.
   */
  void loadTags(File csvFile) {
    morphDb.execute("drop table if exists tags")
    morphDb.execute("create table tags (ending string, tag string)")

    def tags = morphDb.dataSet("tags")

    Integer count = 0
    CSVReader reader = new CSVReader(new FileReader(csvFile))        
    reader.readAll().each { cols ->
      if (count == 0) {
	// skip header line
      } else {
	if (cols.size() == 2) {
	  tags.add(ending: cols[0], tag: cols[1])
	} else {
	 System.err.println "Skipping input line with ${cols.size()} data columns."
	}
      }
      count++;
    }
  }



}