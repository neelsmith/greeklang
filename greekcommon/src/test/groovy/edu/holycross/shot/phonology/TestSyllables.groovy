package edu.holycross.shot.phonology

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekString

class TestSyllables {
  // map of test strings to expected syllable breaks
  // marked by pound sign.
  // Test strings are ASCII transcription after accent
  // has been stripped out.
  def testMap = [
  "poios"  : "poi#os",
  "o)i+w" : "o)#i+#w",
  "pwu+" : "pw#u+",
  "oi)w" : "oi)#w",
  "limnh" : "li#mnh",
  "a)nqos" : "a)n#qos",
  "e)lpis" : "e)l#pis",
  "e)rgma" : "e)r#gma",
  "a)ei" : "a)#ei",
  "dia" : "di#a",
  "die" : "di#e",
  "eu)+" : "e#u)+",
  "r(ea" : "r(e#a",
  "pragma" : "pra#gma",
  "sui+" : "su#i+",
  "tiw" :  "ti#w",
  "r(a" : "r(a",
  "oi(o" : "oi(#o",
  "a)asamhn": "a)#a#sa#mhn",
  "e)u+" : "e)#u+",
  "ou(tos" : "ou(#tos",
  "dw|h" : "dw|#h",
  "eu+n" : "e#u+n",
  "a)ll'": "a)ll'",
  "a)mf'" : "a)mf'",
  "e)aa|" : "e)#a#a|",
  "h)u+s" : "h)#u+s",
  "h)i+e" : "h)#i+#e",
  "kien" : "ki#en",
  "kion" : "ki#on",
  "ui(ei+" : "ui(#e#i+",
  "xiwn"  : "xi#wn",
  "a)u+th" : "a)#u+#th",
  "lu_e" : "lu_#e",
  "a)nalu_w": "a)#na#lu_#w",
  "is" : "is",
  "ios" : "i#os",
  "ni_ke": "ni_#ke"
  ]

  @Test
  void testSyllables() {
    testMap.each { m ->
      assert Syllable.getSyllablicString(m.key) == m.value
    }
  }



  @Test
  void testGreekStringSyllables() {
    testMap.each { m ->
      GreekString gs = new GreekString(m.key)
      def gsSyllables = Syllable.getSyllables(gs)
      System.err.println "For gs ${gs}, syllables ${gsSyllables}"
      assert gsSyllables.size() == m.value.split(/#/).size()
    }
  }
}
