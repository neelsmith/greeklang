package edu.holycross.shot.greekmorph

import edu.holycross.shot.greekutils.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests transducer in acceptors/noun.a
*/
class TestNouns {

  String fstinfl = "/usr/bin/fst-infl"
  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
  File testFile = new File("build/testInput.txt")


// OK IN inflections.a:
// <is_ios><u>nouninfl.is_ios1</u>is<fem><nom><sg>

  // Maps submitted FST string to expected value of morphform.toString()
  def testTransducers = [
  /*
  "mhnin": [
    "noun: feminine accusative singular"
  ]
  */
  ]

  def testFstStrings = [
  "mhnin": [
  "noun: feminine accusative singular"
  ]
  ]


  def testUnicodeInput = [
  "μῆνιν": [
  "noun: feminine accusative singular"
  ]
  ]

  /** */
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
        analysisStrings.add(morphForm.toString())
      }
    }
    return analysisStrings
  }


  @Test
  void testVerbTransducers() {
    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)

    def transducers = [
      "build/fst/acceptors/noun.a",
      "build/fst/acceptor.a"
    ]
    transducers.each { t ->
      String cmd = "${fstinfl} ${t} ${testFile}"
      System.err.println "Testing noun against transducer ${t}"
      testTransducers.each { wd ->
        testFile.setText(wd.key)
        def actualReplies = getAnalysisStrings(cmd, umgr)
        System.err.println "\tFor ${wd.key}, got \n${actualReplies}\n"
        assert actualReplies as Set ==  wd.value as Set
      }
    }
  }

  @Test
  void testFinalParser() {
    String parser = "build/fst/greek.a"
    String cmd = "${fstinfl} ${parser} ${testFile}"

    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)
    System.err.println "Testing noun on final ${parser}"
    testFstStrings.each { wd ->
      testFile.setText(wd.key)
      def actualReplies = getAnalysisStrings(cmd, umgr)
      System.err.println "\tFor ${wd.key}, got \n${actualReplies}\n"
      assert actualReplies as Set ==  wd.value as Set
    }
  }

  @Test
  void testMorphParser() {
    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)

    String fstBinary = "build/fst/greek.a"
    MorphologicalParser mp = new MorphologicalParser(fstBinary, umgr)
    System.err.println "Testing noun on Morphological parser configured wtih  ${fstBinary}"
    testUnicodeInput.each { wd ->
      GreekString s = new GreekString(wd.key, "Unicode")
      MorphologicalAnalysis morph = mp.parseGreekString(s)
      def actualReplies = []
      morph.analyses.each {
        actualReplies.add(it.toString())
      }
      System.err.println "\tFor ${wd.key}, got \n${actualReplies}\n"
      assert actualReplies as Set ==  wd.value as Set
    }
  }

}
