package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestVerbalAdjectiveForm {

  @Test
  void testVerbalAdjectiveForm () {
    VerbalAdjectiveForm vadj =  new VerbalAdjectiveForm(Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR)
    assert vadj.toString() == "masculine nominative singular"
  }

}
