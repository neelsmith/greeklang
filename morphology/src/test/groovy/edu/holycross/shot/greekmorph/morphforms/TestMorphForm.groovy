package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestMorphForm {

  @Test
  void testMorphForm () {
    AdverbForm adv =  new AdverbForm(Degree.POSITIVE)
    MorphForm mf = new MorphForm(AnalyticalType.ADVERB, adv)
    assert mf.getAnalysis() == adv
    String notOk = "Raw string"
    assert shouldFail {
      MorphForm badForm = new MorphForm(notOk)
    }
  }

  @Test
  void testUrns() {
    AdverbForm advForm =  new AdverbForm(Degree.POSITIVE)
    MorphForm mf = new MorphForm(AnalyticalType.ADVERB, advForm)
    assert mf.urnForForm().toString() == "urn:cite:morph:form.av0"
  }

}
