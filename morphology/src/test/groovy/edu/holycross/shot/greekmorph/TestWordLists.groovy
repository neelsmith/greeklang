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
    def totalsByFile = [:]
    srcDir.eachFileMatch(~/.*.txt/) { wordList ->
      println "Scoring word list ${wordList}"
      Integer success = 0
      Integer failed = 0
      wordList.readLines().each { w ->
        if (w[0] == "%") {
          // comment
        } else {
          GreekString gs = new GreekString(w, "Unicode")
          System.out.print "Analyzing ${w} ... "
          try {
            MorphologicalAnalysis morph = mp.parseGreekString(gs)
            println "success."
            success++
          } catch (Exception e) {
            println "failed:"
            println "\t" + e
            failed++
          }
        }
      }
      String summ =  "${success} successes, ${failed} failed"
      println summ + "\n"
      totalsByFile[wordList] = summ
    }
    println "\n\nSummary by file:"
    totalsByFile.each {
      println "${it.key}: ${it.value}"
    }
  }
}
