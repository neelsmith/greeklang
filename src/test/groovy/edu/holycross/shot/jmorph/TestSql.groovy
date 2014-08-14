package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test



class TestSql extends GroovyTestCase {


  File stemsFile  = new File("testdata/morph/morphstems.csv")
  File endingsFile  = new File("testdata/morph/endings.csv")
  File stemTypesFile = new File("testdata/morph/stemtypes.csv")
  File inflClassFile = new File("testdata/morph/inflclass.csv")

  void testLoad() {
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)
    File lexiconFile  = new File("testdata/morph/luschnig-paradigms.csv")
  }

}