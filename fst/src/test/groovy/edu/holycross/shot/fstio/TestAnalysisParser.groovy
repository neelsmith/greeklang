package edu.holycross.shot.fstio

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestAnalysisParser {

  @Test
  void testParser() {
    String infin = "<n64316><#>lu<verb><w_regular>::<infin>ein<pres><act><penacc>"
    FstAnalysisParser fap = new FstAnalysisParser(infin)
    assert fap.stem == "<n64316><#>lu<verb><w_regular>"
    assert fap.inflection == "<infin>ein<pres><act><penacc>"
  }
}
