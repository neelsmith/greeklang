package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestMacra {

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

/*
    @Test
    void testDeclension() {
      // Add lexicon to URN manager:
      umgr.addCsvFile(lexCsvSource)
      // And, finally, the parser:
      LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)
      mp.debug = 10
      mp.fstParser.debug = 10

      // map keyed by forms to analyze, to a unique GCN of noun form
      def expectedUnique = [
      "ζώνας": [Gender.FEMININE, GrammaticalCase.ACCUSATIVE, GrammaticalNumber.PLURAL]
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
*/
}
