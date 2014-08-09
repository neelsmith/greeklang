package edu.holycross.shot.jmorph

//import edu.holycross.shot.greekutils

import static org.junit.Assert.*
import org.junit.Test


class TestMorphStems extends GroovyTestCase {

  void testLoad() {
    File stemsFile  = new File("data/morphstems.csv")
    MorphStemSet morphStems = new MorphStemSet(stemsFile)
    assert morphStems

    // should normalize before comparison!
    String expectedLemma = "di/kh"
    String expectedUrn = "urn:cite:perseus:lexentity.lex17565.1"
    morphStems.stemsDb.eachRow("select * from morphstem where lexurn = '" + expectedUrn + "'") {
      //assert it.lemma == expectedLemma
      println "ROW: " + it
    }

    morphStems.stemsDb.eachRow("select * from morphstem where lemma = '" + expectedLemma + "'") {
      //assert it.urn == expectedUrn
    }



  }


}