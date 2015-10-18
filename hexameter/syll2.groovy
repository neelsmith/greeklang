// syll2.groovy
def wds = ["mhnin", "aeide", "qea", "phlhi+adew", "axilhos", "oulomenhn", "h", "muri'" ,"axaiois", "eqnos", "sofizw", "astron", "pragma", "sofizomenos"]


// Smyth 140B
// stop: pbftdqkgx
// liq: mn
java.util.regex.Pattern stop_liq = ~/([aeiouhw\|])([bgdzqklmncprstfxy]*[pbftdqkgx][mnr])/
java.util.regex.Pattern mn = ~/([aeiouhw\|])mn/

// add:
// sigma rules
// split (vowel + liquid) - consonant









// Smyth 140A

// split diphthong-verb combos
java.util.regex.Pattern dv = ~/(ai|oi|ei|au|eu|ou|hu|wu|ui)([aeiouhw])/
java.util.regex.Pattern vd = ~/([aeiouhw])(ai|oi|ei|au|eu|ou|hu|wu|ui)/
// split double consonants
java.util.regex.Pattern dubble = ~/(b{2}|g{2}|d{2}|z{2}|q{2}|k{2}|l{2}|m{2}|n{2}|p{2}|r{2}|s{2}|t{2}|f{2}|x{2})/



// vowel-consonant-vowel
java.util.regex.Pattern vcv = ~/([aeiouhw\|\+])([bgdzqklmncprstfxy][aeiouhw])/

def testMap = [
  /*"sofizomenos": "so#fi#zo#me#nos",
  "agw":"a#gw",
  "eqnos" : "e#qnos",
  "limnh" : "li#mnh",*/
  "alhqeia": "a#lh#qei#a",
  "qalatta" : "qa#lat#ta",
  "anqrwpoi" : "an#qrw#poi",
  "aeide" : "a#ei#de",
  "poios" : "poi#os"
  //"tuptw" : "tu#ptw",
  //"astron" : "a#stron"

]
boolean verbose = true
testMap.each { w ->
  println "analyze " + w.key

  // dipthong-vowel splits
  String sylls = w.key.replaceAll(dv) { fullMatch, dipth, vow ->
    dipth + "#" + vow
  }
  if (verbose) { println "\tafter dv " + sylls }
  // vowel-dipthong splits
  sylls = sylls.replaceAll(vd) {fullMatch, vow, dipth ->
    vow + "#" + dipth
  }
  if (verbose) { println "\tafter vd " + sylls }

  // double consonants split
  sylls = sylls.replaceAll(dubble) { fullMatch, doubled ->
    doubled[0] + "#" + doubled[1]
  }
  if (verbose) { println "\tafter dubble " + sylls }

  /*
  String pass1 = w.key.replaceAll(vcv) { fullMatch, v, cv ->
    v + "#" + cv
  }
  String pass2 = pass1.replaceAll(vcv) { fullMatch, v, cv ->
    v + "#" + cv
  }
  String p3 = pass2.replaceAll(stop_liq) {fullMatch, preceding, openSyll ->
    preceding + "#" + openSyll
  }
  p3 = p3.replaceAll(mn) { fullMatch, preceding ->
    preceding + "#mn"
  }
  println w.key + "-> " + p3

  */


  println "\t" + w.key + "-> " + sylls//.split(/#/)
  //assert w.value == sylls
}
