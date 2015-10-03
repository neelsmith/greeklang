package edu.holycross.shot.fstio

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestInflRead {

  File dataFile = new File("testdata/inflreports/inflrept1.txt")

  @Test
  void TestInflReader() {
    FstInflReader fstReader = new FstInflReader()
    def analyses = fstReader.readFstInflFile(dataFile)
    analyses.keySet().each { k ->
      println k + " -> " + analyses[k]
    }
  }
}
