// syll2.groovy
def wds = ["mhnin", "aeide", "qea", "phlhi+adew", "axilhos", "oulomenhn", "h", "muri'" ,"axaiois", "eqnos", "sofizw", "astron", "pragma", "sofizomenos"]


// Smyth 140B
// stop: pbftdqkgx
// liq: mn
java.util.regex.Pattern stop_liq = ~/([aeiouhw\|])([bgdzqklmncprstfxy]*[pbftdqkgx][mnr])/
// add:
// sigma rules. no.
// split (vowel + liquid) - consonant









// Smyth 140.


// split diphthong-verb combos
java.util.regex.Pattern dv = ~/(ai|oi|ei|au|eu|ou|hu|wu|ui)([aeiouhw])/
java.util.regex.Pattern vd = ~/([aeiouhw])(ai|oi|ei|au|eu|ou|hu|wu|ui)/
// split successive vowels otherwise

// mn starts a syllable
java.util.regex.Pattern mn = ~/([aeiouhw\|\+])mn/
// but otherwise, split when liquidy syllable ender follows a vowel:
java.util.regex.Pattern split_ender = ~/([aeiouhw\|\+])([lmnr])([bgdzqkcprstfxy]+)/
// split double consonants
java.util.regex.Pattern dubble = ~/(b{2}|g{2}|d{2}|z{2}|q{2}|k{2}|l{2}|m{2}|n{2}|p{2}|r{2}|s{2}|t{2}|f{2}|x{2})/
// other consonant clusters stay together.  Apply this rule later in pipline!
java.util.regex.Pattern consclust = ~/([aeiouhw\|\+])([bgdzqkpcstfxy][mnbgdzqklcprstfxy]+)/
// vowel-consonant-vowel
java.util.regex.Pattern vcv = ~/([aeiouhw\|\+])([bgdzqklmncprstfxy][aeiouhw])/




def testMap = [
  "sofizomenos": "so#fi#zo#me#nos",
  "agw":"a#gw",
  "eqnos" : "e#qnos",
  //"ogdoos": "o#gdo#os",
  "exqos": "e#xqos",
  "limnh" : "li#mnh",
  "alhqeia": "a#lh#qei#a",
  "qalatta" : "qa#lat#ta",
  "anqrwpoi" : "an#qrw#poi",
  "aeide" : "a#ei#de",
  "poios" : "poi#os",
  "tuptw" : "tu#ptw",
  "astron" : "a#stron",
  "pragma" : "pra#gma",
  "anqos" : "an#qos",
  "elpis" : "el#pis",
  "ergma" : "er#gma"

]
boolean verbose = true
testMap.each { w ->
  println "analyze " + w.key

  // mn starts a syllable
  String sylls = w.key.replaceAll(mn) { fullMatch, vow ->
        vow + "#mn"
  }
  if (verbose) { println "\tafter mn " + sylls }
  // split liquids and cons
  sylls = sylls.replaceAll(split_ender) { fullMatch, vow, liq, stopcons ->
    vow +  liq + "#" +stopcons
  }
  if (verbose) { println "\tafter split_ender " + sylls }

  // dipthong-vowel splits
  sylls = sylls.replaceAll(dv) { fullMatch, dipth, vow ->
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

  // Otherwise, consonant clusters start a syllable
  sylls = sylls.replaceAll(consclust) { fullMatch, v, cons ->
      v + "#" + cons
  }
  if (verbose) { println "\tafter consclust " + sylls }

  // In 2 passes, replace vowel-consonant-vowel pattern
  sylls = sylls.replaceAll(vcv) { fullMatch, v, cv ->
    v + "#" + cv
  }
  sylls = sylls.replaceAll(vcv) { fullMatch, v, cv ->
    v + "#" + cv
  }
  if (verbose) { println "\tafter 2 passes of vcv " + sylls }




  println "\t" + w.key + "-> " + sylls//.split(/#/)
  assert w.value == sylls
}
