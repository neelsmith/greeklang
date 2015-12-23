package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

//<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>

class TestAnalysisParser {

  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  UrnManager umgr = new UrnManager(inflCsvSource)

/*
  @Test
  void testParser() {
    // defines coretests collection:
    File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
    umgr.addCsvFile(lexCsvSource)
    String conjverb = "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"


    FstAnalysisParser fap = new FstAnalysisParser(conjverb, umgr)

    ////assert fap.analysisPattern == AnalyticalType.CVERB
    //assert fap.explanation.stem.toString() ==  "urn:cite:gmorph:coretests.n64316_0"
    //assert fap.explanation.inflection.toString() ==  "urn:cite:gmorph:w_indicative.1"
    //assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n64316"

    MorphForm mf = fap.getMorphForm()
    //assert mf.toString() == "conjugated verb: first person singular present indicative active"


    //assert fap.getSurfaceStem() == "<#>lu"
    //assert fap.getSurfaceInflection() == "w"
    //assert fap.getSurface() == "lu-w"

  }

  @Test
  void testCompound() {
    File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
    umgr.addCsvFile(lexCsvSource)
    String conjverb = "<coretests.n6949_0><lexent.n6949>a<sm>na<#>lus<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
    FstAnalysisParser fap = new FstAnalysisParser(conjverb, umgr)
    //assert fap.analysisPattern == AnalyticalType.CVERB



    //assert fap.explanation.stem.toString() ==  "urn:cite:gmorph:coretests.n6949_0"
    //assert fap.explanation.inflection.toString() ==  "urn:cite:gmorph:w_indicative.1"
    //assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n6949"

    MorphForm mf = fap.getMorphForm()
    //assert mf.toString() == "conjugated verb: first person singular present indicative active"


    //assert fap.getSurfaceStem() == "ana<#>lus"
    //assert fap.getSurfaceInflection() == "w"
    //assert fap.getSurface() == "analus-w"

  }*/
}
