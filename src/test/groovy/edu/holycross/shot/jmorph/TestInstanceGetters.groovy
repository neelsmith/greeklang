package edu.holycross.shot.jmorph


import static org.junit.Assert.*
import org.junit.Test


class TestInstanceGetters extends GroovyTestCase {


  

  void testGetters() {

    def formArray = ["","singular","","","","masculine","nominative","","noun"]
    MorphForm mf = new MorphForm(formArray)
    assert mf.getCase() == MorphForm.GrammaticalCase.NOMINATIVE
    assert mf.getNumber() == MorphForm.GrammaticalNumber.SINGULAR
    assert mf.getGender() == MorphForm.Gender.MASCULINE
    assert mf.getPartOfSpeech() == MorphForm.PartOfSpeech.NOUN

    def verbArray = ["first","singular","present","indicative","active","","","","verb"]
    MorphForm vb = new MorphForm(verbArray)
    assert vb.getPerson() == MorphForm.Person.FIRST
    assert vb.getNumber() == MorphForm.GrammaticalNumber.SINGULAR
    assert vb.getTense() == MorphForm.Tense.PRESENT
    assert vb.getMood() == MorphForm.Mood.INDICATIVE
    assert vb.getVoice() == MorphForm.Voice.ACTIVE
    assert vb.getPartOfSpeech() ==  MorphForm.PartOfSpeech.VERB

    def ptcplArray = ["","singular","present","participle","active","masculine","nominative","","verb"]
    MorphForm ptcpl = new MorphForm(ptcplArray)
    assert ptcpl.getTense() == MorphForm.Tense.PRESENT
    assert ptcpl.getMood() == MorphForm.Mood.PARTICIPLE
    assert ptcpl.getVoice() == MorphForm.Voice.ACTIVE
    assert ptcpl.getGender() == MorphForm.Gender.MASCULINE
    assert ptcpl.getCase() == MorphForm.GrammaticalCase.NOMINATIVE
    assert ptcpl.getNumber() == MorphForm.GrammaticalNumber.SINGULAR
    assert ptcpl.getPartOfSpeech() ==  MorphForm.PartOfSpeech.VERB

  }


}