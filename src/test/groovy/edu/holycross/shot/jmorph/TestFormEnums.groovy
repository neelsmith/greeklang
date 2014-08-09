package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestFormEnums extends GroovyTestCase {


  

   void testPersonVals() {
     def personList = ["first","second","third"]
     assert MorphForm.Person.values().size() == personList.size()

     personList.each { p ->
       def personVal = MorphForm.Person.valueOf(p.toUpperCase())
       assert personVal
       assert shouldFail {
	 def badthing = MorphForm.Person.valueOf(p)
       }
     }
   }

  void testTenseVals() {
    def numberList = ["singular","dual","plural"]
    assert MorphForm.GrammaticalNumber.values().size() == numberList.size()
    
    numberList.each { num ->
       def numVal = MorphForm.GrammaticalNumber.valueOf(num.toUpperCase())
       assert numVal
       assert shouldFail {
	 def badthing = MorphForm.GrammaticalNumber.valueOf(num)
       }
     }
  }

  void testNumberVals() {

    def tenseList = ["present","imperfect","future","aorist","perfect","pluperfect"]
    assert MorphForm.Tense.values().size() == tenseList.size()
    
    tenseList.each { tense ->
       def tenseVal = MorphForm.Tense.valueOf(tense.toUpperCase())
       assert tenseVal
       assert shouldFail {
	 def badthing = MorphForm.Tense.valueOf(tense)
       }
     }
  }


  void testMoodVals() {
    def moodList = ["indicative","subjunctive","optative","imperative","participle","vadj"]

    assert MorphForm.Mood.values().size() == moodList.size()
    
    moodList.each { mood ->
       def moodVal = MorphForm.Mood.valueOf(mood.toUpperCase())
       assert moodVal
       assert shouldFail {
	 def badthing = MorphForm.Mood.valueOf(mood)
       }
     }
  }


  void testVoiceVals() {
    def voiceList = ["active","middle","passive"]
    assert MorphForm.Voice.values().size() == voiceList.size()
    
    voiceList.each { v ->
       def voiceVal = MorphForm.Voice.valueOf(v.toUpperCase())
       assert voiceVal
       assert shouldFail {
	 def badthing = MorphForm.Voice.valueOf(v)
       }
     }
  }


  void testGenderVals() {
    def genderList = ["masculine","feminine","neuter"]
    assert MorphForm.Gender.values().size() == genderList.size()
    
    genderList.each { g ->
       def genderVal = MorphForm.Gender.valueOf(g.toUpperCase())
       assert genderVal
       assert shouldFail {
	 def badthing = MorphForm.Gender.valueOf(g)
       }
     }
  }

  void testCaseVals() {

    def caseList = ["nominative","genitive","dative","accusative","vocative"]
    assert MorphForm.GrammaticalCase.values().size() == caseList.size()
    
    caseList.each { c ->
       def caseVal = MorphForm.GrammaticalCase.valueOf(c.toUpperCase())
       assert caseVal
       assert shouldFail {
	 def badthing = MorphForm.GrammaticalCase.valueOf(c)
       }
     }
  }


  void testPosVals() {
    def posList = ["noun","verb","adjective","adverb","conjunction","particle"]
    assert MorphForm.PartOfSpeech.values().size() == posList.size()
    
    posList.each { pos ->
       def posVal = MorphForm.PartOfSpeech.valueOf(pos.toUpperCase())
       assert posVal
       assert shouldFail {
	 def badthing = MorphForm.PartOfSpeech.valueOf(pos)
       }
     }
  }



}