package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestMorphologicalParser {



  String fstBinary = "build/fst/greek.a"
  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  UrnManager umgr = new UrnManager(inflCsvSource)

  @Test
  void testMorphologicalParser() {

    // defines coretests collection:
    File lexCsvSource = new File("sampledata/userconfig/extraDatasets.csv")
    umgr.addCsvFile(lexCsvSource)
    MorphologicalParser mp = new MorphologicalParser(fstBinary, umgr)


    GreekString s1 = new GreekString("λύω", "Unicode")
    MorphologicalAnalysis morph = mp.parseGreekString(s1)

    def expectedAnalyses = [
    "conjugated verb: first person singular present indicative active",
    "conjugated verb: first person singular present subjunctive active",
    "conjugated verb: first person singular perfect subjunctive active"
    ]
    assert morph.analyses.size() == expectedAnalyses.size()
    morph.analyses.each {
      assert expectedAnalyses.contains(it.toString())
    }
  }
}
