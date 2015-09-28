/*
Reads a stem file from morpheus source code, and attempts to map entries
on to lexical entity URNs.  Writes out stem info in format for FST lexicon.

*/

String usg = "Usage:  groovy morpheusToFst.groovy <LEXENTFILE> <MORPHEUSSTEMFILE>"
Integer debug = 0
if (args.size() != 2) {
  System.err.println usg
  System.exit(-1)
}

/* This is a 4-column .csv file
The first 2 columns give the id and the beta code string.
*/
File lexEntFile = new File(args[0])
File morphStemFile = new File(args[1])

// maps morpheus labels to our labels
def stemLabelMap = [
"reg_conj" : "w_regular",
"aw_denom" : "aw_contract",
"ew_denom" : "ew_contract",
"ow_denom" : "ow_contract"
]


def formToIdMap = [:]
lexEntFile.eachLine {
  def cols = it.split(/,/)
  String idStr = cols[0]
  String lemma = cols[1]
  formToIdMap[lemma] = idStr
}

System.err.println "Read " + formToIdMap.size() + " lexical entity IDs."



boolean inEntry = false
Integer entryCount = 0
Integer idsFound = 0
String lemma = ""

def fstLexList = []

morphStemFile.eachLine { ln ->
  if (ln.size() == 0) {
    inEntry = false
  }

  if (ln ==~ /^:le:.*/) {
    lemma = ln.replaceFirst(/:le:/,'')
    inEntry = true
    entryCount++
    if (debug  > 0) { System.err.println "${entryCount}. New entry: " + ln }
    if (formToIdMap[lemma]) {
        if (debug  > 0) { println "ID ${formToIdMap[lemma]}" }
      idsFound++
    } else {
        if (debug  > 0) { println "No ID found for ${lemma}." }
    }
  } else if (ln ==~ /^:de:.*/) {
    def stemEntry = ln.replaceFirst(":de:", '').split(/[ ]+/)
    if (stemEntry.size() < 2) {
      System.err.println "Error parsing entry " + stemEntry
    } else {
      String stem = stemEntry[0]
      String stemClass = stemEntry[1]

      if ((stemLabelMap[stemClass]) && (formToIdMap[lemma])) {

        // replace quantity markers with symbols
        stem = stem.replaceAll("\\^", "<short>")
        stem = stem.replaceAll("_", "<long>")
        if (stem ==~ /.+\-.+/) {
          fstLexList.add( "<${formToIdMap[lemma]}>${stem.replaceFirst(/[\-]/,'<#>')}<verb><${stemLabelMap[stemClass]}>")

        } else {
          fstLexList.add( "<${formToIdMap[lemma]}><#>${stem}<verb><${stemLabelMap[stemClass]}>")
        }

      }
    }
  }

}

System.err.println "Matched ${idsFound} IDs for ${entryCount} morpheus stem entries"
System.err.println "Generated ${fstLexList.size()} FST lexicon entries"

fstLexList.each {
  println it
}
