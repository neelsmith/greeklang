package edu.holycross.shot.xml

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestGreekNode {


  @Test
  void testNoNamespace() {
    String xmlSrc = """
    <div n="1">
		<l n="1">Μῆνιν ἄειδε θεὰ <persName n="urn:cite:hmt:pers.pers1">Πηληϊάδεω Ἀχιλῆος</persName>
		</l>

		<l n="2">οὐλομένην· ἡ μυρί' <rs type="ethnic" n="urn:cite:hmt:place.place96"
						>Ἀχαιοῖς</rs> ἄλγε' ἔθηκεν· </l>
    </div>
    """
    GreekNode gn  = new GreekNode(xmlSrc, true)
System.err.println "ALL TEXT: " + gn.collectText().toString(true)
    Integer expectedWords = 11
    String expectedFirst = "mh=nin"
    GreekString nodeTxt = gn.collectText()
    // rm any leading space before splitting:
    def asciiWordList =  nodeTxt.toString().replaceFirst(/^[ ]/,"").split(/\s/)
    assert expectedWords == asciiWordList.size()
    assert asciiWordList[0] == expectedFirst
    
    def unicodeWordList = nodeTxt.toString(true).replaceFirst(/^[ ]/,"").split(/\s/)
    assert expectedWords == unicodeWordList.size()

  }
}
