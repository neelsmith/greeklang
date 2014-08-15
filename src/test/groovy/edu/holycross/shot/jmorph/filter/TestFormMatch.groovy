package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestFormMatch extends GroovyTestCase {


  // fully specified forms:
  ArrayList masc_nom_s = ["","singular","","","","masculine","nominative","","noun"]

  // filters:
  ArrayList any_nom_s = ["","singular","","","","","nominative","","noun"]
  ArrayList any_masc =  ["","","","","","masculine","","","noun"]
  
  void testMatch() {
    assert FormFilter.formMatches(masc_nom_s, any_nom_s)
    assert FormFilter.formMatches(masc_nom_s, any_masc)
    
  }


}