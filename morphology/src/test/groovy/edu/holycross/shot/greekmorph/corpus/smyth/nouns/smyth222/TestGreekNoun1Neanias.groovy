package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekNoun1Neanias {

  // External files used in didactic tests:
  // FST toolkit's batch parser:
  String fstinfl = "/usr/bin/fst-infl"
  // CSV files with URN abbreviations for stems and inflectional rules
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")

  // A URN manager configured with CITE collection abbreviations
  // for both inflectional patterns and lexicon of stems:
  UrnManager umgr = new UrnManager(urnReg)

  // Compiled finite state transducer:
  String litGreekBinary = "build/smyth/greek.a"
  // The parser
  LiteraryGreekParser mp = new LiteraryGreekParser(litGreekBinary, umgr)


  @Test
  void testDeclension() {
    mp.debug = 10
    mp.fstParser.debug = 10
    // map keyed by forms to analyze, to a unique GCN of noun form
    def expectedUnique = [
      "νεανίου": [Gender.MASCULINE, GrammaticalCase.GENITIVE, GrammaticalNumber.SINGULAR],
      "νεανίᾳ": [Gender.MASCULINE, GrammaticalCase.DATIVE, GrammaticalNumber.SINGULAR],
      "νεανίαν": [Gender.MASCULINE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.SINGULAR],

      "νεανιῶν": [Gender.MASCULINE, GrammaticalCase.GENITIVE, GrammaticalNumber.PLURAL],
      "νεανίαις": [Gender.MASCULINE, GrammaticalCase.DATIVE, GrammaticalNumber.PLURAL],
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
  }

  // neanias: nom s or acc pl
  @Test
  void testDual1() {
    GreekString ambiguous = new GreekString("νεανία",true)
    MorphologicalAnalysis morph = mp.parseGreekString(ambiguous)
    assert morph.analyses.size() == 4
    morph.analyses.each {
      MorphForm form = it.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.NOUN
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.MASCULINE
      if (formIdentification.getNum() == GrammaticalNumber.SINGULAR) {
	assert (formIdentification.getCas() == GrammaticalCase.VOCATIVE)
      } else if (formIdentification.getNum() == GrammaticalNumber.PLURAL) {
	assert (formIdentification.getCas() == GrammaticalCase.ACCUSATIVE)
      }
    }
  }

  @Test
  void testNomVoc() {
    GreekString ambiguous = new GreekString("νεανία",true)
    MorphologicalAnalysis morph = mp.parseGreekString(ambiguous)
    def nav = [GrammaticalCase.NOMINATIVE, GrammaticalCase.ACCUSATIVE, GrammaticalCase.VOCATIVE]
    assert morph.analyses.size() == 4
    morph.analyses.each {
      MorphForm form = it.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.NOUN
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.MASCULINE
      if (formIdentification.getNum() == GrammaticalNumber.SINGULAR) {
        assert (formIdentification.getCas() == GrammaticalCase.VOCATIVE)
      } else if (formIdentification.getNum() == GrammaticalNumber.DUAL) {
        assert nav.contains(formIdentification.getCas())
      }
    }
  }


// duals, neania same as voc s !
  @Test
  void testDual2() {
    GreekString ambiguous = new GreekString("νεανία",true)
    MorphologicalAnalysis morph = mp.parseGreekString(ambiguous)
    def nav = [GrammaticalCase.NOMINATIVE, GrammaticalCase.ACCUSATIVE, GrammaticalCase.VOCATIVE]

    
    assert morph.analyses.size() == 4
    morph.analyses.each {
      MorphForm form = it.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.NOUN
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.MASCULINE
      if (formIdentification.getNum() == GrammaticalNumber.SINGULAR) {
        assert (formIdentification.getCas() == GrammaticalCase.VOCATIVE)
      } else if (formIdentification.getNum() == GrammaticalNumber.DUAL) {
        assert nav.contains(formIdentification.getCas())
      }
    }


    def gd = [GrammaticalCase.GENITIVE, GrammaticalCase.DATIVE]
    GreekString gddual = new GreekString("νεανίαιν",true)
    MorphologicalAnalysis dualmorph = mp.parseGreekString(gddual)
    assert dualmorph.analyses.size() == 2
    dualmorph.analyses.each {
      MorphForm form = it.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.NOUN
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.MASCULINE
      assert formIdentification.getNum() == GrammaticalNumber.DUAL
      assert gd.contains(formIdentification.getCas())
    }
  }


// pls, nom-voc
  @Test
  void testPlural() {
    GreekString ambiguous = new GreekString("νεανίαι",true)
    MorphologicalAnalysis morph = mp.parseGreekString(ambiguous)
    def nomvoc = [GrammaticalCase.NOMINATIVE, GrammaticalCase.VOCATIVE]
    assert morph.analyses.size() == 2
    morph.analyses.each {
      MorphForm form = it.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.NOUN
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == Gender.MASCULINE
      assert formIdentification.getNum() == GrammaticalNumber.PLURAL
      assert nomvoc.contains(formIdentification.getCas())
    }
  }
}


