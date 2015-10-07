package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestAdverbForm {

  @Test
  void testAdverbForm () {
    AdverbForm adv =  new AdverbForm(Degree.POSITIVE)
    assert adv.toString() == "positive"
  }

}
