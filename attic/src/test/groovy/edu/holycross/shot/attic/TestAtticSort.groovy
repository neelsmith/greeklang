package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestAtticSort{

  @Test
  void testSorting() {

          // When two words match for every char,
          // but one word keeps going, the short
          // word sorts first.
      assert (new AtticString("LEGE") < new AtticString("LEGETE"))

      assert (new AtticString("QEOS") < new AtticString("KERUGMA"))
    }

    @Test
    void testSort() {
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
