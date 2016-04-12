package edu.holycross.shot.greekmorph


import edu.holycross.shot.listutils.ListDiff
import edu.holycross.shot.orthography.GreekString
import edu.holycross.shot.orthography.GreekOrthography
import edu.holycross.shot.orthography.GreekWord
import edu.holycross.shot.phonology.Accent
import edu.holycross.shot.phonology.AccentPattern
import edu.holycross.shot.phonology.Syllable
import edu.harvard.chs.cite.CiteUrn
import edu.harvard.chs.cite.CtsUrn

/** A Greek morphological parser.
*/
class LiteraryGreekParser implements GreekParser {

  Integer debug  = 0

  /** Implementation of accent-free Greek morphology
  * in a finite state transducer. */
  FstParser fstParser

  /** Manager for expanding collection IDs to full CITE URNs. */
  UrnManager urnManager


  
  /** Constructor with location of sfst binary and
  * a system for expanding abbreviated URN references.
  * @param fstBinary Full path to binary sfst (.a) file.
  * @param umgr UrnManager configured for collections cited
  * in stem lexica for this corpus.
  */
  LiteraryGreekParser(String fstBinary, UrnManager umgr) {
    fstParser = new FstParser(fstBinary)
    urnManager = umgr
  }
  
  LiteraryGreekParser(String fstBinary, UrnManager umgr, Integer debugLevel) {
    debug = debugLevel
    fstParser = new FstParser(fstBinary)
    urnManager = umgr
  }


  String fstStringToGreekString(String s) {
    String greek = s.replaceFirst("<sm>", "\\)").replaceFirst("<ro>","\\(").replaceFirst("<#>","").replaceFirst("<isub>","\\|")
    if (debug > 1) { System.err.println "COnverted " + s + " to " + greek}
    return greek
  }

  /** Determines if form retrieved from FST parser should be considered a
   * match for GreekString gs.
    // Add accent to form retrieved from FST based on analysisInfo.
    // Method is true if accented form we create matches gs.
   * @param gs GreekString submitted for analysis.
   * @param analysisInfo Parsed results from FST parser.
   */
  boolean checkNounAccent(GreekString gs, FstAnalysisParser analysisInfo) {
    // Normalized, canonically accented form to compare with gs:
    GreekWord accented
    // Surface form from FST parser:
    GreekWord retrievedForm = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())

    String inflectionTag = analysisInfo.getInflectionTag()
    GreekString fstSurfaceString = new GreekString(analysisInfo.surfaceInflection)
    accented = LiteraryGreekNounAccent.getAccentedNounForm(fstSurfaceString, analysisInfo)


