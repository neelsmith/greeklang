package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestSmythNoun216 {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr, 9)
  // The testing utility:
  TableTester tester = new TableTester(mp)

  @Test
  void testChora() {
    File dataFile =  new File("unit_tests_data/smyth/smyth216/smyth216chora.csv")
    assert tester.testFile(dataFile)
  }

  @Test
  void testFuge() {
    File dataFile =  new File("unit_tests_data/smyth/smyth216/smyth216fuge.csv")
    assert tester.testFile(dataFile)
  }

  @Test
  void testGlotta() {
    File dataFile =  new File("unit_tests_data/smyth/smyth216/smyth216glotta.csv")
    assert tester.testFile(dataFile)
  }

  @Test
  void testMoira() {
    File dataFile =  new File("unit_tests_data/smyth/smyth216/smyth216moira.csv")
    assert tester.testFile(dataFile)
  }

  @Test
  void testNike() {
    File dataFile =  new File("unit_tests_data/smyth/smyth216/smyth216nike.csv")
    assert tester.testFile(dataFile)
  }


  @Test
  void testThalatta() {
    File dataFile =  new File("unit_tests_data/smyth/smyth216/smyth216thalatta.csv")
    assert tester.testFile(dataFile)
  }

}
