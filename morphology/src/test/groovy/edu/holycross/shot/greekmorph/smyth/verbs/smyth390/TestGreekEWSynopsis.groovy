package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekEWSynopsis {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)


  @Test
  void testUnique() {
    //
    def expectedUnique = [

    "ἐποίησα": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.INDICATIVE, Voice.ACTIVE],
    "πεποίηκα": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PERFECT, Mood.INDICATIVE, Voice.ACTIVE],
    //"ἐπεποιήκη": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PLUPERFECT, Mood.INDICATIVE, Voice.ACTIVE],
    "ποιοίην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.PRESENT, Mood.OPTATIVE, Voice.ACTIVE],
    "ποιήσοιμι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.FUTURE, Mood.OPTATIVE, Voice.ACTIVE],
    "ποιήσαιμι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.ACTIVE],
    "ποίησον": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.IMPERATIVE, Voice.ACTIVE],

    "ποιηθησοίμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.FUTURE, Mood.OPTATIVE, Voice.PASSIVE],
    "ποιηθήσομαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.FUTURE, Mood.INDICATIVE, Voice.PASSIVE],
    "ἐποιήθην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.INDICATIVE, Voice.PASSIVE],
    "ποιηθείην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.PASSIVE],

    "ποιήθητι": [Person.SECOND, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.IMPERATIVE, Voice.PASSIVE],

    "ἐποιησάμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.INDICATIVE, Voice.MIDDLE],
    "ποιήσωμαι": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.SUBJUNCTIVE, Voice.MIDDLE],
    "ποιησαίμην": [Person.FIRST, GrammaticalNumber.SINGULAR, Tense.AORIST, Mood.OPTATIVE, Voice.MIDDLE],
    // poihqw=
    ]
    // poiw = indic or sub
    // poihsw =  fut indic or aor subj
    // epoioun = 1 s or 3 pl
    // ποιει = indic or imptv
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
  }



}
