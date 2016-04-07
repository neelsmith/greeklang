package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekSmPP5Imptv {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)



  @Test
  void testUnique() {
    //
    def expectedUnique = [

    "πέπεισο": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.IMPERATIVE],
    "πεπείσθω": [Person.THIRD, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.IMPERATIVE],

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
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("πέπεισθον",true))

    assert morph.analyses.size() == 6 // !!!
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert [Person.SECOND, Person.THIRD].contains(formIdentification.getPerson() )

      assert [Mood.INDICATIVE, Mood.IMPERATIVE].contains(formIdentification.getMood() )
      assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())
    }
  }


  @Test
  void testAmbiguous() {
    MorphologicalAnalysis morph = mp.parseGreekString(new GreekString("πεπείσθων",true))

    assert morph.analyses.size() == 4
    morph.analyses.each { ma ->
      MorphForm form = ma.getMorphForm()
      assert form.getAnalyticalType() == AnalyticalType.CVERB
      CitableId formIdentification = form.getAnalysis()
      assert  formIdentification.getPerson() == Person.THIRD

      assert  formIdentification.getMood() == Mood.IMPERATIVE


      assert  [GrammaticalNumber.DUAL, GrammaticalNumber.PLURAL].contains(formIdentification.getNum())
      assert [Voice.MIDDLE, Voice.PASSIVE].contains(formIdentification.getVoice())



    }
  }


}
