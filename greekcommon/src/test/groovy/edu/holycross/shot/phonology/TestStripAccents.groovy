package edu.holycross.shot.phonology

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestStripAccents {

  @Test
  void testGkString() {
    GreekString s = new GreekString("mh=nin")
    GreekString stripped = Accent.stripAccents(s)

    assert stripped.toString() =="mhnin"

  }

  @Test
  void testAlreadyStripped() {
    GreekString s = new GreekString("mhnin")
    GreekString stripped = Accent.stripAccents(s)
    assert stripped.toString() =="mhnin"

    GreekString syllable = new GreekString("ios")
    GreekString syllStripped = Accent.stripAccents(syllable)
    assert syllStripped.toString() == "ios"
  }




    @Test
    void testRmExtras() {
      GreekString s = new GreekString("luo/meno/s")
      GreekString stripped = Accent.removeMultipleAccents(s)

      assert stripped.toString() =="luo/menos"

    }


        @Test
        void testFlip() {
          String grave = "λυὼν"
          GreekString s = new GreekString(grave, true)
          GreekString flipped = Accent.flipGrave(s)

          assert flipped.toString() =="luw/n"

        }



                @Test
                void testNormalize() {
                  String grave = "λυὼν"
                  GreekString s = new GreekString(grave, true)
                  GreekString flipped = Accent.normalizeAccent(s)
                  assert flipped.toString() =="luw/n"

                  GreekString enclitic = new GreekString("λυόμενός", true)
                  assert Accent.normalizeAccent(enclitic).toString() == "luo/menos"


                }
}
