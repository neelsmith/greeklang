package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestAnalyticalTypeEnum {

  def expectedTokens = ["<verb>", "<ptcpl>", "<infin>","<vadj>","<noun>", "<adj>","<adv>","<indecl>" ]
  def expectedLabels = ["conjugated verb", "participle", "infinitive", "verbal adjective", "noun","adjective", "adverb", "indeclinable form"]

  @Test
  void testAnalyticalTypeEnum() {
    ArrayList testList = AnalyticalType.values()  as ArrayList
    testList.eachWithIndex { n, i ->
      assert n.getToken() == expectedTokens[i]
      assert n.getLabel() == expectedLabels[i]
    }
  }

  @Test
  void testIndex() {
    println AnalyticalType.codeMap
    def verbType = AnalyticalType.getByToken("<verb>")
    assert verbType.getLabel() == "conjugated verb"
    assert verbType.toString() == verbType.getLabel()

  }

}
