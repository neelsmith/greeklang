package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekWParticiples {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnique() {
    def expectedUnique = [
    "λύων": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.PRESENT, Voice.ACTIVE],
    "λύσων": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.FUTURE, Voice.ACTIVE],
    "λύσας": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.AORIST, Voice.ACTIVE],
    "λελυκώς": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.PERFECT, Voice.ACTIVE],

    "λυσόμενος": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.FUTURE, Voice.MIDDLE],
    "λυσάμενος": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.AORIST, Voice.MIDDLE],

    "λυθησόμενος": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.FUTURE, Voice.PASSIVE],
    "λυθείς": [Gender.MASCULINE, GrammaticalCase.NOMINATIVE, GrammaticalNumber.SINGULAR, Tense.AORIST, Voice.PASSIVE],
    ]
    expectedUnique.keySet().each { greek ->
      System.err.println "GREEK " + greek
      def expectedAnswer = expectedUnique[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 1
      MorphForm form = morph.analyses[0].getMorphForm()
    }
  }

// MP forms:
// luomenos, lelumenos

}
