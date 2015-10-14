package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestNounForm {

  @Test
  void testNounForm () {
    NounForm noun =  new NounForm(Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR)
    assert noun.toString() == "masculine nominative singular"
  }

  @Test
  void testUrns() {
    NounForm noun =  new NounForm(Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR)
    assert noun.getUrn().toString() == "urn:cite:gmorph:form.no000"
  }
}
