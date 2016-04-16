package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Tests demonstrating parsing of nouns from Unicode string.
*/
class TestPaideu383 {
  String fstBinary = "build/smyth/greek.a"
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // The parser:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr, 8)
  TableTester tester = new TableTester(mp)

  @Test
  void testPresAct() {
    File dataFile =  new File("unit_tests_data/smyth/smyth383/paideu-pr-act.csv")
    assert tester.testFile(dataFile)
  }
}
