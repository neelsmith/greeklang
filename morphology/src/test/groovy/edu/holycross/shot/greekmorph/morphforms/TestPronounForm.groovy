package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestPronounForm {

  @Test
  void testPronounForm () {
    PronounForm pron =  new PronounForm(Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, PersistentAccent.INFLECTIONAL_ENDING)
    assert pron.toString() == "masculine nominative singular"
  }


  @Test
  void testUrns() {
    PronounForm pron =  new PronounForm(Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, PersistentAccent.INFLECTIONAL_ENDING)
    assert pron.getUrn().toString() == "urn:cite:gmorph:form.pn000"
  }
}
