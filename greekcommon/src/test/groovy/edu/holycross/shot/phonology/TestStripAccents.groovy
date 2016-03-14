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

}
