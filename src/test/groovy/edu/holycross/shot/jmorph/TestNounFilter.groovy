package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestNounFilter extends GroovyTestCase {


  // fully specified forms:
  def masc_nom_s = ["","singular","","","","masculine","nominative","","noun"]
  def fem_nom_s = ["","singular","","","","feminine","nominative","","noun"]


  // filters:
  def any_nom_s = ["","singular","","","","","nominative","","noun"]
  def any_masc =  ["","","","","","masculine","","","noun"]
  
  void testNoun() {
    assert MorphForm.getCase(masc_nom_s) == "nominative"
    assert MorphForm.getNumber(masc_nom_s) == "singular"
    assert MorphForm.getGender(masc_nom_s) == "masculine"
    assert MorphForm.getPos(masc_nom_s) == "noun"

    assert MorphForm.getCase(fem_nom_s) == "nominative"
    assert MorphForm.getNumber(fem_nom_s) == "singular"
    assert MorphForm.getGender(fem_nom_s) == "feminine"
    assert MorphForm.getPos(fem_nom_s) == "noun"


    def formsList = [masc_nom_s, fem_nom_s]


    println "Filter list for any masc:"
    println NounFilter.filterList(formsList, any_masc)

    println "Filter list for any nom.s.:"
    println NounFilter.filterList(formsList, any_nom_s)
    
  }


}