package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestGrammaticalCaseEnum {

  def expectedTokens = ["<nom>", "<gen>", "<dat>","<acc>","<voc>"]
  def expectedLabels = ["nominative", "genitive", "dative", "accusative", "vocative"]

  @Test
  void testGrammaticalCaseEnum() {
    ArrayList testList = GrammaticalCase.values()  as ArrayList
    testList.eachWithIndex { n, i ->
      assert n.getToken() == expectedTokens[i]
      assert n.getLabel() == expectedLabels[i]
    }
  }
}
