package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test

import edu.harvard.chs.cite.CiteUrn

class TestSql extends GroovyTestCase {


  File stemsFile  = new File("testdata/morph/morphstems.csv")
  File endingsFile  = new File("testdata/morph/endings.csv")
  File stemTypesFile = new File("testdata/morph/stemtypes.csv")
  File inflClassFile = new File("testdata/morph/inflclass.csv")


  CiteUrn logos = new CiteUrn("urn:cite:perseus:lexentity.lex41535.1")

  void testLoad() {
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)
    assert msql
    ArrayList endingList = msql.endingsForLexEnt(logos)
    Integer expectedSize = 30
    assert expectedSize == endingList.size()
  }



}