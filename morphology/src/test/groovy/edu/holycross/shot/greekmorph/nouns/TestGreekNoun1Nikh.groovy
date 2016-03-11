package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekNoun1Nikh {

  // External files used in didactic tests:
  //
  // CSV files with URN abbreviations for stems and inflectional rules
  File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  // A URN manager configured with CITE collection abbreviations
  // for both inflectional patterns and lexicon of stems:
  UrnManager umgr = new UrnManager(inflCsvSource)

  // Compiled finite state transducer:
  String fstBinary = "build/greek/greek.a"



  @Test
  void testDeclension(){
    // Add lexicon to URN manager:
    umgr.addCsvFile(lexCsvSource)
    // And, finally, the parser:
    LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)
    mp.debug = 10
    mp.fstParser.debug = 10
    // map keyed by forms to analyze, to a unique GCN of noun form
    def expectedUnique = [

    "νίκης": [Gender.FEMININE, GrammaticalCase.GENITIVE, GrammaticalNumber.SINGULAR],
    "νίκῃ": [Gender.FEMININE, GrammaticalCase.DATIVE, GrammaticalNumber.SINGULAR],
    "νίκην": [Gender.FEMININE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.SINGULAR],

    "νικῶν": [Gender.FEMININE, GrammaticalCase.GENITIVE, GrammaticalNumber.PLURAL],
    "νίκαις": [Gender.FEMININE, GrammaticalCase.DATIVE, GrammaticalNumber.PLURAL],
    "νίκας": [Gender.FEMININE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.PLURAL]


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
    GreekString ambiguous = new GreekString("νίκη",true)
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
    GreekString ambiguousPlural = new GreekString("νῖκαι",true)
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

}
