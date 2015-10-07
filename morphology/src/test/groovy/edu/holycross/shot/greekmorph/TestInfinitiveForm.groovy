package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestInfinitiveForm {

  @Test
  void testInfinitiveForm () {
    InfinitiveForm infinitive =  new InfinitiveForm(Tense.PRESENT, Voice.ACTIVE)
    assert infinitive.toString() == "present active"
  }

}
