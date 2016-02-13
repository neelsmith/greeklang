package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekNounHodos {

    // External files used in didactic tests:
    //
    // CSV files with URN abbreviations for stems and inflectional rules
    File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
    File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
    // A URN manager configured with CITE collection abbreviations
    // for both inflectional patterns and lexicon of stems:
    UrnManager umgr = new UrnManager(inflCsvSource)

    // Compiled finite state transducer:
    String litGreekBinary = "build/greek/greek.a"
    String atticBinary = "build/attic/greek.a"



    @Test
    void testDeclension() {
      // Add lexicon to URN manager:
      umgr.addCsvFile(lexCsvSource)
      // And, finally, the parser:
      LiteraryGreekParser mp = new LiteraryGreekParser(litGreekBinary, umgr)
      mp.debug = 10
      mp.fstParser.debug = 10
      // map keyed by forms to analyze, to a unique GCN of noun form
      def expectedUnique = [
      "ὁδός": [Gender.FEMININE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR],
      "ὁδοῦ": [Gender.FEMININE, GrammaticalCase.GENITIVE, GrammaticalNumber.SINGULAR],
      "ὁδῷ": [Gender.FEMININE, GrammaticalCase.DATIVE, GrammaticalNumber.SINGULAR],
      "ὁδόν": [Gender.FEMININE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.SINGULAR],

      "ὁδῶν": [Gender.FEMININE, GrammaticalCase.GENITIVE, GrammaticalNumber.PLURAL],
      "ὁδοῖς": [Gender.FEMININE, GrammaticalCase.DATIVE, GrammaticalNumber.PLURAL],
      "ὁδούς": [Gender.FEMININE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.PLURAL],

      "ὁδέ": [Gender.FEMININE, GrammaticalCase.VOCATIVE, GrammaticalNumber.SINGULAR]
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

      // Check also the ambiguous nom/voc form.
      def nom_voc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.VOCATIVE ]
      GreekString ambiguous = new GreekString("ὁδοί",true)
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
          assert formIdentification.getNum() == GrammaticalNumber.PLURAL
      }
    }



  @Test
  void testParserDidactically() {
    String testWord = "ὁδῷ"
    GreekString s = new GreekString(testWord, true)

    // A URN manager configured with CITE collection abbreviations
    // for both inflectional patterns and lexicon of stems:
    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)
    LiteraryGreekParser mp = new LiteraryGreekParser(litGreekBinary, umgr)
    mp.debug = 10
    mp.fstParser.debug = 10


    // Parsing a GreekString gets you 0 or more analyses
    MorphologicalAnalysis morph = mp.parseGreekString(s)
    // although there is only 1 possibility for ὁδῷ.
    assert morph.analyses.size() == 1

    morph.analyses.each { morphAnalysis ->
      // Individual analyses of a word have three components.
      // (1) The lexical entity :
      String urnForForm = "urn:cite:shot:lexent.n272092"
      assert morphAnalysis.getLexicalEntity().toString() == urnForForm

      // (2) a form:
      MorphForm form = morphAnalysis.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.NOUN

      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.FEMININE
      assert formIdentification.getCas() == GrammaticalCase.DATIVE
      assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      // we can also find its persistent accent:
      assert formIdentification.getPersistentAccent() == PersistentAccent.INFLECTIONAL_ENDING

      // and (3) an explanation for the analysis
      AnalysisExplanation explanation = morphAnalysis.getAnalysisExplanation()
      String expectedStemExplanation =  "urn:cite:gmorph:lsjpool.n67485_0"
      //assert explanation.stem.toString() == expectedStemExplanation


      System.err.println "antth. stem expl: " + explanation.stem.toString()
      // Inflectional patterns are explained by a URN identifying the
      // the inflectional rule applied to the stem
      String expectedInflectionExplanation = "urn:cite:gmorph:nouninfl.is_ios4"
      //assert explanation.inflection.toString() == expectedInflectionExplanation
      System.err.println "antth. inf expl: " + explanation.inflection.toString()


    }
  }

}
