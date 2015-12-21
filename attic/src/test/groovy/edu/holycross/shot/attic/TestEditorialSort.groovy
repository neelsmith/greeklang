package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestEditorialSort{

  def alphabeticallyLater = 1
  def alphabeticallyEarlier = -1
  def alphabeticallyEqual = 0

  @Test
  void testQuantSort() {
    AtticString bole =  new AtticString("BOLE")
    AtticString bolelong = new AtticString("BOLE_")


    assert bole.compareTo(bolelong) == alphabeticallyEqual
  
  }


}
