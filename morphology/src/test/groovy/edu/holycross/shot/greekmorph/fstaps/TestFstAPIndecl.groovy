package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFstAPIndecl{

  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  umgr.addCsvFile(urnReg)
  String verb = "<u>smyth.n64316_0</u><u>lexent.n64316</u>lu<lo><verb><w_regular>::<w_regular>omen<1st><pl><pres><indic><act><u>verbinfl.w_pres_indic6</u>"

  FstAnalysisParser fap = new FstAnalysisParser(verb, umgr)


  // Analysis type, lexical entity, and form:
  assert fap.analysisPattern == AnalyticalType.CVERB
  assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n64316"
  MorphForm mf = fap.getMorphForm()
}
