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
    assert verb.getUrn().toString() == "urn:cite:gmorph:form.cv00000"
  }

  @Test
  void testAltConstructor () {
    def data = [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.INDICATIVE, Voice.ACTIVE]
    VerbForm verb =  new VerbForm(data)
    assert verb.toString() == "first person singular present indicative active"
  }


  @Test
  void testEquality () {
    def data = [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.INDICATIVE, Voice.ACTIVE]
    VerbForm verb1 =  new VerbForm(data)
    assert verb1.toString() == "first person singular present indicative active"
    VerbForm verb2 =  new VerbForm(Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.INDICATIVE, Voice.ACTIVE)

    assert verb1.equals(verb2)
  }



}
