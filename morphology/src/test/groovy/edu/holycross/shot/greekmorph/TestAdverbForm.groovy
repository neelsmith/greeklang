package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestAdverbForm {

  @Test
  void testAdverbForm () {
    AdverbForm adv =  new AdverbForm(Degree.POSITIVE)
    assert adv.toString() == "positive"
  }


  @Test
  void testUrns() {
    AdverbForm pos =  new AdverbForm(Degree.POSITIVE)
    String expectedPositive = "urn:cite:morph:form.av0"
    assert pos.getUrn().toString() == expectedPositive

    AdverbForm comp =  new AdverbForm(Degree.COMPARATIVE)
    String expectedComparative = "urn:cite:morph:form.av1"
    assert comp.getUrn().toString() == expectedComparative

    AdverbForm sup =  new AdverbForm(Degree.SUPERLATIVE)
    String expectedSuperlative = "urn:cite:morph:form.av2"
    assert sup.getUrn().toString() == expectedSuperlative
  }
}
