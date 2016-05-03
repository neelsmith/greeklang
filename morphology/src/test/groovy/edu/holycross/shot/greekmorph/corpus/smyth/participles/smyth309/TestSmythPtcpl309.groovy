package edu.holycross.shot.greekmorph

import org.junit.Test

/** .
*/
class TestSmythPtcpl309 {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr, 9)
  // The testing utility:
  TableTester tester = new TableTester(mp)


  @Test
  void testLuo() {
    File dataFile =  new File("unit_tests_data/smyth/smyth309/smyth309-luo.csv")
    assert tester.testFile(dataFile)
  }


  @Test
  void testEidws() {
    File dataFile =  new File("unit_tests_data/smyth/smyth309/smyth309-eidws.csv")
    assert tester.testFile(dataFile)
  }


    @Test
    void testPaideuo() {
      File dataFile =  new File("unit_tests_data/smyth/smyth309/smyth309-paideuo.csv")
      //assert tester.testFile(dataFile)
    }

}
