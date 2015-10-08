package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestVoiceEnum {

  def expectedTokens = ["<act>", "<mid>", "<pass>"]
  def expectedLabels = ["active", "middle", "passive"]

  @Test
  void testVoiceEnum() {
    ArrayList testList = Voice.values()  as ArrayList
    testList.eachWithIndex { n, i ->
      assert n.getToken() == expectedTokens[i]
      assert n.getLabel() == expectedLabels[i]
    }
  }
  @Test
  void testIndex() {
    assert Voice.getByToken("<act>") == Voice.ACTIVE
    assert Voice.getByToken("<mid>") == Voice.MIDDLE
    assert Voice.getByToken("<pass>") == Voice.PASSIVE

  }
}
