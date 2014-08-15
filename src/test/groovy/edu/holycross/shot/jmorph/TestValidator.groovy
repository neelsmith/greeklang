package edu.holycross.shot.jmorph


import au.com.bytecode.opencsv.CSVReader

import java.sql.*
import org.sqlite.SQLite
import groovy.sql.Sql

import static org.junit.Assert.*
import org.junit.Test

import edu.harvard.chs.cite.CiteUrn

class TestValidator extends GroovyTestCase {


  //CiteUrn logos = new CiteUrn("urn:cite:perseus:lexentity.lex41535.1")
  //MorphForm m_dat_s = new MorphForm( ["","singular","","","","masculine","dative","","noun"])
  //MorphForm m_gen_s = new MorphForm( ["","singular","","","","masculine","genitive","","noun"])

  File stemsFile  = new File("testdata/morph/morphstems.csv")
  File endingsFile  = new File("testdata/morph/endings.csv")
  File stemTypesFile = new File("testdata/morph/stemtypes.csv")
  File inflClassFile = new File("testdata/morph/inflclass.csv")

  File tagsFile = new File("testdata/morph/tags.csv")

  File genTestsDirectory = new File("testdata/validationsuite/generator")


  void testLoad() {
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)
    msql.loadTags(tagsFile)

    FormGenerator generator = new FormGenerator(msql)

    genTestsDirectory.eachFileMatch(~/.*.csv/) { csvFile ->  
      Integer count = 0
      CSVReader reader = new CSVReader(new FileReader(csvFile))        
      reader.readAll().each { cols ->
	if (count == 0) {
	  // skip header line
	} else {
	  if (cols.size() == 6) {
	    CiteUrn lexicalEntity = new CiteUrn(cols[1])
	    MorphForm requestedForm = new MorphForm(cols[2])
	    def expectedReply = cols[4].split(/,/)
	    String tag = cols[3]
	    
	    ArrayList actualReply = []
	    if (tag != "") {
	      actualReply = generator.generate(lexicalEntity, requestedForm, tag)      
	    } else {
	      actualReply = generator.generate(lexicalEntity, requestedForm)      
	    }
	    println "${cols[0]}, ${requestedForm.toArrayOfString()}: " + actualReply

	    /*
	    def tagList = cols[3].split(/,/)
	    if (tagList.size() > 0)  {
	    }*/
	    
	  } else {
	    System.err.println "Skipping input line with ${cols.size()} data columns."
	  }
	}
	count++;
      }    
    }

  }

}