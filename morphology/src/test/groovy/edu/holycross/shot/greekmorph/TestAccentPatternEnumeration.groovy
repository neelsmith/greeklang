package edu.holycross.shot.morphology

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestAccentPatternEnumeration {




    @Test
    void testAdd() {
      def accPatt = PersistentAccent.STEM_ULTIMA
      accPatt++
      assert accPatt == AccentPattern.STEM_PENULT
      accPatt++
      assert accPatt == AccentPattern.INFLECTIONAL_ENDING
    }
}
