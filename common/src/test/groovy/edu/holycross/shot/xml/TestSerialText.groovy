package edu.holycross.shot.xml

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestSerialText {


  @Test
  void testSerialization() {
    String asciiSrc = """
    <p n="1">abg</p>
    """
    String expectedSerialization = '<p n="1"> abg</p>'


    GreekNode asciiNode = new GreekNode(asciiSrc)
    assert asciiNode.toXml() == expectedSerialization
    GreekString gs1 = new GreekString(asciiNode.collectText())

    String uniCodeSrc = """
    <p n="1">ΑΒΓ</p>
    """
    GreekNode unicodeNode = new GreekNode(uniCodeSrc, true)
    GreekString gs2 = new GreekString(unicodeNode.collectText(), true)


    // GreekNode guarantees XML equivalence of toXml() with source,
    // and String identify of collectText output
    assert gs1 == gs2




  }

}
