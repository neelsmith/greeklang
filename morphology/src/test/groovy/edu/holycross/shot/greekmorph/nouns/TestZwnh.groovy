package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestZwnh {

  // External files used in didactic tests:
  //
  // CSV files with URN abbreviations for stems and inflectional rules
  File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  // A URN manager configured with CITE collection abbreviations
  // for both inflectional patterns and lexicon of stems:
  UrnManager umgr = new UrnManager(inflCsvSource)

  // Compiled finite state transducer:
  String fstBinary = "build/fst/greek.a"

    @Test
    void testDeclension() {
      // Add lexicon to URN manager:
      umgr.addCsvFile(lexCsvSource)
      // And, finally, the parser:
      MorphologicalParser mp = new MorphologicalParser(fstBinary, umgr)

      // map keyed by forms to analyze, to a unique GCN of noun form
      def expectedUnique = [

      "ζώνης": [Gender.FEMININE, GrammaticalCase.GENITIVE, GrammaticalNumber.SINGULAR],
      "ζώνῃ": [Gender.FEMININE, GrammaticalCase.DATIVE, GrammaticalNumber.SINGULAR],
      "ζώνην": [Gender.FEMININE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.SINGULAR],

      "ζωνῶν": [Gender.FEMININE, GrammaticalCase.GENITIVE, GrammaticalNumber.PLURAL],
      "ζώναις": [Gender.FEMININE, GrammaticalCase.DATIVE, GrammaticalNumber.PLURAL],
      //"ζώνας": [Gender.FEMININE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.PLURAL]


      ]

      expectedUnique.keySet().each { greek ->
        def expectedAnswer = expectedUnique[greek]
        MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
        assert morph.analyses.size() == 1
        MorphForm form = morph.analyses[0].getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.NOUN
        CitableId formIdentification = form.getAnalysis()
        assert formIdentification.getGender() == expectedAnswer[0]
        assert formIdentification.getCas() == expectedAnswer[1]
        assert formIdentification.getNum() == expectedAnswer[2]
      }

      // Check also the ambiguous nom/voc forms.
      // Singular:
      def nom_voc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.VOCATIVE ]
      GreekString ambiguous = new GreekString("ζώνη",true)
      MorphologicalAnalysis morph = mp.parseGreekString(ambiguous)
      assert morph.analyses.size() == 2
      morph.analyses.each {
          MorphForm form = it.getMorphForm()
          assert form.getAnalyticalType() == AnalyticalType.NOUN
          CitableId formIdentification = form.getAnalysis()
          // can't know ordering of analyses, but case must be
          // ONE of these two!
          assert nom_voc.contains(formIdentification.getCas())
          assert formIdentification.getGender() == Gender.FEMININE
          assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      }
      // Plural:
      GreekString ambiguousPlural = new GreekString("ζῶναι",true)
      MorphologicalAnalysis morphPl = mp.parseGreekString(ambiguousPlural)
      assert morphPl.analyses.size() == 2
      morphPl.analyses.each {
          MorphForm form = it.getMorphForm()
          assert form.getAnalyticalType() == AnalyticalType.NOUN
          CitableId formIdentification = form.getAnalysis()
          assert nom_voc.contains(formIdentification.getCas())
          assert formIdentification.getGender() == Gender.FEMININE
          assert formIdentification.getNum() == GrammaticalNumber.PLURAL
      }
    }


  @Test
  void testParserDidactically() {
    String testWord = "ζωνῶν"
    GreekString s = new GreekString(testWord, true)

    umgr.addCsvFile(lexCsvSource)
    MorphologicalParser mp = new MorphologicalParser(fstBinary, umgr)

    // Parsing a GreekString gets you 0 or more analyses
    MorphologicalAnalysis morph = mp.parseGreekString(s)
    // although there is only 1 possibility for ζωνῶν.
    assert morph.analyses.size() == 1

    morph.analyses.each { morphAnalysis ->
      // Individual analyses of a word have three components.
      // (1) The lexical entity :
      String urnForForm = "urn:cite:shot:lexent.n46456"
      assert morphAnalysis.getLexicalEntity().toString() == urnForForm

      // (2) a form:
      MorphForm form = morphAnalysis.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.NOUN
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.FEMININE
      assert formIdentification.getCas() == GrammaticalCase.GENITIVE
      assert formIdentification.getNum() == GrammaticalNumber.PLURAL
      // we can also find its persistent accent:
      assert formIdentification.getPersistentAccent() == PersistentAccent.STEM_ULTIMA

      // and (3) an explanation for the analysis
      AnalysisExplanation explanation = morphAnalysis.getAnalysisExplanation()
      String expectedStemExplanation =  "urn:cite:gmorph:coretests.n46456_0"
      assert explanation.stem.toString() == expectedStemExplanation
      // Inflectional patterns are explained by a URN identifying the
      // the inflectional rule applied to the stem
      String expectedInflectionExplanation = "urn:cite:gmorph:nouninfl.h_hs7"
      assert explanation.inflection.toString() == expectedInflectionExplanation
    }
  }

}
