package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFstAPPronoun {

  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  UrnManager umgr = new UrnManager(inflCsvSource)


@Test
void testParser() {
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  umgr.addCsvFile(urnReg)
  String pron = "<u>smyth.n71882_00</u><u>lexent.n71882</u>t<pron><os_h_on><inflacc>::<os_h_on><adj>ou<masc><gen><sg><pos><u>adjinfl.os_h_on2</u>"

  FstAnalysisParser fap = new FstAnalysisParser(pron, umgr)


  // Analysis type, lexical entity, and form:
  assert fap.analysisPattern == AnalyticalType.PRONOUN
  assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n71882"

  assert fap.explanation.stem.toString() == "urn:cite:gmorph:smyth.n71882_00"
  assert fap.explanation.inflection.toString() == "urn:cite:gmorph:adjinfl.os_h_on2"
  assert fap.getSurfaceStem() == "t"
  assert fap.getSurfaceInflection() == "ou"
  assert fap.getSurface() == "t-ou"


  MorphForm mf = fap.getMorphForm()
  assert mf.toString() == "pronoun: masculine genitive singular"

}

}
