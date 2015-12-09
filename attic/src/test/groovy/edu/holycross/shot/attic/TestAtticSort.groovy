package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestAtticSort{

  @Test
  void testSorting() {
    // When two words match for every char,
    // but one word keeps going, the short
    // word sorts first.
    assert (new AtticString("BOLE") < new AtticString("BOLES"))
    // sorting follows logic of Attic alphabet, not Unicode:
    assert (new AtticString("QEOS") < new AtticString("KERUGMA"))
  }


    @Test
    void testSort() {
      // Comparable interface supports sorting lists:
      def unsortedWords = [
        new AtticString("QEOS"),
        new AtticString("KERUGMA"),
        new AtticString("BOLE")
      ]

      def sortedWords = [
        new AtticString("BOLE"),
        new AtticString("QEOS"),
        new   AtticString("KERUGMA")
      ]

      assert sortedWords == unsortedWords.sort()

  }
}
