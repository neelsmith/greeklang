// Read morpheus stem file, extract nouns,
// format for greeklang parser.


String getGender (ArrayList lst){
  String result = null
  lst.each {
    if (["masc","fem","neut"].contains(it)) {
      result = it
    }
  }
  return result
}
File f = new File(args[0])
f.eachLine { l ->
  if (l ==~ /^:no:.+$/) {
    ArrayList cols = l.split(/[ ]+/)
    if ((cols.size() > 1) && (cols[1] != "os_on")) {
      println cols[0] + ": " + getGender(cols)
    }
  }
}
