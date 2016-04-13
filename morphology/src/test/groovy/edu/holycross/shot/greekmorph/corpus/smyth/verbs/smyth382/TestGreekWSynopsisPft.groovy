package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Smyth 382.
*/
class TestGreekWSynopsisPft {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnique() {
    System.err.println "\n\n\nBeginning to test UNIQUE FORMS\n"
    def expectedUnique = [

    "λέλυκα": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.INDICATIVE, Voice.ACTIVE],

    "ἐλελύκη": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE],



    ]

    expectedUnique.keySet().each { greek ->
      def expectedAnswer = expectedUnique[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 1
      MorphForm form = morph.analyses[0].getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == expectedAnswer[0]
      assert formIdentification.getNum() == expectedAnswer[1]
      assert formIdentification.getTense() == expectedAnswer[2]
      assert formIdentification.getMood() == expectedAnswer[3]
      assert formIdentification.getVoice() == expectedAnswer[4]
    }
    System.err.println "\n\nFinished testing UNIQUE FORMS\n"
  }


  @Test
  void testMPForms() {
    System.err.println "\n\n\nBeginning to test MP FORMS\n"
    // luou
    def expectedMP = [


    "λέλυμαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.INDICATIVE],
    "ἐλελύμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE],


    ]

    def mpVoice = [Voice.MIDDLE, Voice.PASSIVE]
    expectedMP.keySet().each { greek ->
      def expectedAnswer = expectedMP[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
System.err.println "Analyses for " + greek + ": " + morph.analyses.size()
      assert morph.analyses.size() == 2
      MorphForm form = morph.analyses[0].getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == expectedAnswer[0]
      assert formIdentification.getNum() == expectedAnswer[1]
      assert formIdentification.getTense() == expectedAnswer[2]
      assert formIdentification.getMood() == expectedAnswer[3]
      assert mpVoice.contains(formIdentification.getVoice())
    }
      System.err.println "\n\n\nFINISHED testing MP FORMS\n"
  }




}
