package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests transducer in acceptors/noun.a
*/
class TestNounsPretty {


  String fstinfl = "/usr/bin/fst-infl"
  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
  //File testFile = new File("build/testInput.txt")


  @Test
  void testMorphParser() {
    // You build a MorphologicalParser with a FST
    // and a URNManager:
    // 1. Compiled finite state transducer:
    String fstBinary = "build/fst/greek.a"
    // 2. Configure a URN manager with CITE collectionAbbreviations
    // for both inflectional patterns and lexicon of stems:
    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)

    MorphologicalParser mp = new MorphologicalParser(fstBinary, umgr)

    // MorphologicalParsers operate on GreekStrings:
    String testWord = "μῆνιν"
    GreekString s = new GreekString(testWord, "Unicode")

    // Parsing a GreekString gets you 0 or more analyses
    MorphologicalAnalysis morph = mp.parseGreekString(s)
    morph.analyses.eachWithIndex { morphAnalysis, idx ->
      // Individual analyses of a word have three components.
      // (1) An analytical type:
      assert morphAnalysis.analyticalType == AnalyticalType.NOUN
      // (2) a citable form:
      CitableForm form = morphAnalysis.getAnalysis()
      // (since this form is a noun, it is guaranteed to have GCN:)
      assert form.getGender() == Gender.FEMININE
      assert form.getCas() == GrammaticalCase.ACCUSATIVE
      assert form.getNum() == GrammaticalNumber.SINGULAR
      // (of course there are pretty stringifications:)
      assert morphAnalysis.toString() == "noun: feminine accusative singular"
      assert form.toString() == "feminine accusative singular"

      // and (3) an explanation for the analysis (found at the same index
      // in the parallel list of explanations):
      AnalysisExplanation explanation = morph.explanations[idx]
      // Stems are explained by a URN identified the relation of URN
      //explain stem: urn:cite:gmorph:coretests.n67485_0
//explain inflection: urn:cite:gmorph:nouninfl.is_ios4
      System.err.println "explain stem: " + explanation.stem
      System.err.println "explain inflection: " + explanation.inflection
    }
  }

}
