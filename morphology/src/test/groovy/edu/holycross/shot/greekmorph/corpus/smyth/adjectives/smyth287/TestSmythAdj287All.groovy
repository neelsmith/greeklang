package edu.holycross.shot.greekmorph

import org.junit.Test

/** Test of epsilon contract forms in Smyth 310.
*/
class TestSmythAdj287All{
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr, 9)
  // The testing utility:
  TableTester tester = new TableTester(mp)

  @Test
  void testAgathos() {
    File dataFile =  new File("unit_tests_data/smyth/smyth287/smyth287agathos.csv")
    assert tester.testFile(dataFile)
  }


  @Test
  void testMarkos() {
    File dataFile =  new File("unit_tests_data/smyth/smyth287/smyth287makros.csv")
    assert tester.testFile(dataFile)
  }


  @Test
  void testAxios() {
    File dataFile =  new File("unit_tests_data/smyth/smyth287/smyth287axios.csv")
    assert tester.testFile(dataFile)
  }



}
