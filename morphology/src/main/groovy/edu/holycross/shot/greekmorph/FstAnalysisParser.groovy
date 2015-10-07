package edu.holycross.shot.greekmorph

/**
* Class for parsing output of SFST toolkit's fst-infl.
*/
class FstAnalysisParser {


  String stemString
  String inflectionString

  // all URNs, really
  String lexicalEntity
  String stem
  String inflectionalPattern
  String pos

  // to derive from tags:
  String morphAnalysis
  MorphForm MorphForm

  //
  def stemTags
  def inflTags




  /** Constructor. */
  FstAnalysisParser(String analysisStr) {
      def cols = analysisStr.split(/::/)
      stemString = cols[0]
      inflectionString = cols[1]
      // check that strings are not null before doing findAll
       stemTags = stemString.findAll(/<[^>]+>/)
       inflTags = inflectionString.findAll(/<[^>]+>/)

      stem = stemTags[0]
      lexicalEntity = stemTags[1]
      inflectionalPattern  = inflTags[1]
      if (stemTags[2] != "<#>") {
        pos = stemTags[2]
      } else {
        if (["<infin>", "<ptcpl>","<vadj>"].contains(inflTags[1])) {
          pos = inflTags[1]
        } else {
          pos = "<verb>"
        }
      }
      //morphAnalysis = getMorphForm()
      //  "<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>"
  }



  MorphForm getMorphForm() {
    MorphForm mf  = null
    String urnBase = "urn:cite:morph:form"
    def analyticalType = AnalyticalType.getByToken(pos)
    System.err.println "Analyzing ${stemString} and ${inflectionString} as " + analyticalType
    switch (pos) {
      case "<verb>":
      def person = Person.getByToken(inflTags[2])
      def num = GrammaticalNumber.getByToken(inflTags[3])
      def tense = Tense.getByToken(inflTags[4])
      def mood = Mood.getByToken(inflTags[5])
      def voice = Voice.getByToken(inflTags[6])
      VerbForm verb = new VerbForm(person, num, tense, mood, voice)
      mf = new MorphForm(analyticalType, verb)
      break

      default:
      System.err.println "Unimplemented analytical type: " + analyticalType
      break
      return mf
    }

  }



}
