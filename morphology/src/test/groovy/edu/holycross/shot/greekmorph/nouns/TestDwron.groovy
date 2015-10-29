package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
* <u>coretests.n29828_0</u><u>lexent.n29828</u>dwr<noun><neut><os_ou><stemultacc>
*/
class TestDwron {

  // External files used in didactic tests:
  // FST toolkit's batch parser:
  String fstinfl = "/usr/bin/fst-infl"
  // CSV files with URN abbreviations for stems and inflectional rules
  File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")


  // Compiled finite state transducer:
  String fstBinary = "build/fst/greek.a"

  @Test
  void testParserDidactically() {
    String testWord = "δώρου"
    GreekString s = new GreekString(testWord, "Unicode")

    // A URN manager configured with CITE collection abbreviations
    // for both inflectional patterns and lexicon of stems:
    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)
    MorphologicalParser mp = new MorphologicalParser(fstBinary, umgr)

    // Parsing a GreekString gets you 0 or more analyses
    MorphologicalAnalysis morph = mp.parseGreekString(s)
    // should be 1 possibilities for δώρου.

    assert morph.analyses.size() == 1
    morph.analyses.each { morphAnalysis ->
      // Individual analyses of a word have three components.
      // (1) The lexical entity :
      String urnForForm = "urn:cite:shot:lexent.n29828"
      assert morphAnalysis.getLexicalEntity().toString() == urnForForm

      // (2) a form:
      MorphForm form = morphAnalysis.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.NOUN

      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.NEUTER
      assert formIdentification.getCas() == GrammaticalCase.GENITIVE
      assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      // we can also find its persistent accent:
      assert formIdentification.getPersistentAccent() == PersistentAccent.STEM_ULTIMA

      // and (3) an explanation for the analysis
      AnalysisExplanation explanation = morphAnalysis.getAnalysisExplanation()
      String expectedStemExplanation =  "urn:cite:gmorph:coretests.n29828_0"
      assert explanation.stem.toString() == expectedStemExplanation
      String expectedInflectionExplanation = "urn:cite:gmorph:nouninfl.os_ou2"
      assert explanation.inflection.toString() == expectedInflectionExplanation
    }
  }


  @Test
  void testMultiAnalyses() {
    String testWord = "δώρον"
    GreekString s = new GreekString(testWord, "Unicode")
    // A URN manager configured with CITE collection abbreviations
    // for both inflectional patterns and lexicon of stems:
    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)
    MorphologicalParser mp = new MorphologicalParser(fstBinary, umgr)

    // Parsing a GreekString gets you 0 or more analyses
    MorphologicalAnalysis morph = mp.parseGreekString(s)
    // should be 2 possibilities for δώρον.
    def nom_acc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.ACCUSATIVE ]
    assert morph.analyses.size() == 2
    morph.analyses.each { morphAnalysis ->
      // (2) a form:
      MorphForm form = morphAnalysis.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.NOUN

      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.NEUTER
      assert  nom_acc.contains(formIdentification.getCas())
      assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      // we can also find its persistent accent:
      assert formIdentification.getPersistentAccent() == PersistentAccent.STEM_ULTIMA
    }
  }
}
