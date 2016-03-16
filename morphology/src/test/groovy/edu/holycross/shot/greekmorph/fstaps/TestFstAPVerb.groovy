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

      // use 3rd pl pres ind act...
      String verb = "<u>smyth.n64316_0</u><u>lexent.n64316</u>lu<lo><verb><w_regular>::<w_regular><verb>ousi<3rd><plf><pres><indic><act><u>verbinfl\.w\_pres\_indic8</u>"

      FstAnalysisParser fap = new FstAnalysisParser(verb, umgr)


      // Analysis type, lexical entity, and form:
      assert fap.analysisPattern == AnalyticalType.CVERB
      assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n64316"
      assert fap.explanation.stem.toString() == "urn:cite:gmorph:smyth"
        System.err.println "inflection: " +   fap.explanation.inflection.toString() == "urn:cite:gmorph:verbinfl.w_pres_indic8"
        assert fap.getSurfaceStem() == "lu"
        assert fap.getSurfaceInflection() == "ousi"
        assert fap.getSurface() == "lu-ousi"
        MorphForm mf = fap.getMorphForm()
        assert mf.toString() == "conjugated verb: third person plural present indicative active"

    }
}
