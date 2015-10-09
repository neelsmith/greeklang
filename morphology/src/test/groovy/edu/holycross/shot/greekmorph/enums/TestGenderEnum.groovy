package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestGenderEnum {

  def expectedTokens = ["<masc>", "<fem>", "<neut>"]
  def expectedLabels = ["masculine", "feminine", "neuter"]

  @Test
  void testVoiceEnum() {
    ArrayList testList = Gender.values()  as ArrayList
    testList.eachWithIndex { n, i ->
      assert n.getToken() == expectedTokens[i]
      assert n.getLabel() == expectedLabels[i]
    }
  }

  @Test
  void testIndex() {
    assert Gender.getByToken("<masc>") == Gender.MASCULINE
    assert Gender.getByToken("<fem>") == Gender.FEMININE
    assert Gender.getByToken("<neut>") == Gender.NEUTER
  }
}
