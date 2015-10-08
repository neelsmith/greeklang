package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestParticipleForm {

  @Test
  void testParticipleForm () {
    ParticipleForm ptcpl =  new ParticipleForm(Tense.PRESENT, Voice.ACTIVE, Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR)
    assert ptcpl.toString() == "present active masculine nominative singular"
  }

  @Test
  void testUrns() {
    ParticipleForm ptcpl =  new ParticipleForm(Tense.PRESENT, Voice.ACTIVE, Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR)
    assert ptcpl.getUrn().toString() == "urn:cite:morph:form.pc00000"
  }
}
