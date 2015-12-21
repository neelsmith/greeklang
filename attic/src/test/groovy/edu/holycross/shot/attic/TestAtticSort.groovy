package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestAtticSort{
  def alphabeticallyLater = 1
  def alphabeticallyEarlier = -1
  def alphabeticallyEqual = 0

  @Test
  void testSorting() {
    // When two words match for every char,
    // but one word keeps going, the short
    // word sorts first.
    AtticString boleNom = new AtticString("BOLE")
    AtticString boleGen =   new AtticString("BOLES")
    assert boleNom.compareTo(boleGen) == alphabeticallyEarlier

    // sorting follows logic of Attic alphabet, not Unicode:
    AtticString theos = new AtticString("QEOS")
    AtticString kerugma = new AtticString("KERUGMA")
    assert theos.compareTo(kerugma) == alphabeticallyEarlier

  }

}
