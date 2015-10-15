package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestUnitTransducers {

  // Transducer and data sets for URN Manager:
  String fstinfl = "/usr/bin/fst-infl"
  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
  File testFile = new File("build/testInput.txt")

  // Generic mehod to get analysis for a give command:
  ArrayList getAnalysisStrings(String cmd, UrnManager urnManager) {
    def analysisStrings = []
    Process process = cmd.execute()
    def out = new StringBuffer()
    def err = new StringBuffer()
    process.consumeProcessOutput( out, err )
    process.waitFor()
    out.toString().eachLine { l ->
      if (l[0] == ">") {
        // omit
      } else if (l ==~ /[Nn]o result.+/) {
        // omit
      } else {

        FstAnalysisParser fsp = new FstAnalysisParser(l, urnManager)
        MorphForm morphForm = fsp.getMorphForm()
        //AnalysisExplanation explanation = fsp.getExplanation()
        analysisStrings.add(morphForm.toString())
      }
    }
    return analysisStrings
  }



  /** Tests forms built on second and third principal part. */
  @Test
  void testSecondPart() {
    String transducer =   "build/fst/acceptors/verb/2nd_3rd_pp.a"
    String cmd = "${fstinfl} ${transducer} ${testFile}"
    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)


    // map of input FST string to analyses:
    def secondPartDataMap = [
    "<coretests.n64316_0><lexent.n64316><#>lus<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>": [
      "conjugated verb: first person singular future indicative active"
    ],

    "<coretests.n64316_0><lexent.n64316><#>lus<verb><w_regular>::<w_regular><w_indicative.7>omai<1st><sg><fut><indic><mid>": [
      "conjugated verb: first person singular future indicative middle"
    ],

    "<coretests.n6949_0><lexent.n6949>a<sm>na<#>lus<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>" :
    ["conjugated verb: first person singular future indicative active"]

    ]

    // analyze each entry in data map:
    secondPartDataMap.each { wd ->
      testFile.setText(wd.key)
      def actualReplies = getAnalysisStrings(cmd, umgr)
      System.err.println "\tFor ${wd.key}, got \n${actualReplies}\n"
      assert actualReplies as Set ==  wd.value as Set
    }
  }




  /** Tests forms built on second and third principal part. */
  @Test
  void testSixthPart() {
    String transducer =   "build/fst/acceptors/verb/6th_pp.a"
    String cmd = "${fstinfl} ${transducer} ${testFile}"
    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)


    // map of input FST string to analyses:
    def sixthPartDataMap = [
    "<coretests.n64316_0><lexent.n64316><#>luq<verb><w_regular>::<w_regular><w_indicative.67>hsomai<1st><sg><fut><indic><pass>":
    ["conjugated verb: first person singular future indicative passive"],

    "<coretests.n6949_0><lexent.n6949>a<sm>na<#>luq<verb><w_regular>::<w_regular><w_indicative.67>hsomai<1st><sg><fut><indic><pass>":
    ["conjugated verb: first person singular future indicative passive"]

    ]

    // analyze each entry in data map:
    sixthPartDataMap.each { wd ->
      testFile.setText(wd.key)
      def actualReplies = getAnalysisStrings(cmd, umgr)
      System.err.println "\tFor ${wd.key}, got \n${actualReplies}\n"
      assert actualReplies as Set ==  wd.value as Set
    }
  }


}
