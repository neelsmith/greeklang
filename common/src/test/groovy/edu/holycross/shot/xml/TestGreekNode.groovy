package edu.holycross.shot.xml

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.orthography.GreekString

class TestGreekNode {
  String xmlSrc = """
  <div n="1">
  <l n="1">Μῆνιν ἄειδε θεὰ <persName n="urn:cite:hmt:pers.pers1">Πηληϊάδεω Ἀχιλῆος</persName>
  </l>

  <l n="2">οὐλομένην· ἡ μυρί' <rs type="ethnic" n="urn:cite:hmt:place.place96"
          >Ἀχαιοῖς</rs> ἄλγε' ἔθηκεν· </l>
  </div>
  """



  @Test
  void testNoNamespace() {
    GreekNode gn  = new GreekNode(xmlSrc, true)
    // collect text from Unicode XML source
    String unicodeStr = gn.collectText()
    def unicodeWordList = unicodeStr.split(/\s/)
    assert unicodeWordList[0] == "Μῆνιν"
    // Use GreekString object to work with ASCII representation
    // of the same thing:
    GreekString nodeGs = new GreekString(unicodeStr, true)
    def asciiWordList =  nodeGs.toString().split(/\s/)
    assert asciiWordList[0] == "mh=nin"

    // Tokens are aligned:
    Integer expectedWords = 11
    assert expectedWords == asciiWordList.size()
    assert expectedWords == unicodeWordList.size()

    // Showing off:
    def insaneUnicodeSort = [
    "Μῆνιν", "Πηληϊάδεω", "θεὰ", "μυρί'", "οὐλομένην·",
    "ἄειδε", "ἄλγε'", "Ἀχαιοῖς", "Ἀχιλῆος", "ἔθηκεν·",
    "ἡ"]
    def rationalGreekStringSort=  [
    "a)xaioi=s","a)/eide", "a)xilh=os", "a)/lge'","e)/qhken:",
    "h(", "qea\\", "mh=nin", "muri/'","ou)lome/nhn:",
    "phlhi+a/dew"]


    assert insaneUnicodeSort == unicodeWordList.sort()
    def gsList = []
    // Add GreekStrings to list in insane order:
    insaneUnicodeSort.each {
      gsList.add(new GreekString(it, true))
    }
    // verify that they sort rationally:
    gsList.sort().eachWithIndex { gs, i ->
      System.err.println gs.toString(true)
      assert rationalGreekStringSort[i] == gs.toString()
    }

  }


    @Test
    void testWrongInput() {
    // default assumption is ASCII encoding, so
    // this should fail:
    assert shouldFail {
      GreekNode asciiGN  = new GreekNode(xmlSrc)
    }
  }


  @Test
  void testExtract() {
    String xmlSrc = """
    <div n="1">
    <l n="1">mh=nin a)/eide qea\\ <persName n="urn:cite:hmt:pers.pers1">phlhi+a/dew a)xilh=os</persName>
    </l>

    <l n="2">ou)lome/nhn: h( muri' <rs type="ethnic" n="urn:cite:hmt:place.place96"
            >a)xai/ois</rs> a)/lge' e)/qhken </l>
    </div>
    """
    GreekNode gn  = new GreekNode(xmlSrc)
    System.err.println "ASCII CCOLLECTED: " + gn.collectText()

  }

  @Test
  void testBadContent() {
    String xmlSrc = "<p>Throw in punctuation that is not valid in GreekString >[]@%</p>"
    assert shouldFail {
      GreekNode gn  = new GreekNode(xmlSrc)
    }
  }
}
