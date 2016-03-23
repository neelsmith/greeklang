package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestIndeclinableForm {

  @Test
  void testIndeclForm () {
  IndeclinableForm indecl =  new IndeclinableForm()
  assert indecl.toString() == "indeclinable"
  assert indecl.getUrn().toString() == "urn:cite:gmorph:form.indeclinable"
  }
}
