package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestTenseEnum {

  def expectedTokens = ["<pres>", "<impft>", "<fut>", "<aor>", "<pft>", "<plupft>"]
  def expectedLabels = ["present", "imperfect", "future", "aorist", "perfect", "pluperfect"]

  @Test
  void testTenseEnum() {
    ArrayList testList = Tense.values()  as ArrayList
    testList.eachWithIndex { n, i ->
      assert n.getToken() == expectedTokens[i]
      assert n.getLabel() == expectedLabels[i]
    }
  }
}
