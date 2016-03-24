package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekNoun3Phulax  {

    // External files used in didactic tests:
    //
    // CSV files with URN abbreviations for stems and inflectional rules
    File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")

    // A URN manager configured with CITE collection abbreviations
    // for both inflectional patterns and lexicon of stems:
    UrnManager umgr = new UrnManager(urnReg)

    // Compiled finite state transducer:
    String litGreekBinary = "build/smyth/greek.a"
    LiteraryGreekParser mp = new LiteraryGreekParser(litGreekBinary, umgr)


/*
    @Test
    void testNomVoc() {
      def nom_voc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.VOCATIVE ]
      GreekString ambiguous = new GreekString("ἄνθρωποι",true)
      MorphologicalAnalysis morph = mp.parseGreekString(ambiguous)
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
      }
    }

    @Test
    void testDuals1() {
      def nom_acc_voc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.ACCUSATIVE,GrammaticalCase.VOCATIVE ]


      GreekString ambiguousNav = new GreekString("ἀνθρώπω",true)
      MorphologicalAnalysis morph = mp.parseGreekString(ambiguousNav)
      assert morph.analyses.size() == 3
      morph.analyses.each {
          MorphForm form = it.getMorphForm()
          assert form.getAnalyticalType() == AnalyticalType.NOUN
          CitableId formIdentification = form.getAnalysis()
          // can't know ordering of analyses, but case must be
          // ONE of these two!
          assert nom_acc_voc.contains(formIdentification.getCas())
          assert formIdentification.getGender() == Gender.MASCULINE
          assert formIdentification.getNum() == GrammaticalNumber.DUAL
    }
  }
  @Test
  void testDuals2() {
    def gen_dat = [GrammaticalCase.GENITIVE,GrammaticalCase.DATIVE ]
    GreekString ambiguousGd = new GreekString("ἀνθρώποιν",true)
    MorphologicalAnalysis morph = mp.parseGreekString(ambiguousGd)
    assert morph.analyses.size() == 2
    morph.analyses.each {
        MorphForm form = it.getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.NOUN
        CitableId formIdentification = form.getAnalysis()
        // can't know ordering of analyses, but case must be
        // ONE of these two!
        assert gen_dat.contains(formIdentification.getCas())
        assert formIdentification.getGender() == Gender.MASCULINE
        assert formIdentification.getNum() == GrammaticalNumber.DUAL
    }
    }
*/
    @Test
    void testDeclension() {
    mp.debug = 10
    mp.fstParser.debug = 10
        // map keyed by forms to analyze, to a unique GCN of noun form
        def expectedUnique = [

        "φύλακος": [Gender.MASCULINE, GrammaticalCase.GENITIVE, GrammaticalNumber.SINGULAR],
        "φύλακι": [Gender.MASCULINE, GrammaticalCase.DATIVE, GrammaticalNumber.SINGULAR],


        "φυλάκων": [Gender.MASCULINE, GrammaticalCase.GENITIVE, GrammaticalNumber.PLURAL],
        "φύλαξι": [Gender.MASCULINE, GrammaticalCase.DATIVE, GrammaticalNumber.PLURAL],
        "φύλαξιν": [Gender.MASCULINE, GrammaticalCase.DATIVE, GrammaticalNumber.PLURAL]


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

}
