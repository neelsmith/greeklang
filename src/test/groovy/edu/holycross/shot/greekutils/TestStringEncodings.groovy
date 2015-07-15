package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestStringEncodings extends GroovyTestCase {



  void testUnicode() {
    String testUnicode = "μῆνιν"
    String testBeta = "mh=nin"

    GreekString uniGreek = new GreekString(testUnicode, "Unicode")
    GreekString betaGreek = new GreekString(testBeta)

    assert uniGreek.toString() == betaGreek.toString()
  }

  void testLimits() {
    String notGreek = "αλφα = 1"

    assert shouldFail {
      GreekString badString = new GreekString(notGreek, "Unicode")
      System.err.println "Got badString " + badString
    }

  }



}