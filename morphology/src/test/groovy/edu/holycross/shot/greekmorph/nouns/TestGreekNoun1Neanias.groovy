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
          File urnReg = new File("data/smyth/urnregistry/collectionregistry.csv")

          // A URN manager configured with CITE collection abbreviations
          // for both inflectional patterns and lexicon of stems:
          UrnManager umgr = new UrnManager(urnReg)

          // Compiled finite state transducer:
          String litGreekBinary = "build/smyth/greek.a"
          

          @Test
          void testDeclension() {
            // The parser
            LiteraryGreekParser mp = new LiteraryGreekParser(litGreekBinary, umgr)
            mp.debug = 10
            mp.fstParser.debug = 10
            // map keyed by forms to analyze, to a unique GCN of noun form
            def expectedUnique = [


            "νεανίου": [Gender.MASCULINE, GrammaticalCase.GENITIVE, GrammaticalNumber.SINGULAR],
            "νεανίᾳ": [Gender.MASCULINE, GrammaticalCase.DATIVE, GrammaticalNumber.SINGULAR],
            "νεανίαν": [Gender.MASCULINE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.SINGULAR],
            //"νεανία": [Gender.MASCULINE, GrammaticalCase.VOCATIVE, GrammaticalNumber.SINGULAR],


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

      /*
            // Check also the ambiguous nom/voc form.
            def nom_voc = [GrammaticalCase.NOMINATIVE,GrammaticalCase.VOCATIVE ]
            GreekString ambiguous = new GreekString("βουλαί",true)
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
            }*/
          }

}
