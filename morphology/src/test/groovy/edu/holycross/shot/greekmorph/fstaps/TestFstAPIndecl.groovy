package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFstAPIndecl{


@Test
void testParser() {
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
    UrnManager umgr = new UrnManager(urnReg)
  umgr.addCsvFile(urnReg)
  String indecl = "<u>smythpool.n51951_0</u><u>lexent.n51951</u>kai/<conjunct>::<conjunct><u>indeclinfl.2</u>"
  FstAnalysisParser fap = new FstAnalysisParser(indecl, umgr)


    // Analysis type, lexical entity, and form:
    assert fap.analysisPattern == AnalyticalType.INDECLINABLE
    assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n51951"
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
