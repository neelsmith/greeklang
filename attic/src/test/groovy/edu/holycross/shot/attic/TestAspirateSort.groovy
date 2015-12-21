package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestAspirateSort{

  def alphabeticallyLater = 1
  def alphabeticallyEarlier = -1
  def alphabeticallyEqual = 0

  @Test
  void testAspirateSort() {
    AtticString apo =  new AtticString("APO")
    AtticString article = new AtticString("HAI")
    AtticString demonstr = new AtticString("HOTOS")

    assert apo.compareTo(article) == alphabeticallyLater
    assert article.compareTo(apo) == alphabeticallyEarlier
    assert demonstr.compareTo(article) == alphabeticallyLater
    assert demonstr.compareTo(apo) == alphabeticallyLater

  }


}
