package edu.holycross.shot.orthography

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestGSTokens {

  @Test
  void testTokenize() {
    GreekString gs = new GreekString("μῆνιν ἄειδε, θεά, Πηληϊάδεω Ἀχιλῆος", "Unicode")
    def expectedTokens = ["mh=nin", "a)/eide", "qea/", "phlhi+a/dew", "a)xilh=os"]
    ArrayList tokens = gs.tokenize()
    tokens.eachWithIndex { t, i ->
      assert t.toString() == expectedTokens[i]
    }
  }
}
