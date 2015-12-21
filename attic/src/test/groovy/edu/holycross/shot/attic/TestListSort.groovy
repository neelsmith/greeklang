package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestListSort {
  def alphabeticallyLater = 1
  def alphabeticallyEarlier = -1
  def alphabeticallyEqual = 0


    @Test
    void testSort() {
      // Comparable interface supports sorting lists:
      def unsortedWords = [
        new AtticString("QEOS"),
        new AtticString("KERUGMA"),
        new AtticString("BOLE")
      ]

      ArrayList expectedWordOrder = [
        new AtticString("BOLE"),
        new AtticString("QEOS"),
        new AtticString("KERUGMA")
      ]

      def sortedWords = unsortedWords.sort()


      sortedWords.sort().eachWithIndex { w, i ->
          //println "${i}: ${w.toString()}"
          AtticString expectedString = expectedWordOrder[i]
          assert w.toString() ==  expectedString.toString()
      }
  }
}
