package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestParadigm extends GroovyTestCase {


  

  void testNoun() {
    MorphForm.GrammaticalCase.each { c ->
      MorphForm.GrammaticalNumber.each { num ->
	if (num == MorphForm.GrammaticalNumber.DUAL) {
	  // skip
	} else {
	  print "${c}.${num}/"
	}
      }
      println ""
    }
  }


}