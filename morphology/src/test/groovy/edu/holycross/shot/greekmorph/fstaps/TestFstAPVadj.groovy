package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFstAPVadj{
// <u>smyth.n64316_0</u><u>lexent.n64316</u>lu<lo><verb><w_regular>::<w_regular>te/os<masc><nom><sg><vadj1><u>verbinfl.teos_1</u>
  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  UrnManager umgr = new UrnManager(inflCsvSource)

  @Test
  void testParser() {
    File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
    umgr.addCsvFile(urnReg)
    String verb = "<u>smyth.n64316_0</u><u>lexent.n64316</u>lu<lo><verb><w_regular>::<w_regular><vadj>te/os<masc><nom><sg><vadj1><u>verbinfl.teos_1</u>"

    FstAnalysisParser fap = new FstAnalysisParser(verb, umgr)


    // Analysis type, lexical entity, and form:
    assert fap.analysisPattern == AnalyticalType.VERBAL_ADJECTIVE
    assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n64316"

    System.err.println "Explanations,"
    System.err.println "stem: " +   fap.explanation.stem.toString()
    System.err.println "inflection: " +   fap.explanation.inflection.toString()
    System.err.println "Surf stem: " + fap.getSurfaceStem()
    System.err.println "Surf infl: " + fap.getSurfaceInflection()
    System.err.println "Surface: " + fap.getSurface()

    MorphForm mf = fap.getMorphForm()
    System.err.println "morphform: " + mf.toString()
    
    //assert mf.toString() == "verb: first plural present indicative active"

/*
    // Explanations for analysis:
    assert fap.explanation.stem.toString() ==  "urn:cite:gmorph:smyth.n29828_0"
    assert fap.explanation.inflection.toString() ==  "urn:cite:gmorph:nouninfl.os_ou2n"

    // Surface representation of stem-ending
    assert fap.getSurfaceStem() == "dwr"
    assert fap.getSurfaceInflection() == "ou"
    assert fap.getSurface() == "dwr-ou"
*/

  }
}
