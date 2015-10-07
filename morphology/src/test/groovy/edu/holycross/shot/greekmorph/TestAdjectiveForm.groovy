package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestAdjectiveForm {

  @Test
  void testAdjectiveForm () {
    AdjectiveForm adj =  new AdjectiveForm(Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Degree.POSITIVE)
    assert adj.toString() == "masculine nominative singular positive"
  }

}
