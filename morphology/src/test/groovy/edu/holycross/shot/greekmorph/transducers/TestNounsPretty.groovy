package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests transducer in acceptors/noun.a
*/
class TestNounsPretty {

  // External files used in didactic tests:
  // FST toolkit's batch parser:
  String fstinfl = "/usr/bin/fst-infl"
  // CSV files with URN abbreviations for stems and inflectional rules
  File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")


  @Test
  void testParserDidactically() {
    // You build a MorphologicalParser with a FST
    // and a URNManager:
    // 1. Compiled finite state transducer:
    String fstBinary = "build/fst/greek.a"
    // 2. A URN manager configured with CITE collection abbreviations
    // for both inflectional patterns and lexicon of stems:
    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)

    MorphologicalParser mp = new MorphologicalParser(fstBinary, umgr)

    // MorphologicalParsers can operate on GreekString objects:
    String testWord = "μῆνιν"
    GreekString s = new GreekString(testWord, "Unicode")

    // Parsing a GreekString gets you 0 or more analyses
    MorphologicalAnalysis morph = mp.parseGreekString(s)
    // although there is only 1 possibility for μῆνιν.
    assert morph.analyses.size() == 1

    morph.analyses.each { morphAnalysis ->
      // Individual analyses of a word have three components.
      // (1) The lexical entity :
      String urnForMenis = "urn:cite:shot:lexent.n67485"
      assert morphAnalysis.getLexicalEntity().toString() == urnForMenis

      // (2) a form:
      MorphForm form = morphAnalysis.getMorphForm()
      // which has a defined type
      assert form.getAnalyticalType() == AnalyticalType.NOUN

      // and since this form is a noun, it is guaranteed to have GCN:
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.FEMININE
      assert formIdentification.getCas() == GrammaticalCase.ACCUSATIVE
      assert formIdentification.getNum() == GrammaticalNumber.SINGULAR


      // and (3) an explanation for the analysis
      AnalysisExplanation explanation = morphAnalysis.getAnalysisExplanation()
      // Stems are explained by a URN identifying the source for that
      // stem in a lexicon:
      String expectedStemExplanation =  "urn:cite:gmorph:coretests.n67485_0"
      assert explanation.stem.toString() == expectedStemExplanation
      // Inflectional patterns are explained by a URN identifying the
      // the inflectional rule applied to the stem
      String expectedInflectionExplanation = "urn:cite:gmorph:nouninfl.is_ios4"
      assert explanation.inflection.toString() == expectedInflectionExplanation

      // Of course there are various stringifications:
      assert form.toString() == "noun: feminine accusative singular"
      assert explanation.toString() == "stem urn:cite:gmorph:coretests.n67485_0, inflection   urn:cite:gmorph:nouninfl.is_ios4"
      assert morphAnalysis.toString() == "from urn:cite:shot:lexent.n67485, noun: feminine accusative singular (stem urn:cite:gmorph:coretests.n67485_0, inflection urn:cite:gmorph:nouninfl.is_ios4)"

    }
  }

}
