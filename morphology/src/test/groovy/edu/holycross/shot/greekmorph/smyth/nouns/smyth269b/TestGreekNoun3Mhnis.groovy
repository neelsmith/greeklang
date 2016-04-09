package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString
import edu.harvard.chs.cite.CiteUrn

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekNoun3Mhnis {

  // External files used in didactic tests:
  // CSV files with URN abbreviations for stems and inflectional rules
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")

  // A URN manager configured with CITE collection abbreviations
  // for both inflectional patterns and lexicon of stems:
  UrnManager umgr = new UrnManager(urnReg)

  // Compiled finite state transducer:
  String fstBinary = "build/smyth/greek.a"

  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testDeclension() {
    mp.debug = 10
    mp.fstParser.debug = 10
    // map keyed by forms to analyze, to a unique GCN of noun form
    def expectedUnique = [
    "μῆνις": [Gender.FEMININE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR],
    "μήνιος": [Gender.FEMININE, GrammaticalCase.GENITIVE, GrammaticalNumber.SINGULAR],

    "μῆνιν": [Gender.FEMININE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.SINGULAR],

    "μηνίων": [Gender.FEMININE, GrammaticalCase.GENITIVE, GrammaticalNumber.PLURAL],
    "μήνισι": [Gender.FEMININE, GrammaticalCase.DATIVE, GrammaticalNumber.PLURAL]

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

    // Check also the ambiguous nom/acc/voc form.
    // Add test for voc/dat singular
    def nom_acc_voc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.NOMINATIVE.ACCUSATIVE,GrammaticalCase.VOCATIVE ]
    GreekString ambiguous = new GreekString("μήνιες",true)
    MorphologicalAnalysis morph = mp.parseGreekString(ambiguous)
    assert morph.analyses.size() == 3
    morph.analyses.each {
        MorphForm form = it.getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.NOUN
        CitableId formIdentification = form.getAnalysis()
        // can't know ordering of analyses, but case must be
        // ONE of these two!
        assert nom_acc_voc.contains(formIdentification.getCas())
        assert formIdentification.getGender() == Gender.FEMININE
        assert formIdentification.getNum() == GrammaticalNumber.PLURAL
    }
  }



  @Test
  void testParserDidactically() {
    // You build a LiteraryGreekParser with a FST
    // and a URNManager:
    // 1. Compiled finite state transducer
    // defined above as litGreekBinary
    // 2. A URN manager configured with CITE collection abbreviations
    // for both inflectional patterns and lexicon of stems:
    UrnManager umgr = new UrnManager(inflCsvSource)
    umgr.addCsvFile(lexCsvSource)

    LiteraryGreekParser mp = new LiteraryGreekParser(litGreekBinary, umgr)
    //  A word to test:
    String testWord = "μῆνιν"
    // LiteraryGreekParsers can operate on GreekString objects:
    GreekString s = new GreekString(testWord, true)

    // Parsing a GreekString gets you 0 or more analyses
    MorphologicalAnalysis morph = mp.parseGreekString(s)
    // although there is only 1 possibility for μῆνιν.
    assert morph.analyses.size() == 1

    morph.analyses.each { morphAnalysis ->
      // Individual analyses of a word have three components.
      // (1) The lexical entity :
      String urnForMenis = "urn:cite:shot:lexent.n67485"
      CiteUrn lexicalEntity = morphAnalysis.getLexicalEntity()
      assert lexicalEntity.toString() == urnForMenis

      // (2) a form:
      MorphForm form = morphAnalysis.getMorphForm()
      // which has a defined type
      assert form.getAnalyticalType() == AnalyticalType.NOUN

      // and since this form is a noun, it is guaranteed to have GCN:
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.FEMININE
      assert formIdentification.getCas() == GrammaticalCase.ACCUSATIVE
      assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
      // we can also find its persistent accent:
      assert formIdentification.getPersistentAccent() == PersistentAccent.STEM_PENULT

      // and (3) an explanation for the analysis
      AnalysisExplanation explanation = morphAnalysis.getAnalysisExplanation()
      // Stems are explained by a URN identifying the source for that
      // stem in a lexicon:
      String expectedStemExplanation =  "urn:cite:gmorph:lsjpool.n67485_0"
      assert explanation.stem.toString() == expectedStemExplanation
      // Inflectional patterns are explained by a URN identifying the
      // the inflectional rule applied to the stem
      String expectedInflectionExplanation = "urn:cite:gmorph:nouninfl.is_ios4"
      assert explanation.inflection.toString() == expectedInflectionExplanation

      // Of course there are various stringifications:
      assert form.toString() == "noun: feminine accusative singular"
      assert explanation.toString() == "stem urn:cite:gmorph:lsjpool.n67485_0, inflection urn:cite:gmorph:nouninfl.is_ios4"
      assert morphAnalysis.toString() == "from urn:cite:shot:lexent.n67485, noun: feminine accusative singular (stem urn:cite:gmorph:lsjpool.n67485_0, inflection urn:cite:gmorph:nouninfl.is_ios4)"

    }
  }

}
