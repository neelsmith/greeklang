package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


/** Smyth 382.
*/
class TestSmythW384 {

    String fstBinary = "build/smyth/greek.a"
    File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
    UrnManager umgr = new UrnManager(urnReg)
    // The parser:
    LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr, 9)
    TableTester tester = new TableTester(mp)

    @Test
    void testS384() {
      File dataFile =  new File("unit_tests_data/smyth/smyth384/smyth384.csv")
      assert tester.testFile(dataFile)
    }

}
