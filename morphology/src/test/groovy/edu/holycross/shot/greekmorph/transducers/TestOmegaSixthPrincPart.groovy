package edu.holycross.shot.greekmorph


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

/** Tests transducer in acceptors/verb.a for hanlding
* of formation of second princ part of omega verbs
*/
class TestOmegaSixthPrincPart {

    String fstinfl = "/usr/bin/fst-infl"
    String transducer = "build/fst/acceptors/verb.a"
    File testFile = new File("build/testInput.txt")
    String cmd = "${fstinfl} ${transducer} ${testFile}"

    // Maps submitted FST string to expected value of morphform.toString()
    def testMap = [
    "<coretests.n64316_0><lexent.n64316><#>lus<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>": [
      "conjugated verb: first person singular future indicative active"
    ],
    "<coretests.n64316_0><lexent.n64316><#>luq<verb><w_regular>::<w_regular><w_indicative.7>omai<1st><sg><fut><indic><pass>":
    ["conjugated verb: first person singular future indicative passive"],


    "<coretests.n64316_0><lexent.n64316><#>lus<verb><w_regular>::<w_regular><w_indicative.7>omai<1st><sg><fut><indic><mid>":
    [ "conjugated verb: first person singular future indicative middle" ]

    ]


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
      testMap.each { wd ->
        testFile.setText(wd.key)
        def actualReplies = getAnalysisStrings()
        assert actualReplies as Set ==  wd.value as Set
      }
    }
}