    if (debug > 0 ) {
      System.err.println "Check noun accent by comparing ${accented} to ${gs}"
      System.err.println "(removing quanity markers to get " + accented.toString().replaceAll("[_^]","") + ")"
    }
    return (accented.toString().replaceAll("[_^]","") == gs.toString())
  }




    boolean checkPronounAccent(GreekString gs, FstAnalysisParser analysisInfo) {
    // Normalized, canonically accented form to compare with gs:
    GreekWord accented
    // Surface form from FST parser:
    GreekWord retrievedForm = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())

    String inflectionTag = analysisInfo.getInflectionTag()

    // see if retrieved from is pre-accented.
    //inflectionTag
    // if (isPreAccented(inflectionTag)) {
    if (Accent.hasAccent(retrievedForm)) {
      System.err.println "${inflectionTag} class is already accented!"
      accented = retrievedForm
    } else {
      GreekString fstSurfaceString = new GreekString(analysisInfo.surfaceInflection)
      accented = LiteraryGreekPronounAccent.getAccentedPronForm(fstSurfaceString, analysisInfo)
    }


    if (debug > 0 ) {
      System.err.println "Check noun accent by comparing ${accented} to ${gs}"
      System.err.println "(removing quanity markers to get " + accented.toString().replaceAll("[_^]","") + ")"
    }
    return (accented.toString().replaceAll("[_^]","") == gs.toString())
  }




  /**
   * @param gs Greek string submitted for analysis.
   * @param analysisInfo Proposed analysis of unaccented form.
   */
  boolean checkAdjAccent(GreekString gs, FstAnalysisParser analysisInfo) {
    // Normalized, canonically accented form to compare with gs:
    GreekWord accented
    // Surface form from FST parser:
    GreekWord retrievedForm = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())

    String inflectionTag = analysisInfo.getInflectionTag()
    if (debug > 1) { System.err.println "ADJ: ${retrievedForm} with infl tag ${inflectionTag}"}
    // see if retrieved from is pre-accented.
    //inflectionTag
    if (Accent.hasAccent(retrievedForm)) {
      System.err.println "${inflectionTag} class is already accented!"
      accented = retrievedForm
    } else {
      GreekString fstSurfaceString = new GreekString(analysisInfo.surfaceInflection)
      if (debug > 1) { System.err.println "Surface form of analysis: " + fstSurfaceString}
      accented = LiteraryGreekAdjectiveAccent.getAccentedAdjForm(fstSurfaceString, analysisInfo)
    }


    if (debug > 0 ) {
      System.err.println "Check adjective accent by comparing ${accented} to ${gs}"
      System.err.println "(removing quanity markers to get " + accented.toString().replaceAll("[_^]","") + ")"
    }
    return (accented.toString().replaceAll("[_^]","") == gs.toString())
  }






  boolean checkAdvAccent(GreekString gs, FstAnalysisParser analysisInfo) {
    // Normalized, canonically accented form to compare with gs:
    GreekWord accented
    // Surface form from FST parser:
    GreekWord retrievedForm = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())

    String inflectionTag = analysisInfo.getInflectionTag()
    if (debug > 1) { System.err.println "ADJ: ${retrievedForm} with infl tag ${inflectionTag}"}
    // see if retrieved from is pre-accented.
    //inflectionTag
    if (isPreAccented(inflectionTag)) {
      System.err.println "${inflectionTag} class is already accented!"
      accented = retrievedForm
    } else {
      GreekString fstSurfaceString = new GreekString(analysisInfo.surfaceInflection)
      if (debug > 1) { System.err.println "Surface form of analysis: " + fstSurfaceString}
      accented = LiteraryGreekAdverbAccent.getAccentedAdverbForm(fstSurfaceString, analysisInfo)
    }


    if (debug > 0 ) {
      System.err.println "Check adverb accent by comparing ${accented} to ${gs}"
      System.err.println "(removing quanity markers to get " + accented.toString().replaceAll("[_^]","") + ")"
    }
    return (accented.toString().replaceAll("[_^]","") == gs.toString())
  }




  // AOR PASS SHOULD GET SPECIAL ACCENT
  boolean checkInfinitiveAccent(GreekString gs, String retrievedString, FstAnalysisParser analysisInfo) {
    System.err.println  "inf acc: gs = ${gs}, retrieved = ${retrievedString}"
    GreekWord retrievedForm = new GreekWord(retrievedString)
    MorphForm morphForm = analysisInfo.getMorphForm()
    InfinitiveForm  form = morphForm.getAnalysis()
    System.err.println "Infin.accent: retrieve form " + retrievedForm
    System.err.println "Analysis info " + analysisInfo + " of class " + analysisInfo.getClass()
    switch(form.getTense()) {


     
    case Tense.PERFECT:
    GreekWord accentedForm = Accent.addPenultAccent(retrievedForm,true)
    return accentedForm.toString().replaceAll("[_^]","")  == gs.toString()
    break

      
    default:
    if (Accent.hasAccent(retrievedForm)) {
      return retrievedForm
    } else {
      GreekWord accentedForm = Accent.addRecessiveAccent(retrievedForm)
      return accentedForm.toString().replaceAll("[_^]","")  == gs.toString()
    }
    break
    }
  }



  boolean checkPtcplAccent(GreekString gs,String parserOutput, FstAnalysisParser analysisInfo) {
    GreekWord retrievedForm = new GreekWord(parserOutput)
    MorphForm morphForm = analysisInfo.getMorphForm()
    ParticipleForm  form = morphForm.getAnalysis()    

    
    switch(form.getTense()) {

    default:
    if (Accent.hasAccent(retrievedForm)) {
      return retrievedForm.toString().replaceAll("[_^]","") == gs.toString()
    } else {
      GreekWord accentedForm = Accent.addRecessiveAccent(retrievedForm)
      String accentedStr = accentedForm.toString().replaceAll("[_^]","")
      System.err.println "Compare ptcpl ${accentedStr} with ${gs}"
      return  accentedStr == gs.toString()
    }
    break
    }
  }



  /** Adds the morphologically appropriate accent to the unaccented form
   * generated by the FST, and compares the result to the originally submitted
   * Greek string.
   * @param utf8String The originally sumitted Greek string to check.
   * @param analysisInfo Candidate morphological analysis.
   * @returns True if orginally submitted string matches FST candidate with
   * appropriate accent added.
   */
  boolean checkAccent(String parserOutputString, GreekString utf8String, FstAnalysisParser analysisInfo) {
    // depends on type of analysis
    AnalysisTriple triple = analysisInfo.getTriple()
    MorphForm form = triple.getMorphForm()

    switch (form.getAnalyticalType()) {
      
    case AnalyticalType.NOUN:
    return checkNounAccent(utf8String, analysisInfo)
    break

    case AnalyticalType.PRONOUN:
    return checkPronounAccent(utf8String, analysisInfo)
    break

    case AnalyticalType.ADJECTIVE:
    return checkAdjAccent(utf8String, analysisInfo)
    break

    case AnalyticalType.ADVERB:
    return checkAdvAccent(utf8String, analysisInfo)
    break

    case AnalyticalType.PARTICIPLE:
    return checkPtcplAccent(utf8String, parserOutputString, analysisInfo)
    break

    case AnalyticalType.INFINITIVE:
    return checkInfinitiveAccent(utf8String, parserOutputString, analysisInfo)
    break

    case AnalyticalType.VERBAL_ADJECTIVE:
    GreekWord retrievedForm = new GreekWord(parserOutputString)
    return retrievedForm.toString().replaceAll("[_^]","") == utf8String.toString()
    break

    case AnalyticalType.INDECLINABLE:
    GreekWord retrievedForm = new GreekWord(analysisInfo.getSurfaceStem() + analysisInfo.getSurfaceInflection())
    return retrievedForm.toString().replaceAll("[_^]","") == utf8String.toString()
    break

    case AnalyticalType.CVERB:
    GreekWord retrievedForm = new GreekWord(parserOutputString)
    def formIdentification = form.getAnalysis()
    if (! Accent.hasAccent(retrievedForm)) {
      if (formIdentification.getMood() == Mood.OPTATIVE) {
	retrievedForm = Accent.addRecessiveAccent(new GreekWord(parserOutputString), true)
      } else {
	retrievedForm = Accent.addRecessiveAccent(new GreekWord(parserOutputString))
      }
    }

    if (debug > 0) { System.err.println "Verb: compare  " + retrievedForm + " with submitted " + utf8String}
    return retrievedForm.toString().replaceAll("[_^]","")  == utf8String.toString()
    break

    default:
    System.err.println "MorphologicalParser: analytical type ${triple.morphForm.getAnalyticalType()} not yet implemented"
    return false
    break
    }
  }

  /** Gets a morphological analysis for a Greek string.
  * @param gkStr The string to analyze.
  * @returns A MorphologicalAnalysis object.
  */
  MorphologicalAnalysis parseGreekString(GreekOrthography gkStr) {
    ArrayList analysisList  = []
    if (debug > 0) {System.err.println "\nParsing " + gkStr}

    FstToken fstToken = new FstToken(gkStr)
    if (debug > 0) {System.err.println "MorphologicalAnalysis: submit ${fstToken}"}
    String parseOutput = fstParser.parseToken(fstToken)

    String parsedString
    if (debug > 0) {System.err.println "MorphologicalAnalysis: got ${parseOutput}"}
    parseOutput.eachLine { l ->
      if (l[0] == ">") {
	parsedString = l.replaceFirst(/>[\s]+/,"")
      } else if (l ==~ /[Nn]o result.+/) {
        // omit

      } else {
	if (debug > 0) {System.err.println "Submit to FAP: ${l}"}
        FstAnalysisParser fap = new FstAnalysisParser(l, urnManager)
        if (debug > 0) {System.err.println "parse with FAP: " + fap}
	String underlying = fap.surfaceStem + fap.surfaceInflection
	
	if (debug > 0) { System.err.println "And use compareison string " + parsedString} 
	String convert1 = fstStringToGreekString(parsedString)

	
	ListDiff ldiff = new ListDiff (underlying, convert1)
	String scs = ldiff.scs.join("")
	if (debug > 0) { System.err.println "Merge: " + underlying + " and " + convert1 + " -> " + scs}
	String greekStyle  = fstStringToGreekString(scs)
	if (debug > 0) {System.err.println "Use converted string value " + greekStyle}
        if (checkAccent(greekStyle,gkStr,fap)) {
          analysisList.add(fap.getTriple())
        } else {
          if (debug > 0) {
            System.err.println "Reject ${gkStr}"
          }
        }
      }
    }
    return( new MorphologicalAnalysis(gkStr, analysisList))
  }




}
