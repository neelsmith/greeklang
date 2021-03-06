package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestSmythW383pres{
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr, 8)
  TableTester tester = new TableTester(mp)



/* Acutally in Smyth 382, not 383.
  @Test
  void testVadjs() {
    File dataFile =  new File("unit_tests_data/smyth/smyth383/smyth383vadj.csv")
    assert tester.testFile(dataFile)
  }
*/


  @Test
  void testPresentAct() {
    File dataFile =  new File("unit_tests_data/smyth/smyth383/smyth383pr-act.csv")
    assert tester.testFile(dataFile)
  }


  @Test
  void testImpftAct() {
    File dataFile =  new File("unit_tests_data/smyth/smyth383/smyth383impft-act.csv")
    assert tester.testFile(dataFile)
  }
}
