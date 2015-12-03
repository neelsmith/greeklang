package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestWordSyllables {

  @Test
  void testSyllables() {
    GreekWord gw = new GreekWord("mh=nin")
    def expectedSyllables = ["mh", "nin"]
    def actualSyllables = gw.getSyllables()
    actualSyllables.eachWithIndex { syll, idx ->
      assert syll.toString() == expectedSyllables[idx]
    }
  }

  @Test
  void testAtticSyllables() {
    AtticWord aw = new AtticWord("BOLE=S")
    def expectedSyllables = ["BO", "LES"]
    def actualSyllables = gw.getSyllables()
    actualSyllables.eachWithIndex { syll, idx ->
      assert syll.toString() == expectedSyllables[idx]
    }
  }

}
