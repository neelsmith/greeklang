package edu.holycross.shot.attic

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail




class TestAtticSyllables{

    def testMap = [
    "POIOS"  : "POI#OS",
    "LIMNE" : "LI#MNE",
    "ANQOS" : "AN#QOS",
    "ELPIS" : "EL#PIS",
    "ERGMA" : "ER#GMA",
    "AEI" : "A#EI",
    "DIA" : "DI#A",
    "PRAGMA" : "PRA#GMA",
    "TIO" :  "TI#O",
    "HOTOS" : "HO#TOS",
    "LU_E" : "LU_#E",
   "ANALU_O": "A#NA#LU_#O",
   "EDOXSEN": "E#DO#XSEN",
   "TEI": "TEI",
   "DE_MO^S" : "DE_#MO^S"
    ]

    @Test
    void testSyllables() {
      testMap.each { m ->
        assert AtticSyllable.getSyllablicString(m.key) == m.value
      }
    }

}
