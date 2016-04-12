package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestGreekW383All {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)
  TableTester tester = new TableTester(mp)

  @Test
  void testInfinitives() {
    File dataFile =  new File("unit_tests_data/smyth/smyth383/smyth383infin.csv")
    assert tester.testFile(dataFile)
  }

  @Test
  void testVadjs() {
    File dataFile =  new File("unit_tests_data/smyth/smyth383/smyth383vadj.csv")
    assert tester.testFile(dataFile)
  }

  @Test
  void testPtcpls() {
    File dataFile =  new File("unit_tests_data/smyth/smyth383/smyth383ptcpl.csv")
    assert tester.testFile(dataFile)
  }

  @Test
  void testConjugated() {
    File dataFile =  new File("unit_tests_data/smyth/smyth383/smyth383cverb.csv")
    assert tester.testFile(dataFile)
  }

}
