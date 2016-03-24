package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString
import edu.holycross.shot.phonology.Accent

import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail

class TestParseFileSource {
  // Two prerequistes to parsing:
  // 1. A Urn registry and a URN manager to work with it:
  File urnReg = new File("sampledata/smyth/urnregistry/collectionregistry.csv")
  UrnManager umgr = new UrnManager(urnReg)
  // 2. A compiled finite state transducer:
  String fstBinary = "build/smyth/greek.a"

  // The parser class:
  LiteraryGreekParser mp = new LiteraryGreekParser(fstBinary, umgr)

  @Test
  void testMorphologicalParser() {
    File wordsFile = new File("testwords.txt")
    File outputFile = new File("build/analyses.csv")
    outputFile.text = "String,LexicalEntity,MorphologicalForm,Stem,InflectionalRule\n"
    wordsFile.eachLine { l ->
      GreekString gs
      try {
        gs = Accent.normalizeAccent(new GreekString(l,true))
        MorphologicalAnalysis morph  = mp.parseGreekString(gs)
        morph.analyses.each { analysisTriple ->

          MorphForm formObject = analysisTriple.getMorphForm()
          CitableId formIdentification = formObject.getAnalysis()
          AnalysisExplanation explanation = analysisTriple.getAnalysisExplanation()
          String formUrn
          switch (formObject.getAnalyticalType()) {
            case AnalyticalType.NOUN:
            NounForm noun =  new NounForm(formIdentification.getGender(), formIdentification.getCas(), formIdentification.getNum(), null)
            formUrn = noun.getUrn().toString()
            break
            case AnalyticalType.INDECLINABLE:
            IndeclinableForm indecl = new IndeclinableForm()
            formUrn = indecl.getUrn().toString()
            break
          }
          outputFile.append( "${l},${analysisTriple.lexicalEntity},${formUrn},${explanation.stem},${explanation.inflection}\n")

        }
      } catch (Exception e) {
        System.err.println "Something went wrong with ${l} -- " + e.toString()
      }
    }
  }
}
