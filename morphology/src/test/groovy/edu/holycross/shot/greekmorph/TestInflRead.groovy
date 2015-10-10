package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestInflRead {

  File dataFile = new File("unit_tests_data/inflreports/inflrept1.txt")

  @Test
  void TestInflReader() {
    FstInflReader fstReader = new FstInflReader()
    def analyses = fstReader.readFstInflFile(dataFile)
    Integer expectedAnalyses = 6
    assert analyses.size() == expectedAnalyses
  }
}
