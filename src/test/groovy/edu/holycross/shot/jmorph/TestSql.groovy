package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test

import edu.harvard.chs.cite.CiteUrn

class TestSql extends GroovyTestCase {


  File stemsFile  = new File("testdata/morph/morphstems.csv")
  File endingsFile  = new File("testdata/morph/endings.csv")
  File stemTypesFile = new File("testdata/morph/stemtypes.csv")
  File inflClassFile = new File("testdata/morph/inflclass.csv")


  CiteUrn logos = new CiteUrn("urn:cite:perseus:lexentity.lex41535.1")

  void testLoad() {
    MorphSql msql = new MorphSql(stemsFile, endingsFile, stemTypesFile, inflClassFile)
    assert msql

   ArrayList endingList = msql.endingsForLexEnt(logos)
   println "Test gets list w " + endingList.size() + " endings"
   endingList.each {
     println it
   }


    
    // GET ALL ENDINGS AND FORM FILTERS, LABELLED BY INFLCLASS FOR A LEX ENT:

    // select ic.label, e.ending, e.form  FROM morphstem m, endings e, stemtype st, inflclass ic
    // WHERE m.stemclass =  st.urn AND st.inflclass = ic.urn AND st.inflclass = e.formset
    // AND m.lexurn = 'LEXURNVALUE'

    // TO GENERATE:
    // morphstem's lexurn is vocab item :  that gets you stemclass
    // stemclass gets you inflclass
    // inflclass gets you endings
    // endings get you a filter to check
    
  }



}