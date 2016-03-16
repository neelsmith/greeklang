package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFstAPIndecl{


@Test
void testParser() {
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
    UrnManager umgr = new UrnManager(urnReg)
  umgr.addCsvFile(urnReg)
  String indecl = "<u>smyth.n51951_0</u><u>lexent.n51951</u>kai/<conjunct>::<conjunct><indecl><u>indeclinfl.2</u>"
  FstAnalysisParser fap = new FstAnalysisParser(indecl, umgr)


    // Analysis type, lexical entity, and form:
    assert fap.analysisPattern == AnalyticalType.INDECLINABLE
    assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n51951"
    MorphForm mf = fap.getMorphForm()

    assert mf.toString() == "indeclinable form: indeclinable"

    assert fap.explanation.stem.toString() == "urn:cite:gmorph:smyth.n51951_0"
    assert fap.explanation.inflection.toString() == "urn:cite:gmorph:indeclinfl.2"
  

/*
  // What should these do for indeclinable?
  //assert fap.getSurfaceInflection() == "ou"
  assert fap.getSurface() == "dwr-ou"
  fap.getSurface()
*/
}
}
