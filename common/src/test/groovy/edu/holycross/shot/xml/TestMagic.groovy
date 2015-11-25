package edu.holycross.shot.xml

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestMagic{




  @Test
  void testMagicSettings() {


    String xmlSrc = """
    <div n="1">
    <l n="1">Μῆνιν ἄειδε θεὰ
    <w><persName n="urn:cite:hmt:pers.pers1">Πηλ<unclear>ηϊάδεω</unclear></persName></w>
     <persName n="urn:cite:hmt:pers.pers1">Ἀχιλῆος</persName>
    </l>
    </div>
    """
    GreekNode gn  = new GreekNode(xmlSrc, true)

    // Exercise magic on any node with local name "w"
    gn.setMagic("", "w", "", "")

    assert gn.magicNode == "w"
    String nodeTxt = gn.collectText()
    def asciiWordList =  nodeTxt.toString().replaceFirst(/^[ ]/,"").split(/\s/)
    assert asciiWordList.size() == 5




  }
}
