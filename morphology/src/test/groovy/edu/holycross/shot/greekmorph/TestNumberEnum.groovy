package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestNumberEnum {

  def expectedTokens = ["<sg>", "<dual>", "<pl>"]
  def expectedLabels = ["singular", "dual", "plural"]
  @Test
  void testNumberEnum() {
    ArrayList nums = GrammaticalNumber.values()  as ArrayList
    println nums
    nums.eachWithIndex { n, i ->
      assert n.getToken() == expectedTokens[i]
      assert n.getLabel() == expectedLabels[i]
    }
  }

  @Test
  void testIndex() {
    assert GrammaticalNumber.getByToken("<sg>") == GrammaticalNumber.SINGULAR
    assert GrammaticalNumber.getByToken("<dual>") == GrammaticalNumber.DUAL
    assert GrammaticalNumber.getByToken("<pl>") == GrammaticalNumber.PLURAL
  }
}
