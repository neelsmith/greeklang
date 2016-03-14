package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekNoun1Xwra {

    // External files used in didactic tests:
    //
    // CSV files with URN abbreviations for stems and inflectional rules
    File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")

    // A URN manager configured with CITE collection abbreviations
    // for both inflectional patterns and lexicon of stems:
    UrnManager umgr = new UrnManager(urnReg)

    // Compiled finite state transducer:
    String fstBinary = "build/smyth/greek.a"

    // The parser:
    LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)
/*

    @Test
    void testGenSgAccPl(){
      String greek =   "χώρας"

    //  "χώρας": [Gender.FEMININE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.PLURAL]

    mp.debug = 10
    mp.fstParser.debug = 10

    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
    assert morph.analyses.size() == 2
    MorphForm form = morph.analyses[0].getMorphForm()
    assert form.getAnalyticalType() == AnalyticalType.NOUN
    assert formIdentification.getGender() == Gender.FEMININE
    def casePossible = [GrammaticalCase.ACCUSATIVE, GrammaticalCase.GENITIVE]
    def actualCase = formIdentification.getCas()
    assert casePossible.contains(actualCase)
    if (actualCase == GrammaticalCase.ACCUSATIVE) {
      assert formIdentification.getNum() == GrammaticalNumber.PLURAL
    }
    if (actualCase == GrammaticalCase.GENITIVE) {
      assert formIdentification.getNum() == GrammaticalNumber.SINGULAR
    }
  }
  */
  /*
    @Test
    void testNomVoc(){
      // Check also the ambiguous nom/voc forms.
      // Singular:
      def nom_voc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.VOCATIVE ]
      GreekString ambiguous = new GreekString("χώρα",true)
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



    @Test
    void testNomVoc(){
      // Check also the ambiguous nom/voc forms.
      // Singular:
      def nom_voc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.VOCATIVE ]
      GreekString ambiguous = new GreekString("χώρα",true)
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


      @Test
      void testDuals(){
        def nom_acc_voc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.ACCUSATIVE,GrammaticalCase.VOCATIVE ]

        GreekString nav = new GreekString("νίκα",true)
        MorphologicalAnalysis morph = mp.parseGreekString(nav)
        assert morph.analyses.size() == 3
        morph.analyses.each {
            MorphForm form = it.getMorphForm()
            assert form.getAnalyticalType() == AnalyticalType.NOUN
            CitableId formIdentification = form.getAnalysis()
            // can't know ordering of analyses, but case must be
            // ONE of these two!
            assert nom_acc_voc.contains(formIdentification.getCas())
            assert formIdentification.getGender() == Gender.FEMININE
            assert formIdentification.getNum() == GrammaticalNumber.DUAL
        }

        def gen_dat = [GrammaticalCase.GENITIVE,GrammaticalCase.DATIVE ]

        GreekString gd = new GreekString("νίκαιν",true)
        MorphologicalAnalysis morphgd = mp.parseGreekString(gd)
        //assert morphgd.analyses.size() == 2
        morphgd.analyses.each { a ->
          System.err.println "Analysis: " + a
            MorphForm form = a.getMorphForm()
            assert form.getAnalyticalType() == AnalyticalType.NOUN
            CitableId formIdentification = form.getAnalysis()
            assert gen_dat.contains(formIdentification.getCas())
            assert formIdentification.getGender() == Gender.FEMININE
            assert formIdentification.getNum() == GrammaticalNumber.DUAL
        }
      }
      */
}