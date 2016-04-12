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
    System.err.println "Constructed table test with parser debug level set to " + mp.debug
  }



  /** Reads a test file with expected analyses and returns a
  * linked has map of analytical data keyed by surface form.
  * @param f File in .csv format with exepected analyses.
  * @returns Hash map of surface forms to a list of analytical data.
  */
  def indexFile(File f) {
    def expected = []
    def lineNum = 0
    f.eachLine { l ->
      if (lineNum >  0) {
        def cols = l.split(/,/)
        if (cols.size() > 2) {
          expected.add(cols)
        } else {
          System.err.println "Wrong number of columns: " + cols
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
    System.err.println "Indexed ${f} to :"
    System.err.println indexedList
    indexedList.keySet().each { greek ->
      System.err.println "Comparing  analyses for " + greek
      def expectedAnalyses = indexedList[greek]
      System.err.println "Expecting " + expectedAnalyses
      GreekString gs = new GreekString(greek,true)
      MorphologicalAnalysis morph = mp.parseGreekString(gs)
      def actualAnalyses = morph.analyses
      System.err.println "Got actual list " + actualAnalyses
      assert actualAnalyses.size() == expectedAnalyses.size()


      def actualSet = []
      actualAnalyses.each { ma ->
        MorphForm form = ma.getMorphForm()
        CitableId formIdentification = form.getAnalysis()
        actualSet.add(formIdentification)
      }
      System.err.println "Actual set: " + actualSet

      def expectedSet = []
      expectedAnalyses.eachWithIndex { analysis, i ->
        String typeToken =  "<" + analysis[0] + ">"
        analysis = analysis.drop(1)
        AnalyticalType atype =  AnalyticalType.getByToken(typeToken)
        System.err.println "Analyze ${typeToken} as type " + atype
        switch (atype) {
          case AnalyticalType.PARTICIPLE:
          ParticipleForm pf = new ParticipleForm(analysis)
          expectedSet.add(pf)
          break

          case AnalyticalType.INFINITIVE:
          InfinitiveForm inf = new InfinitiveForm(analysis)
          expectedSet.add(inf)
          break


          case AnalyticalType.VERBAL_ADJECTIVE:
          VerbalAdjectiveForm va = new VerbalAdjectiveForm(analysis)
          expectedSet.add(va)
          break


          case AnalyticalType.CVERB:
          VerbForm vf = new VerbForm(analysis)
          expectedSet.add(vf)
          break


          case AnalyticalType.NOUN:
          NounForm nf = new NounForm(analysis)
          expectedSet.add(nf)
          break

          case AnalyticalType.ADJECTIVE:
          AdjectiveForm af = new AdjectiveForm(analysis)
          expectedSet.add(af)
          break

          default:
          throw new Exception("Unrecognized analytical type from ${typeToken}")
          break

        }
      }
      System.err.println "expectedSet: " + expectedSet
      assert actualSet as Set == expectedSet as Set

    }

    return true
  }


}
