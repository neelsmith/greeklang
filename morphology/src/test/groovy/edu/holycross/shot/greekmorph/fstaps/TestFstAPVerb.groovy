package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFstAPVerb {

    File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
    UrnManager umgr = new UrnManager(inflCsvSource)

    @Test
    void testParser() {
      File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
      umgr.addCsvFile(urnReg)
      String verb = "<u>smyth.n64316_0</u><u>lexent.n64316</u>lu<lo><verb><w_regular>::<w_regular>omen<1st><pl><pres><indic><act><u>verbinfl.w_pres_indic6</u>"

      FstAnalysisParser fap = new FstAnalysisParser(verb, umgr)


      // Analysis type, lexical entity, and form:
      assert fap.analysisPattern == AnalyticalType.CVERB
      assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n64316"
      MorphForm mf = fap.getMorphForm()
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
