package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFstAPIndecl{

  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  umgr.addCsvFile(urnReg)
  String indecl = "<u>smythpool.n51951_0</u><u>lexent.n51951</u>kai/<conjunct>::<conjunct><u>indeclinfl.2</u>"

  FstAnalysisParser fap = new FstAnalysisParser(indecl, umgr)


  // Analysis type, lexical entity, and form:
  assert fap.analysisPattern == AnalyticalType.INDECLINABLE
  assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n51951"
  MorphForm mf = fap.getMorphForm()
}
