package edu.holycross.shot.greekutils


import static org.junit.Assert.*
import org.junit.Test


class TestFractParts extends GroovyTestCase {


  String seven12ths = 'β ιβ"'

  String third = 'γ"'


  void  testSimpleFracts() {
    MilesianString ms = new MilesianString(seven12ths)
    assert ms.getFractionPart() == seven12ths
    def pieces =  ms.mFract.unitFracts
    assert pieces.size() == 2



    ms = new MilesianString(third)
    assert ms.getFractionPart() == third
    assert ms.mFract.unitFracts.size() == 1
  }

  

}