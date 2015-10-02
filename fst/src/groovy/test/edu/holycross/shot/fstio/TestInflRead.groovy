package edu.holycross.shot.fstio


import static org.junit.Assert.*
import org.junit.Test


class TestInflRead extends GroovyTestCase {

  File dataFile = new File("testdata/inflreports/inflrept.txt")

  void TestInflReader() {
    FstInflReader fstReader = new FstInflReader()
    def analyses = fstReader.readFstInflFile(dataFile)
    analyses.keySet().each {
      println it + " -> " + analyses[it]
    }
  }
}
