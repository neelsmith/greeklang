package edu.holycross.shot.phonology

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestAccentEnumeration {




    @Test
    void testAdd() {
      def accPatt = AccentPattern.RECESSIVE
      accPatt++
      assert accPatt == AccentPattern.PENULT
      accPatt++
      assert accPatt == AccentPattern.ULTIMA
    }
}
