package edu.holycross.shot.jmorph



/**
 * A class 
 * 
 */
class MorphForm {

  // Temporary constructs for debugging:
  Integer SILENT = 0
  Integer WARN =  1
  Integer DEBUG = 2
  Integer VERBOSE = 3
  Integer debugLevel = 0




  def numberList = ["singular","plural"]
  String mNumber 

  def tenseList = ["present","imperfect","future","aorist","perfect","pluperfect"]
  String mTense

  def moodList = ["indicative","subjunctive","optative","imperative","participle","vadj"]
  String mMood

  def voiceList = ["active","middle","passive"]
  String mVoice

  def genderList = ["masculine","feminine","neuter"]
  String mGender

  def caseList = ["nominative","genitive","dative","accusative"]
  String mCase


  def posList = ["noun","verb","adjective"]
  String mPos 

  /** Constructor initialized from colon-separated String.
   * @param srcString a String with 8 fields separated by colons.
   * The required sequence of values is:
   * 1. person
   * 2. number
   * 3. tense
   * 4. mood
   * 5. voice
   * 6. gender
   * 7. case
   * 8. part of speech
   * 
   * @throws Exception if invalid combinations of values are found.
   */
  MorphForm(String srcString) 
  throws Exception {
    def srcArray = srcString.split(/:/)
    if (srcArray.size() != 8) {
      throw new Exception("MorphForm: too few components in srcString (${srcArray.size()})")
    } 
    initForm(srcArray as ArrayList)
  }



  /** Constructor initialized from an ArrayList with 8 elements.
   * The order of the elements is the same as for a colon-delimited
   * String.
   * @param srcArray An ArrayList with 8 elements.
   */
  MorphForm(ArrayList srcArray) 
  throws Exception {
    if (srcArray.size() != 8) {
      throw new Exception("MorphForm: too few components in srcString (${srcArray.size()})")
    } 
    initForm(srcArray)
  }


  /** Initializes gender, case, number values
   * for a noun or adjective.
   * @param formArray ArrayList of 8 elements.
   * @throws Exception if invalid values or combination
   * of values are found.
   */
  void initSubstantive(ArrayList formArray) 
  throws Exception {

    // Check that no inappropriate fields are set:
    [getPerson(formArray), getTense(formArray), getMood(formArray), getVoice(formArray)].each { val ->
      if (val != "") {
	throw new Exception("MorphForm:initSubstantive:  value ${val} should be null for substantive.")
      }
    }



    String genStr = getGender(formArray)
    if (! genderList.contains((genStr))) {
      throw new Exception("MorphForm:initSubstantive:  bad value ${genStr} for gender.")
    } else {
      this.mGender = genStr
    }



    String caseStr = getCase(formArray)
    if (! caseList.contains((caseStr))) {
      throw new Exception("MorphForm:initSubstantive:  bad value ${caseStr} for case.")
    } else {
      this.mCase = caseStr
    }


    String numStr = getNumber(formArray)
    if (! numberList.contains((numStr))) {
      throw new Exception("MorphForm:initSubstantive:  in ${formArray}, bad value ${numStr} for number.")
    } else {
      this.mNumber = numStr
    }

    String pos = getPos(formArray)
    if ((pos == "noun") || (pos == "adjective")) {
      this.mPos = pos
    } else {
      throw new Exception("MorphForm:initSubstantive:  bad value ${pos} for part of speech.")
    }
  }

  /** Initializes member properties.
   * @param formArray ArrayList of 8 elements.
   * @throws Exception if invalid combination
   * of values is found.
   */
  void initForm(ArrayList formArray) 
  throws Exception {

    switch (getPos(formArray)) {

    case "noun":
    initSubstantive(formArray)
    break

    case "verb":
    break

    default:
    throw new Exception("MorphForm: could not initialize form. Unrecognized part of speech #${getPos(formArray)}#")
    break
    }
    
  }




  /** Selects person value from formArray.
   * @param formArray ArrayList of 8 elements.
   * @returns Person value (1st element).
   * @throws Exception if ArrayList is wrong size.
   */
  String getPerson(ArrayList formArray) 
  throws Exception {
    if (formArray.size() != 8) {
      throw new Exception("MorphForm:getCase:  formArray is wrong size (${formArray.size()})")
    }
    return formArray[0]
  }

  /** Selects number value from formArray.
   * @param formArray ArrayList of 8 elements.
   * @returns Gender value (2nd element).
   * @throws Exception if ArrayList is wrong size.
   */
  String getNumber(ArrayList formArray) {
    if (formArray.size() != 8) {
      throw new Exception("MorphForm:getCase:  formArray is wrong size (${formArray.size()})")
    }
    return formArray[1]
  }


  /** Selects tense value from formArray.
   * @param formArray ArrayList of 8 elements.
   * @returns Tense value (3rd element).
   * @throws Exception if ArrayList is wrong size.
   */
  String getTense(ArrayList formArray) {
    if (formArray.size() != 8) {
      throw new Exception("MorphForm:getCase:  formArray is wrong size (${formArray.size()})")
    }
    return formArray[2]
  }



  /** Selects mood value from formArray.
   * @param formArray ArrayList of 8 elements.
   * @returns Mood value (4th element).
   * @throws Exception if ArrayList is wrong size.
   */
  String getMood(ArrayList formArray) {
    if (formArray.size() != 8) {
      throw new Exception("MorphForm:getCase:  formArray is wrong size (${formArray.size()})")
    }
    return formArray[3]
  }



  /** Selects voice value from formArray.
   * @param formArray ArrayList of 8 elements.
   * @returns Voice value (5th element).
   * @throws Exception if ArrayList is wrong size.
   */
  String getVoice(ArrayList formArray) {
    if (formArray.size() != 8) {
      throw new Exception("MorphForm:getCase:  formArray is wrong size (${formArray.size()})")
    }
    return formArray[4]
  }



  /** Selects gender value from formArray.
   * @param formArray ArrayList of 8 elements.
   * @returns Gender value (6th element).
   * @throws Exception if ArrayList is wrong size.
   */
  String getGender(ArrayList formArray) {
    if (formArray.size() != 8) {
      throw new Exception("MorphForm:getCase:  formArray is wrong size (${formArray.size()})")
    }
    return formArray[5]
  }



  /** Selects case value from formArray.
   * @param formArray ArrayList of 8 elements.
   * @returns Case value (7th element).
   * @throws Exception if ArrayList is wrong size.
   */
  String getCase(ArrayList formArray) 
  throws Exception {
    if (formArray.size() != 8) {
      throw new Exception("MorphForm:getCase:  formArray is wrong size (${formArray.size()})")
    }
    return formArray[6]
  }



  /** Selects part of speech value from formArray.
   * @param formArray ArrayList of 8 elements.
   * @returns Case value (8th element).
   * @throws Exception if ArrayList is wrong size.
   */
  String getPos(ArrayList formArray) 
  throws Exception {
    if (formArray.size() != 8) {
      throw new Exception("MorphForm:getCase:  formArray is wrong size (${formArray.size()})")
    }
    return formArray[7]
  }







}