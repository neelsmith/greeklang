package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestLexicon extends GroovyTestCase {


  

  void testLoad() {
    File lexiconFile  = new File("data/luschnig-paradigms.csv")
    Lexicon lexicon = new Lexicon(lexiconFile)
    assert lexicon

    // should normalize before comparison!
    String expectedLemma = "δίκη"
    String expectedUrn = "urn:cite:perseus:lexentity.lex17565.1"
    lexicon.lexiconDb.eachRow("select * from lexicon where urn = '" + expectedUrn + "'") {
      assert it.lemma == expectedLemma
    }

    lexicon.lexiconDb.eachRow("select * from lexicon where lemma = '" + expectedLemma + "'") {
      assert it.urn == expectedUrn
    }



  }


}