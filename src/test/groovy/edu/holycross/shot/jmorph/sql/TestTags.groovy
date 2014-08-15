package edu.holycross.shot.jmorph

import java.sql.*
import org.sqlite.SQLite
import groovy.sql.Sql

import static org.junit.Assert.*
import org.junit.Test

import edu.harvard.chs.cite.CiteUrn

class TestTags extends GroovyTestCase {

  File stemsFile  = new File("testdata/morph/morphstems.csv")
  File endingsFile  = new File("testdata/morph/endings.csv")
  File stemTypesFile = new File("testdata/morph/stemtypes.csv")
  File inflClassFile = new File("testdata/morph/inflclass.csv")
  File tagsFile = new File("testdata/morph/tags.csv")

  CiteUrn logos = new CiteUrn("urn:cite:perseus:lexentity.lex41535.1")

  void testLoad() {
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)
    msql.loadTags(tagsFile)
    assert msql

    groovy.sql.Sql morphDb =  Sql.newInstance("jdbc:sqlite:jmorph.db", "org.sqlite.JDBC")

    Integer expectedCount = 30
    morphDb.eachRow("select count(*) as rowcount from tags") { r ->
      assert expectedCount == r.rowcount as Integer
    }
  }

  void testSelect() {
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)
    msql.loadTags(tagsFile)

    // test data has one of two tags: 'standard' or 'epic'
    ArrayList allEndingsList = msql.endingsForLexEnt(logos)
    ArrayList stdList =  msql.endingsForLexEnt(logos, "standard" )
    ArrayList epicList = msql.endingsForLexEnt(logos, "epic" )

    assert epicList.size() + stdList.size() == allEndingsList.size()

    def epicEndings = ["oii+n", "oisi", "oio", "ofi"]
    epicList.each {
      String form = it[0]
      assert epicEndings.contains(form)
    }
  }

  void testReturnType() {
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)
    ArrayList allEndingsList = msql.endingsForLexEnt(logos)
    allEndingsList.each {
      println "Class ${it.getClass()}: ${it}"
    }
  }


}