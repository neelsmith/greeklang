package edu.holycross.shot.greekmorph


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestUrnManager {

  File csvSource = new File("src/fst/collectionAbbreviations.csv")

  @Test
  void testUrnMgr() {
    UrnManager umgr = new UrnManager(csvSource)
    String expected = "urn:cite:shot:lexent"
    assert umgr.getUrn("lexent").toString() ==  expected
  }
}
