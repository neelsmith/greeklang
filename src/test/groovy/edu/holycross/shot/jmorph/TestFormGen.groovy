package edu.holycross.shot.jmorph

import java.sql.*
import org.sqlite.SQLite
import groovy.sql.Sql

import static org.junit.Assert.*
import org.junit.Test

import edu.harvard.chs.cite.CiteUrn

class TestFormGen extends GroovyTestCase {


  CiteUrn logos = new CiteUrn("urn:cite:perseus:lexentity.lex41535.1")
  MorphForm m_dat_s = new MorphForm( ["","singular","","","","masculine","dative","","noun"])

  File stemsFile  = new File("testdata/morph/morphstems.csv")
  File endingsFile  = new File("testdata/morph/endings.csv")
  File stemTypesFile = new File("testdata/morph/stemtypes.csv")
  File inflClassFile = new File("testdata/morph/inflclass.csv")


  File tagsFile = new File("testdata/morph/tags.csv")



  void testLoad() {
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)
    msql.loadTags(tagsFile)
    assert msql

    FormGenerator generator = new FormGenerator(msql)
    assert generator
  }


  void testNounGener() {
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)
    FormGenerator generator = new FormGenerator(msql)
    generator.debug = 5
    println generator.generate(logos, m_dat_s)
  }

  /*
  void testSelect() {
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)
    msql.loadTags(tagsFile)

    // test data has one of two tags: 'standard' or 'epic'
    ArrayList allEndingsList = msql.endingsForLexEnt(logos)
    ArrayList stdList =  msql.endingsForLexEnt(logos, "standard" )
    ArrayList epicList = msql.endingsForLexEnt(logos, "epic" )

    assert epicList.size() + stdList.size() == allEndingsList.size()

    def epicEndings = ["oii+n", "oisi", "oio"]
    epicList.each {
      String form = it[0]
      assert epicEndings.contains(form)
    }

  }
*/
}