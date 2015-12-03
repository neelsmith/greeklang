package edu.holycross.shot.phonology

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestAtticSyllables {
  // map of test strings to expected syllable breaks
  // marked by pound sign.
  // Test strings are ASCII transcription after accent
  // has been stripped out.
  def testMap = [
  "HODOS": "HO#DOS",
  "EDOXSEN" : "E#DO#XSEN",
  "DEMOI": "DE#MOI",
  "MISQOMENON": "MI#SQO#ME#NON",
  "HOUTOS": "HOU#TOS",
  "AEI": "A#EI",
  "PRATTEN": "PRAT#TEN",
  "AMF'": "AMF'",
  //"ANALU_W": "A#NA#LU_#W",
  "KELEUOSI": "KE#LEU#O#SI",
  "AQENAIOS": "A#QE#NAI#OS",
  "XSUMBOLON": "XSUM#BO#LON",
  "EPIDIKAZETO": "E#PI#DI#KA#ZE#TO",
  "PENTEKONTA": "PEN#TE#KON#TA",
  "GNOSQEI": "GNO#SQEI",
  //"EPIOFSASQAI": "E#PI#O#FSA#SQAI",
  "HUPOSXOMENOS": "HU#PO#SXO#ME#NOS",
  //"XSUNDIAQESEN": "XSUN#DI#A#QE#SEN",
  "DOULON": "DOU#LON",
  //"ARXONTOS": "AR#XON#TOS",
  //"HIEROPOIOS":"HI#E#RO#POI#OS",
  "METAGEITNIONOS": "ME#TA#GEIT#NI#O#NOS"







  /*
  "poios"  : "poi#os",


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
  "a)nalu_w": "a)#na#lu_#w"
  */
  ]

  @Test
  void testSyllables() {
    testMap.each { m ->
      assert AtticSyllable.getSyllablicString(m.key) == m.value
    }
  }
}
