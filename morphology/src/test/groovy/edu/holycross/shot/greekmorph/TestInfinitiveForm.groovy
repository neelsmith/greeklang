package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestInfinitiveForm {

  @Test
  void testInfinitiveForm () {
    InfinitiveForm infinitive =  new InfinitiveForm(Tense.PRESENT, Voice.ACTIVE)
    assert infinitive.toString() == "present active"
  }


  @Test
  void testUrns() {
    InfinitiveForm infinitive =  new InfinitiveForm(Tense.PRESENT, Voice.ACTIVE)
    assert infinitive.getUrn().toString() == "urn:cite:morph:form.if00"
  }

}
