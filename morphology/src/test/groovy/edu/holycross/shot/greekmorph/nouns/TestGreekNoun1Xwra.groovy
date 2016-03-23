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



      @Test
      void testUniqueForms(){
        // map keyed by forms to analyze, to a unique GCN of noun form
        def expectedUnique = [

      
        "χώρᾳ": [Gender.FEMININE, GrammaticalCase.DATIVE, GrammaticalNumber.SINGULAR],
        "χώραν": [Gender.FEMININE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.SINGULAR],

        "χωρῶν": [Gender.FEMININE, GrammaticalCase.GENITIVE, GrammaticalNumber.PLURAL],
        "χώραις": [Gender.FEMININE, GrammaticalCase.DATIVE, GrammaticalNumber.PLURAL],



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

@Test
void testAccGen() {

    GreekString ambiguous = new GreekString("χώρας",true)
    MorphologicalAnalysis morph = mp.parseGreekString(ambiguous)
    assert morph.analyses.size() == 2
    morph.analyses.each {
        MorphForm form = it.getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.NOUN
        CitableId formIdentification = form.getAnalysis()
        assert formIdentification.getGender() == Gender.FEMININE
        if (formIdentification.getNum() == GrammaticalNumber.SINGULAR) {
            assert (formIdentification.getCas() == GrammaticalCase.GENITIVE)
          } else if (formIdentification.getNum() == GrammaticalNumber.PLURAL) {
              assert (formIdentification.getCas() == GrammaticalCase.ACCUSATIVE)
          }
      }
}
      @Test
      void testNomVoc(){

        // Check also the ambiguous nom/voc forms.
        // Singular:
        def nom_voc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.VOCATIVE ]
        def nom_voc_acc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.VOCATIVE,GrammaticalCase.ACCUSATIVE ]
        GreekString ambiguous = new GreekString("χώρα",true)
        MorphologicalAnalysis morph = mp.parseGreekString(ambiguous)
        assert morph.analyses.size() == 5
        morph.analyses.each {
            MorphForm form = it.getMorphForm()
            assert form.getAnalyticalType() == AnalyticalType.NOUN
            CitableId formIdentification = form.getAnalysis()
            // can't know ordering of analyses, but case must be
            // ONE of these two!

            assert formIdentification.getGender() == Gender.FEMININE
          if (formIdentification.getNum() == GrammaticalNumber.SINGULAR) {
              assert nom_voc.contains(formIdentification.getCas())
            } else if (formIdentification.getNum() == GrammaticalNumber.DUAL) {
                assert nom_voc_acc.contains(formIdentification.getCas())
            }
        }
        // Plural:
        GreekString ambiguousPlural = new GreekString("χῶραι",true)
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


          def gen_dat = [GrammaticalCase.GENITIVE,GrammaticalCase.DATIVE ]

          GreekString gd = new GreekString("γλώτταιν",true)
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



}
