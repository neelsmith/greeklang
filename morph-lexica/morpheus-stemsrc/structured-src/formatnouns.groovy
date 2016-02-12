// Read morpheus stem file, extract nouns,
// format for greeklang parser.


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

println "StemUrn,LexicalEntity,Stem,Gender,InflClass,Accent,Tags"
File f = new File(args[0])
f.eachLine { l ->
  if (l ==~ /^:no:.+$/) {

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

      println "StemUrn,LexicalEntity,${stem},${info[0]},${info[1]},${accPattern},"

    }
  }
}
