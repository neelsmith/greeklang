package edu.holycross.shot.morphology

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString
import edu.holycross.shot.greekmorph.PersistentAccent

class TestAccentPatternEnumeration {




    @Test
    void testAdd() {
      def accPatt = PersistentAccent.STEM_PENULT
      accPatt++
      assert accPatt == PersistentAccent.STEM_ULTIMA
      accPatt++
      assert accPatt == PersistentAccent.INFLECTIONAL_ENDING
    }
}
