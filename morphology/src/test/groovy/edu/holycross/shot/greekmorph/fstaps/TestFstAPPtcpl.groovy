package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFstAPPtcpl {
//

File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
UrnManager umgr = new UrnManager(inflCsvSource)

@Test
void testParser() {
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  umgr.addCsvFile(urnReg)
  String verb = "<u>smyth.n64316_0</u><u>lexent.n64316</u>lu<lo><verb><w_regular>::<w_regular><ptcpl>wn<masc><nom><sg><pres><act><u>verbinfl.w_pres_ptcp1</u> "

  FstAnalysisParser fap = new FstAnalysisParser(verb, umgr)


  // Analysis type, lexical entity, and form:
  assert fap.analysisPattern == AnalyticalType.PARTICIPLE
  assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n64316"

  assert  fap.explanation.stem.toString() == "urn:cite:gmorph:smyth.n64316_0"
  assert fap.explanation.inflection.toString() == "urn:cite:gmorph:verbinfl.w_pres_ptcp1"
  assert fap.getSurfaceStem() == "lu"
  assert fap.getSurfaceInflection() == "wn"
  assert fap.getSurface() == "lu-wn"

  MorphForm mf = fap.getMorphForm()
  mf.toString() == "participle: present active masculine nominative singular"

}

}
