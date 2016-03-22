package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFstAPIrregNoun {

  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  UrnManager umgr = new UrnManager(inflCsvSource)

  @Test
  void testParser() {
    File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
    umgr.addCsvFile(urnReg)
    String irreg = "<u>smyth.n23069_0</u><u>lexent.n23069</u>gunaiko/s<fem><gen><sg><irregnoun>::<irregnoun><noun><u>irreginfl.1</u>"
    FstAnalysisParser fap = new FstAnalysisParser(irreg, umgr)

    assert fap.analysisPattern == AnalyticalType.NOUN
    assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n23069"
    assert fap.explanation.stem.toString() == "urn:cite:gmorph:smyth.n23069_0"
    assert fap.explanation.inflection.toString() == "urn:cite:gmorph:irreginfl.1"
    System.err.println "Surface stem: " + fap.getSurfaceStem()
    System.err.println  "inflection: " +  fap.getSurfaceInflection()
    System.err.println "Surface: " +  fap.getSurface()

    MorphForm mf = fap.getMorphForm()
    assert mf.toString() == "noun: feminine genitive singular"
  }

}
