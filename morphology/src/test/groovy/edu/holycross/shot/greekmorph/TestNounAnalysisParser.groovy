package edu.holycross.shot.greekmorph

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestNounAnalysisParser {

  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  UrnManager umgr = new UrnManager(inflCsvSource)

  @Test
  void testParser() {
    // defines coretests collection:
    File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
    umgr.addCsvFile(lexCsvSource)
    String noun = "<u>coretests.n67485_0</u><u>lexent.n67485</u>mhn<noun><fem><is_ios>::<u>nouninfl.is_ios1</u><is_ios>is<fem><nom><sg>"


    FstAnalysisParser fap = new FstAnalysisParser(noun, umgr)


    // Analysis type, lexical entity and form:
    assert fap.analysisPattern == AnalyticalType.NOUN
    assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n67485"
    MorphForm mf = fap.getMorphForm()
    assert mf.toString() == "noun: feminine nominative singular"

    // Explanations for analysis:
    assert fap.explanation.stem.toString() ==  "urn:cite:gmorph:coretests.n67485_0"
    assert fap.explanation.inflection.toString() ==  "urn:cite:gmorph:nouninfl.is_ios1"

    // Surface representation of stem-ending
    assert fap.getSurfaceStem() == "mhn"
    assert fap.getSurfaceInflection() == "is"
    assert fap.getSurface() == "mhn-is"


  }

}
