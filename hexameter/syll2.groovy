// syll2.groovy
def wds = ["mhnin", "aeide", "qea", "phlhi+adew", "axilhos", "oulomenhn", "h", "muri'" ,"axaiois", "eqnos", "sofizw", "astron", "pragma", "sofizomenos"]

java.util.regex.Pattern consonant = ~/[bgdzqklmncprstfxy]/

java.util.regex.Pattern vowel = ~/[aeiouhw]/


java.util.regex.Pattern diphth = ~/(ai|oi|ei)/


// Smyth 140B
// stop: pbftdqkgx
// liq: mn
java.util.regex.Pattern stop_liq = ~/([aeiouhw\|])([bgdzqklmncprstfxy]*[pbftdqkgx][mnr])/
java.util.regex.Pattern mn = ~/([aeiouhw\|])mn/

// add:

// sigma rules
// split (vowel + liquid) - consonant

// split double consonants
java.util.regex.Pattern dubble = ~/([bgdzqklmnprstfx]{2})/





// Smyth 140A

// split diphthong-verb combos
java.util.regex.Pattern dv = ~/(ai|oi|ei|au|eu|ou|hu|wu|ui)([aeiouhw])/
java.util.regex.Pattern vd = ~/([aeiouhw])((ai|oi|ei|au|eu|ou|hu|wu|ui))/

java.util.regex.Pattern vcv = ~/([aeiouhw\|\+])([bgdzqklmncprstfxy][aeiouhw])/

def testMap = [
  /*"sofizomenos": "so#fi#zo#me#nos",
  "agw":"a#gw",
  "eqnos" : "e#qnos",
  "limnh" : "li#mnh",*/
  "alhqeia": "a#lh#qei#a",
  "qalatta" : "qa#lat#ta",
  "anqrwpoi" : "an#qrw#poi"
  //"tuptw" : "tu#ptw",
  //"astron" : "a#stron"

]
testMap.each { w ->

  String sylls = w.key.replaceAll(dv) { fullMatch, dipth, vow ->
    println "match data: " + fullMatch + ":" + dipth + ":" + vow
    dipth + "#" + vow

  }


  sylls = sylls.replaceAll(dubble) { fullMatch, doubled ->
    doubled[0] + "#" + doubled[1]
  }

  println w.key + "-> " + sylls.split(/#/)
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
  assert w.value == p3
  */
}
