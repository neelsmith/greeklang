package edu.holycross.shot.greekmorph


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestOmegaFirstPrincPart {



  // Maps submitted FST string to expected value of morphform.toString()
  def testMap = [
  "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>":
  ["conjugated verb: first person singular present indicative active"],

  "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.7>omai<1st><sg><pres><indic><mid>":
  ["conjugated verb: first person singular present indicative middle"],

  "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.7>omai<1st><sg><pres><indic><pass>":
  ["conjugated verb: first person singular present indicative passive"],


  "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><subj><act>":
  ["conjugated verb: first person singular present subjunctive active"],

  "<coretests.n64316_0><lexent.n64316><#>e)lu<verb><w_regular>::<w_regular><w_indicative.13>on<1st><sg><impft><indic><act>":
  ["conjugated verb: first person singular imperfect indicative active"],

  "<coretests.n64316_0><lexent.n64316><#>e)lu<verb><w_regular>::<w_regular><w_indicative.19>omhn<1st><sg><impft><indic><mid>":
  ["conjugated verb: first person singular imperfect indicative middle"],

  "<coretests.n64316_0><lexent.n64316><#>e)lu<verb><w_regular>::<w_regular><w_indicative.19>omhn<1st><sg><impft><indic><pass>":
  ["conjugated verb: first person singular imperfect indicative passive"]

  ]


  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  File lexCsvSource = new File("sampledata/userconfig/extraDatasets.csv")


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
      } else if (l ==~ /No result.+/) {
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

  @Test
  void testVerbTransducers() {
    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)
    String fstinfl = "/usr/bin/fst-infl"
    File testFile = new File("build/testInput.txt")
    def transducers = [
    "build/fst/acceptors/verb/w_princparts.a",
    "build/fst/acceptors/verb.a",
    "build/fst/acceptor.a"
    ]

    transducers.each { t ->
      String cmd = "${fstinfl} ${t} ${testFile}"
      testMap.each { wd ->
      testFile.setText(wd.key)
      def actualReplies = getAnalysisStrings(cmd, umgr)
        assert actualReplies as Set ==  wd.value as Set
      }
    }

  }
}
