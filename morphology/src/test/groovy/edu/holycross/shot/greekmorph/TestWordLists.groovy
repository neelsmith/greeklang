package edu.holycross.shot.greekmorph


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.greekutils.GreekString

class TestWordLists {

  File srcDir = new File("fst_tests/wordlists")
  String transducer = "build/fst/greek.a"
  MorphologicalParser mp  = new MorphologicalParser(transducer)

  @Test
  void testWords() {
    srcDir.eachFileMatch(~/.*.txt/) { wordList ->
      wordList.readLines().each { w ->
        GreekString gs = new GreekString(w, "Unicode")
        System.out.print "Analyzing ${w} ... "
        try {
          MorphologicalAnalysis morph = mp.parseGreekString(gs)
          println "success."
        } catch (Exception e) {
          println "failed."
          println e
        }
      }
    }
  }
}
