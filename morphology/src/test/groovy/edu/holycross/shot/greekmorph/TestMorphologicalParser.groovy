package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestMorphologicalParser {



  String fstBinary = "build/fst/morphology.a"
  MorphologicalParser mp = new MorphologicalParser(fstBinary)


  @Test
  void testMorphologicalParser() {
    GreekString s1 = new GreekString("λύω", "Unicode")
    
    mp.parseGreekString(s1)
  }
}
