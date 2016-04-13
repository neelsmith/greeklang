package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekGmPP5Pft {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)



  @Test
  void testUnique() {
    //
    def expectedUnique = [
    "πέπραγμαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.INDICATIVE],
    "πέπραξαι": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.INDICATIVE],
    "πέπρακται": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.INDICATIVE],
    "πεπράγμεθα": [Person.FIRST, GrammaticalNumber.PLURAL, Tense.PERFECT, Mood.INDICATIVE],

    ]
    expectedUnique.keySet().each { greek ->
      def expectedAnswer = expectedUnique[greek]
      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))

      assert morph.analyses.size() == 2
      morph.analyses.each { ma ->

        MorphForm form = ma.getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.CVERB
        CitableId formIdentification = form.getAnalysis()
        assert formIdentification.getPerson() == expectedAnswer[0]
        assert formIdentification.getNum() == expectedAnswer[1]
        assert formIdentification.getTense() == expectedAnswer[2]
        assert formIdentification.getMood() == expectedAnswer[3]
        assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
      }
    }
  }

  @Test
  void testDual() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("πέπραχθον",true))

    assert morph.analyses.size() == 6
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getNum() == GrammaticalNumber.DUAL
      assert formIdentification.getTense() == Tense.PERFECT


      assert [Person.SECOND, Person.THIRD].contains(formIdentification.getPerson())
      assert [Mood.INDICATIVE,Mood.IMPERATIVE].contains(formIdentification.getMood())
      assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
    }
  }

  @Test
  void testAmbiguous() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("πέπραχθε",true))

    assert morph.analyses.size() == 4
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert formIdentification.getPerson() == Person.SECOND
      assert formIdentification.getNum() == GrammaticalNumber.PLURAL
      assert formIdentification.getTense() == Tense.PERFECT

      assert [Mood.INDICATIVE,Mood.IMPERATIVE].contains(formIdentification.getMood())
      assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
    }
  }


}