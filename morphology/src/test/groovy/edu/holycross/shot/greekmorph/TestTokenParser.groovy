package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestTokenParser {

  String parser = "build/fst/morphology.a"

  @Test
  void testParser() {
    String fstToken = "luw"
    FstParser fst = new FstParser(parser)
    def analyses = fst.parseToken(fstToken)
    analyses.each {
      println it
    }
  }

}
