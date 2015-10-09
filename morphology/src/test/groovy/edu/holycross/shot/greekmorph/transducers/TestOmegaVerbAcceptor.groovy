package edu.holycross.shot.greekmorph


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestOmegaVerbAcceptor {



  String fstinfl = "/usr/bin/fst-infl"
  String transducer = "build/fst/acceptors/verb.a"
  File testFile = new File("build/testInput.txt")
  String cmd = "${fstinfl} ${transducer} ${testFile}"

  ArrayList getAnalysisStrings() {
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
        FstAnalysisParser fsp = new FstAnalysisParser(l)
        MorphForm morphForm = fsp.getMorphForm()
        //AnalysisExplanation explanation = fsp.getExplanation()
        analysisStrings.add(morphForm.toString())
      }
    }
    return analysisStrings
  }

  @Test
  void testVerbAcceptor() {
    def testMap = [
    "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>":
    ["conjugated verb: first person singular present indicative active"],

    "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.7>omai<1st><sg><pres><indic><mid>":
    ["conjugated verb: first person singular present indicative middle"],

    "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.7>omai<1st><sg><pres><indic><pass>":
    ["conjugated verb: first person singular present indicative passive"]

    ]

    testMap.each { wd ->
      testFile.setText(wd.key)
      def actualReplies = getAnalysisStrings()
      assert actualReplies as Set ==  wd.value as Set
    }
  }
}
