package edu.holycross.shot.greekmorph

import edu.holycross.shot.attic.AtticString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestBasileusAttic {

  // External files used in didactic tests:
  // FST toolkit's batch parser:
  String fstinfl = "/usr/bin/fst-infl"
  // CSV files with URN abbreviations for stems and inflectional rules
  File lexCsvSource = new File("sampledata/urn-registries/datasets.csv")
  File inflCsvSource = new File("src/fst/collectionAbbreviations.csv")
  // A URN manager configured with CITE collection abbreviations
  // for both inflectional patterns and lexicon of stems:
  UrnManager umgr = new UrnManager(inflCsvSource)

  // Compiled finite state transducer:
  String atticBinary = "build/attic/greek.a"

  @Test
  void testDeclension() {
    // Add lexicon to URN manager:
    umgr.addCsvFile(lexCsvSource)
    // And, finally, the parser:
    AtticGreekParser agp = new AtticGreekParser(atticBinary, umgr)
    agp.debug = 10
    agp.fstParser.debug = 10

    // map keyed by forms to analyze, to a unique GCN of noun form
    def expectedUnique = [

    //"BASILEO_S": [Gender.MASCULINE, GrammaticalCase.GENITIVE, GrammaticalNumber.SINGULAR],
    "BASILEI": [Gender.MASCULINE, GrammaticalCase.DATIVE, GrammaticalNumber.SINGULAR],
    "BASLEA": [Gender.MASCULINE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.SINGULAR],

    "BASILEWN": [Gender.MASCULINE, GrammaticalCase.GENITIVE, GrammaticalNumber.PLURAL],
    "BASILEUSI": [Gender.MASCULINE, GrammaticalCase.DATIVE, GrammaticalNumber.PLURAL],
    "BASILEAS": [Gender.MASCULINE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.PLURAL]
    ]

    expectedUnique.keySet().each { greek ->
      def expectedAnswer = expectedUnique[greek]
      MorphologicalAnalysis morph = agp.parseAtticString(new AtticString(greek))
      assert morph.analyses.size() == 1
      MorphForm form = morph.analyses[0].getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.NOUN
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getGender() == expectedAnswer[0]
      assert formIdentification.getCas() == expectedAnswer[1]
      assert formIdentification.getNum() == expectedAnswer[2]
    }

    /*
    // Check also the ambiguous nom/voc form.
    def nom_voc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.VOCATIVE ]
    AtticString ambiguous = new AtticString("BOLAI")
    MorphologicalAnalysis morph = agp.parseAtticString(ambiguous)
    assert morph.analyses.size() == 2
    morph.analyses.each {
        MorphForm form = it.getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.NOUN
        CitableId formIdentification = form.getAnalysis()
        // can't know ordering of analyses, but case must be
        // ONE of these two!
        assert nom_voc.contains(formIdentification.getCas())
        assert formIdentification.getGender() == Gender.MASCULINE
        assert formIdentification.getNum() == GrammaticalNumber.PLURAL
    } */
  }

}
