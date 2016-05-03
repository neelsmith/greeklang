package edu.holycross.shot.greekmorph

import org.junit.Test

/** .
*/
class TestSmythPtcpl306 {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr, 9)
  // The testing utility:
  TableTester tester = new TableTester(mp)


  @Test
  void testLuo() {
    File dataFile =  new File("unit_tests_data/smyth/smyth306/smyth306-luo.csv")
    assert tester.testFile(dataFile)
  }


  @Test
  void testHistas() {
    File dataFile =  new File("unit_tests_data/smyth/smyth306/smyth306-histas.csv")
    assert tester.testFile(dataFile)
  }




}
