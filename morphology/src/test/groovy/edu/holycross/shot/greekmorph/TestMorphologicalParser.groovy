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
    File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
    umgr.addCsvFile(lexCsvSource)
    MorphologicalParser mp = new MorphologicalParser(fstBinary, umgr)


    GreekString s1 = new GreekString("λύω", "Unicode")
    MorphologicalAnalysis morph = mp.parseGreekString(s1)
    System.err.println "Analyses for λύω : "
    morph.analyses.each {
      System.err.println "\t" + it.toString()
    }


    GreekString s2 = new GreekString("ἔλυον", "Unicode")

    MorphologicalAnalysis impft = mp.parseGreekString(s2)
    System.err.println "Analyses for ἔλυον : "
    impft.analyses.each {
      System.err.println "\t" + it.toString()
    }

    /*
    def expectedAnalyses = [
    "conjugated verb: first person singular present indicative active",
    "conjugated verb: first person singular present subjunctive active"
    ]
    assert morph.analyses.size() == expectedAnalyses.size()
    morph.analyses.each {
      //assert expectedAnalyses.contains(it.toString())
    }
    */
  }
}
