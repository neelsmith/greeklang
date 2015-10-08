package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestPersonEnum {

  def expectedTokens = ["<1st>", "<2nd>", "<3rd>"]
  def expectedLabels = ["first person", "second person", "third person"]

  @Test
  void testPersonEnum() {
    ArrayList testList = Person.values()  as ArrayList
    testList.eachWithIndex { n, i ->
      assert n.getToken() == expectedTokens[i]
      assert n.getLabel() == expectedLabels[i]
    }
  }


    @Test
    void testIndex() {
      assert Person.getByToken("<1st>") == Person.FIRST
      assert Person.getByToken("<2nd>") == Person.SECOND
      assert Person.getByToken("<3rd>") == Person.THIRD

    }
}
