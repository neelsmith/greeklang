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
    assert fap.analysisPattern == AnalyticalType.NOUN
    /*
    assert fap.explanation.stem.toString() ==  "urn:cite:gmorph:coretests.n64316_0"
    assert fap.explanation.inflection.toString() ==  "urn:cite:gmorph:w_indicative.1"
    assert fap.lexicalEntity.toString() == "urn:cite:shot:lexent.n64316"

    MorphForm mf = fap.getMorphForm()
    assert mf.toString() == "conjugated verb: first person singular present indicative active"


    assert fap.getSurfaceStem() == "<#>lu"
    assert fap.getSurfaceInflection() == "w"
    assert fap.getSurface() == "lu-w"
*/
  }

}
