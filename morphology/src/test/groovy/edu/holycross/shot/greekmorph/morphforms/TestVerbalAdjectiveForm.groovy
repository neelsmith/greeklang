package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestVerbalAdjectiveForm {

  @Test
  void testVerbalAdjectiveForm () {
    VerbalAdjectiveForm vadj =  new VerbalAdjectiveForm(Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR)
    assert vadj.toString() == "masculine nominative singular"
  }

  @Test
  void testUrns() {
    VerbalAdjectiveForm vadj =  new VerbalAdjectiveForm(Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR)
    assert vadj.getUrn().toString() == "urn:cite:gmorph:form.va000" 
  }
}
