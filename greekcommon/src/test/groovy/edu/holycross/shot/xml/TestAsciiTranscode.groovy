package edu.holycross.shot.xml

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestAsciiTranscode {




  @Test
  void testAsciiTranscode() {
    String uniSource = """
    <p n="1">ΑΒΓ</p>
    """
    String asciiSource = """
    <p n="1">ABG</p>
    """

    GreekNode gn = new GreekNode(uniSource, true)
    String transcoded = gn.getUnicodeXml()
    System.err.println "TRANSCODED = " + transcoded

    def parsedReply = new XmlParser().parseText(transcoded)
    assert  parsedReply.name() == "p"
    assert parsedReply.attributes().size() == 1
    assert parsedReply.attribute("n") == "1"
    assert parsedReply.text() == "αβγ"

    GreekNode asciiNode = new GreekNode(asciiSource, false)


  }

}
