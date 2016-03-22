package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFstAPAdv {

  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  UrnManager umgr = new UrnManager(inflCsvSource)


@Test
void testParser() {
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  umgr.addCsvFile(urnReg)
  String adv = "<u>smyth.n260_0</u><u>lexent.n260</u>a<sm>gaq<adj><os_h_on><inflacc>::<os_h_on><adv>ws<pos><u>advinfl.os_h_on1</u>"



  FstAnalysisParser fap = new FstAnalysisParser(adv, umgr)


  // Analysis type, lexical entity, and form:
  assert fap.analysisPattern == AnalyticalType.ADVERB
  assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n260"

  assert fap.explanation.stem.toString() == "urn:cite:gmorph:smyth.n260_0"
  assert fap.explanation.inflection.toString() == "urn:cite:gmorph:advinfl.os_h_on1"
  assert fap.getSurfaceStem() == "a)gaq"
  assert fap.getSurfaceInflection() == "ws"
  assert fap.getSurface() == "a)gaq-ws"


  MorphForm mf = fap.getMorphForm()
  assert mf.toString() == "adverb: positive"

}

}
