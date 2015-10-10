package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestVerbForm {

  @Test
  void testVerbForm () {
    VerbForm verb =  new VerbForm(Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.INDICATIVE, Voice.ACTIVE)
    assert verb.toString() == "first person singular present indicative active"
  }

  @Test
  void testUrns () {
    VerbForm verb =  new VerbForm(Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.INDICATIVE, Voice.ACTIVE)
    assert verb.getUrn().toString() == "urn:cite:morph:form.cv00000" 
  }
}
