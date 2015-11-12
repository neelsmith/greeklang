package edu.holycross.shot.xml

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestUniTranscode {




  @Test
  void testUniTranscode() {
    String asciiSrc = """
    <p n="1">ABG</p>
    """
    GreekNode gn = new GreekNode(asciiSrc, false)
    String transcoded = gn.getUnicodeXml()

    def parsedReply = new XmlParser().parseText(transcoded)
    assert  parsedReply.name() == "p"
    assert parsedReply.attributes().size() == 1
    assert parsedReply.attribute("n") == "1"
    assert parsedReply.text() == "αβγ"
  }

}
