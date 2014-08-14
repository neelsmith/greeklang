package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestArraySerial extends GroovyTestCase {




  
  void testSerialization() {
    def nounArray = ["","singular","","","","masculine","nominative","","noun"]
    def expectedNoun = ["SINGULAR","MASCULINE","NOMINATIVE","NOUN"]    
    MorphForm nounform = new MorphForm(nounArray)
    def nonnulls = []    
    nounform.toArrayOfString().each { s ->
      if (s) {
	nonnulls.add(s)
      }
    }
    assert nonnulls == expectedNoun


    def verbArray = ["first","singular","present","indicative","active","","","","verb"]
    def expectedVerb = ["FIRST", "SINGULAR", "PRESENT", "INDICATIVE","ACTIVE","VERB"]
    MorphForm vbform = new MorphForm(verbArray)
    nonnulls.clear()
    vbform.toArrayOfString().each { s ->
      if (s) {
	nonnulls.add(s)
      }
    }
    assert nonnulls == expectedVerb

    
    def ptcplArray = ["","singular","present","participle","active","masculine","nominative","","verb"]  
    def expectedPtcpl = ["SINGULAR", "PRESENT", "PARTICIPLE","ACTIVE","MASCULINE","NOMINATIVE","VERB"]
    MorphForm ptcplform = new MorphForm(ptcplArray)
    nonnulls.clear()
    ptcplform.toArrayOfString().each { s ->
      if (s) {
	nonnulls.add(s)
      }
    }
    assert nonnulls == expectedPtcpl
  }


}