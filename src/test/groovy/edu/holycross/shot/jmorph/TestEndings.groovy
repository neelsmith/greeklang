package edu.holycross.shot.jmorph

//import edu.holycross.shot.greekutils

import static org.junit.Assert.*
import org.junit.Test


class TestEndings extends GroovyTestCase {


  String formSet = "decl2"
  ArrayList requestedForm = ":plural::::feminine:accusative::noun".split(/:/)
  String expectedEnding = "ous"

  void testLoad() {
    File endingsFile  = new File("testdata/morph/endings.csv")

    /*
    MorphEndings endings = new MorphEndings(endingsFile)
    assert endings

    String actualEnding
    endings.endingsDb.eachRow("select * from endings where formset = '" + formSet + "'") { r ->
      ArrayList checkForm = r.form.split(/:/)
      if ((MorphForm.getCase(requestedForm) == MorphForm.getCase(checkForm)) && (MorphForm.getNumber(requestedForm) == MorphForm.getNumber(checkForm)) ) {
	if ((MorphForm.getGender(requestedForm) == MorphForm.getGender(checkForm)) || (MorphForm.getGender(checkForm) == null)) {
	  actualEnding = r.ending
	}
      }
    }
    assert expectedEnding == actualEnding
    */
  }


}