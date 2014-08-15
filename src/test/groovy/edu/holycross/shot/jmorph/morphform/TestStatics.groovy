package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestStatics extends GroovyTestCase {


  

  void testGetters() {

    def formArray = ["","singular","","","","masculine","nominative","","noun"]
    assert MorphForm.getCase(formArray) == "nominative"
    assert MorphForm.getNumber(formArray) == "singular"
    assert MorphForm.getGender(formArray) == "masculine"
    assert MorphForm.getPos(formArray) == "noun"


    def verbArray = ["first","singular","present","indicative","active","","","","verb"]
    assert MorphForm.getPerson(verbArray) == "first"
    assert MorphForm.getNumber(verbArray) == "singular"
    assert MorphForm.getTense(verbArray) == "present"
    assert MorphForm.getMood(verbArray) == "indicative"
    assert MorphForm.getVoice(verbArray) == "active"
    assert MorphForm.getPos(verbArray) ==  "verb"


    def ptcplArray = ["","singular","present","participle","active","masculine","nominative","","verb"]
    assert MorphForm.getTense(ptcplArray) == "present"
    assert MorphForm.getMood(ptcplArray) == "participle"
    assert MorphForm.getVoice(ptcplArray) == "active"
    assert MorphForm.getGender(ptcplArray) == "masculine"
    assert MorphForm.getCase(ptcplArray) == "nominative"
    assert MorphForm.getNumber(ptcplArray) == "singular"
    assert MorphForm.getPos(ptcplArray) ==  "verb"

  }


}