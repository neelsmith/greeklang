package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestFstAPNoun {

  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  UrnManager umgr = new UrnManager(inflCsvSource)

  @Test
  void testParser() {
    File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
    umgr.addCsvFile(urnReg)
    String noun = "<u>smyth.n29828_0</u><u>lexent.n29828</u>dwr<noun><neut><os_ou><stempenacc>::<os_ou><u>nouninfl.os_ou2n</u>ou<neut><gen><sg>"

    FstAnalysisParser fap = new FstAnalysisParser(noun, umgr)


    // Analysis type, lexical entity, and form:
    assert fap.analysisPattern == AnalyticalType.NOUN
    assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n29828"
    MorphForm mf = fap.getMorphForm()
    assert mf.toString() == "noun: neuter genitive singular"


    // Explanations for analysis:
    assert fap.explanation.stem.toString() ==  "urn:cite:gmorph:smyth.n29828_0"
    assert fap.explanation.inflection.toString() ==  "urn:cite:gmorph:nouninfl.os_ou2n"

    // Surface representation of stem-ending
    assert fap.getSurfaceStem() == "dwr"
    assert fap.getSurfaceInflection() == "ou"
    assert fap.getSurface() == "dwr-ou"


  }

}
