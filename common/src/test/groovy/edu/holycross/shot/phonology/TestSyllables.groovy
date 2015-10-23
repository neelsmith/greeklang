package edu.holycross.shot.phonology


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord

class TestSyllables {

  // map of input strings to expected values
  def testMap = [
  "poios"  : "poi#os",
  "o)i+w" : " o)#i+#w",
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
    "a)u+th" : "a)#u+#th"
  ]

  @Test
  void testSyllables() {
    testMap.each { m ->
      if (Syllable.getSyllablicString(m.key) != m.value) {
        System.err.println "Failed on ${m.value.toString()} : got " + Syllable.getSyllablicString(m.key)
      }
    }
  }
}
