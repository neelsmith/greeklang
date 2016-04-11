package edu.holycross.shot.greekmorph

import edu.holycross.shot.orthography.GreekString

/**
*
*/
class TableTester {

  /** The  parser to use in testing.
  */
  LiteraryGreekParser  mp


  /** Constructor with a LiteraryGreekParser.
  * @param parser The parser to use.
  */
  TableTester(LiteraryGreekParser parser) {
    mp = parser
  }



  // Index a test file with expected analyses by surface form
  def indexFile(File f) {
    def expected = []
    def lineNum = 0
    f.eachLine { l ->
      if (lineNum >  0) {
        def cols = l.split(/,/)
        if (cols.size() == 7) {
          expected.add(cols)
        }
      }
      lineNum++
    }
    def indexed = [:]
    expected.each { lst ->
      String surfaceForm = lst[0]
      def  analysis = lst.drop(1)
      def analyses = []
      if (indexed[surfaceForm]){
        analyses = indexed[surfaceForm]
      }
      analyses.add(analysis)
      indexed[surfaceForm] = analyses
    }
    return indexed
  }


  /** Compares the data in a .csv file of expeted  analyses
  * to the actual results of submitting the listed forms to
  * a  morphological parser.
  * @param f A .csv file with expected analyses.
  */
  boolean testFile(File f) {
    def indexedList =  indexFile(f)
    indexedList.keySet().each { greek ->
      def expectedAnalyses = indexedList[greek]
      GreekString gs = new GreekString(greek,true)
      System.err.println "Test  parse of " + gs + " against " + expectedAnalyses
      MorphologicalAnalysis morph = mp.parseGreekString(gs)
      def actualAnalyses = morph.analyses

      assert actualAnalyses.size() == expectedAnalyses.size()


      def actualSet = []

      actualAnalyses.each { ma ->
        MorphForm form = ma.getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.PARTICIPLE
        CitableId formIdentification = form.getAnalysis()
        actualSet.add(formIdentification)
      }
      System.err.println "Here is analysis set: "  + actualSet


      def expectedSet = []
      expectedAnalyses.eachWithIndex { analysis, i ->
        String typeToken =  "<" + analysis[0] + ">"
        analysis.drop(1)
        AnalyticalType atype =  AnalyticalType.getByToken(typeToken)
        System.err.println "${i}: " + atype + ",  " + analysis
      }
    }

    return true
  }


  /*
    indexedList.keySet().each { greek ->
      def expectedAnalyses = indexedList[greek]

      MorphologicalAnalysis morph = mp.parseGreekString(new GreekString(greek,true))
      def actualAnalyses = morph.analyses

      assert actualAnalyses.size() == expectedAnalyses.size()


      morph.analyses.each {  ma ->
        MorphForm form = ma.getMorphForm()
        assert form.getAnalyticalType() == AnalyticalType.PARTICIPLE
        CitableId formIdentification = form.getAnalysis()
        System.err.println "Actual analysis: " + formIdentification

      }


      System.err.println "For ${greek}, num expected analyses = " + expectedAnalyses.size()
      expectedAnalyses.eachWithIndex { analysis, i ->
        String typeToken =  "<" + analysis[0] + ">"
        analysis.drop(1)
        AnalyticalType atype =  AnalyticalType.getByToken(typeToken)
        System.err.println "${i}: " + atype + ",  " + analysis

      }
    }*/
}
