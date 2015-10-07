package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestNumberEnum {

  def expectedTokens = ["<sg>", "<dual>", "<pl>"]
  def expectedLabels = ["singular", "dual", "plural"]
  @Test
  void testNumberEnum() {

    //ArrayList nums = TinyNumber.values()  as ArrayList
    ArrayList nums = GrammaticalNumber.values()  as ArrayList
    println nums
    nums.eachWithIndex { n, i ->
      print i
      println "  " + n.getToken()
      assert n.getToken() == expectedTokens[i]
      assert n.getLabel() == expectedLabels[i]
    }
  }
}
