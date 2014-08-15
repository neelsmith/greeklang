package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestFormArray extends GroovyTestCase {


  

  void testGetters() {
    String formStr = "first:singular:present:indicative:active::::verb"
    MorphForm mf = new MorphForm(formStr)


    def formArray = ["","singular","","","","masculine","nominative","","noun"]
    assert mf.getCase(formArray) == "nominative"
    assert mf.getNumber(formArray) == "singular"
    assert mf.getGender(formArray) == "masculine"
    assert mf.getPos(formArray) == "noun"


    def verbArray = ["first","singular","present","indicative","active","","","","verb"]
    assert mf.getPerson(verbArray) == "first"
    assert mf.getNumber(verbArray) == "singular"
    assert mf.getTense(verbArray) == "present"
    assert mf.getMood(verbArray) == "indicative"
    assert mf.getVoice(verbArray) == "active"
    assert mf.getPos(verbArray) ==  "verb"


    def ptcplArray = ["","singular","present","participle","active","masculine","nominative","","verb"]
    assert mf.getTense(ptcplArray) == "present"
    assert mf.getMood(ptcplArray) == "participle"
    assert mf.getVoice(ptcplArray) == "active"
    assert mf.getGender(ptcplArray) == "masculine"
    assert mf.getCase(ptcplArray) == "nominative"
    assert mf.getNumber(ptcplArray) == "singular"
    assert mf.getPos(ptcplArray) ==  "verb"

  }


}