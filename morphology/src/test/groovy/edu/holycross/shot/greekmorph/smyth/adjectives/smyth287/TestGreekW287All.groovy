package edu.holycross.shot.greekmorph

import org.junit.Test

/** Test of epsilon contract forms in Smyth 310.
*/
class TestGreekW287{
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr, 9)
  // The testing utility:
  TableTester tester = new TableTester(mp)

  @Test
  void testEpsilonContracts() {
    File dataFile =  new File("unit_tests_data/smyth/smyth287/smyth287agathos.csv")
    assert tester.testFile(dataFile)
  }


}
