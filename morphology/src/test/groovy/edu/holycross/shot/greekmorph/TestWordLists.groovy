package edu.holycross.shot.greekmorph


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.greekutils.GreekString

class TestWordLists {

  String transducer = "build/fst/greek.a"
  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  UrnManager umgr = new UrnManager(inflCsvSource)


  @Test
  void testWords() {
    File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
    umgr.addCsvFile(lexCsvSource)

    MorphologicalParser mp  = new MorphologicalParser(transducer, umgr)

    def totalsByFile = [:]
    File srcDir = new File("unit_tests_data/wordlists")
    srcDir.eachFileMatch(~/.*.txt/) { wordList ->
      println "Scoring word list ${wordList}"
      Integer success = 0
      Integer failed = 0
      wordList.readLines().each { w ->

        if ((w.size() < 1) ||  (w[0] == "%")) {
          // comment or empty line
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
