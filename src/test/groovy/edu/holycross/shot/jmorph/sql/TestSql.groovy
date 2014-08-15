package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test

import edu.harvard.chs.cite.CiteUrn

class TestSql extends GroovyTestCase {


  File stemsFile  = new File("testdata/morph/morphstems.csv")
  File endingsFile  = new File("testdata/morph/endings.csv")
  File stemTypesFile = new File("testdata/morph/stemtypes.csv")
  File inflClassFile = new File("testdata/morph/inflclass.csv")





  void testNounLoad() {
    CiteUrn logos = new CiteUrn("urn:cite:perseus:lexentity.lex41535.1")
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)
    assert msql
    ArrayList endingList = msql.endingsForLexEnt(logos)
    Integer expectedMinSize = 30
    assert  endingList.size() >= expectedMinSize
  }


  void testVerbLoad() {
    CiteUrn to_have = new CiteUrn("urn:cite:perseus:lexentity.lex113895.1")
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)


    ArrayList endingList = msql.endingsForLexEnt(to_have)
    Integer expectedMinSize = 16
    assert endingList.size() >= expectedMinSize

    endingList.each {
      println "ENDING LIST: " + it[5]
    }
  }



}