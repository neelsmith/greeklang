package edu.holycross.shot.jmorph

//import edu.holycross.shot.greekutils.

import static org.junit.Assert.*
import org.junit.Test


class TestRawFormData extends GroovyTestCase {


  String rawNounGender = ":::::feminine:::noun"
  ArrayList rawFemNounList = ["","","","","","feminine","","","noun"]

  void testRawMorphForm() {
    MorphForm mf = new MorphForm(rawFemNounList, false)
    assert mf.getGender() == MorphForm.Gender.FEMININE
    assert mf.getPartOfSpeech() == MorphForm.PartOfSpeech.NOUN
    // Number not set
    assert mf.getNumber() == null
  }

  void testSplits() {
    ArrayList splitList = rawNounGender.split(/:/)
    MorphForm mf = new MorphForm(rawFemNounList, false)
    assert mf.getGender() == MorphForm.Gender.FEMININE
    assert mf.getPartOfSpeech() == MorphForm.PartOfSpeech.NOUN
  }
}