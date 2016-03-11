// Read morpheus stem file, extract nouns;
// attempt to match with LSJ identifier;
// format output for greeklang parser.
// LSJFILE is a 4-column .csv file like `lsj-lemma.csv` in the root directory
// of this repository.
// STEMFILE is a text file in morpheus stemfile format.
//
// usage: grovy formatnouns.groovy LSJFILE STEMFILE
String base = "lexent."


def idMap = [:]

File lsjFile = new File(args[0])
File stemsFile = new File(args[1])

ArrayList getGenderDeclAccent (ArrayList lst){
  ArrayList decls = ["a_hs", "c_gos", "c_kos", "c_ktos", "eus_ews", "gc_ggos", "h_hs", "hs_eos", "hs_ou", "is_ews", "is_idos", "ma_matos", "n_nos", "os_ou", "r_ros", "s_dos", "s_qos", "s_tos", "us_uos", "w_oos", "wn_onos", "wn_ontos", "wr_oros"]
  ArrayList genders = ["masc","fem","neut"]
  ArrayList accentPatterns = ["stem_acc", "suff_acc", "ant_acc"]
  String gender = null
  String decl = null
  String accent = null

  lst.eachWithIndex { listItem, idx ->
    if (genders.contains(listItem)) {
      gender = listItem

    } else if ( accentPatterns.contains(listItem)) {
      accent  = listItem
    } else if      ( decls.contains(listItem)) {
      decl = listItem
    }
  }

  return [gender, decl, accent]
}



// Load up map of LSJ IDs:
lsjFile.eachLine {
  def cols = it.split(/,/)
  String lsjid = cols[0]
  String lemm = cols[1]
  idMap[lemm] = lsjid
}

String currentLemma = ""
println "StemUrn,LexicalEntity,Stem,Gender,InflClass,Accent,Tags"
stemsFile.eachLine { l ->
  if (l ==~ /^:le:.+$/) {
    currentLemma = l.replaceFirst(":le:", '')
    currentLemma = currentLemma.replaceAll(/[ ]+/,'')
  } else if (l ==~ /^:no:.+$/) {

    ArrayList cols = l.split(/[ ]+/)
    String stem = cols[0].replaceFirst (":no:", '')
    if ((cols.size() > 1) && (cols[1] != "os_on")) {
      ArrayList info = getGenderDeclAccent(cols)
      String accPattern = "stempenacc"
      if (info[2] == "suff_acc") {
        accPattern = "inflacc"
      } else if (info[2] == "stem_acc") {
        accPattern = "stemultacc"

      }


      String lexEnt

      if (idMap.keySet().contains(currentLemma)) {
        lexEnt = idMap[currentLemma]
      } else {
        lexEnt = "XXX"
      }
      String stemUrn = "${lexEnt}_0"
      println "lsjpool.${stemUrn},lexent.${lexEnt},${stem},${info[0]},${info[1]},${accPattern},"

    }
  }
}
