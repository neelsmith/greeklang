package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestTokenParser {

  String parser = "build/fst/greek.a"

  @Test
  void testParser() {
    String fstToken = "luw"
    FstParser fst = new FstParser(parser)
    def analyses = fst.parseTokenStr(fstToken)
    println "Analysis of ${fstToken}: " + analyses
    
  }


  @Test
  void testBreathing() {
    String fstToken = "e)lusa"
    FstParser fst = new FstParser(parser)
    def analyses = fst.parseTokenStr(fstToken)
    println "Analysis of ${fstToken}: " + analyses
  }
}
