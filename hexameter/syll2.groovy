// syll2.groovy
def wds = ["mhnin", "aeide", "qea", "phlhi+adew", "axilhos", "oulomenhn", "h", "muri'" ,"axaiois", "eqnos", "sofizw", "astron", "pragma", "sofizomenos"]












def testMap = [
  "sofizomenos": "so#fi#zo#me#nos",
  "a)gw":"a#gw",
  "e)qnos" : "e)#qnos",
  "o)gdoos": "o)#gdo#os",
  "e)xqos": "e)#xqos",
  "limnh" : "li#mnh",
  "a)lhqeia": "a)#lh#qei#a",
  "qalatta" : "qa#lat#ta",
  "a)nqrwpoi" : "a)n#qrw#poi",
  "a)eide" : "a)#ei#de",
  "poios" : "poi#os",
  "tuptw" : "tu#ptw",
  "a)stron" : "a)#stron",
  "pragma" : "pra#gma",
  "a)nqos" : "a)n#qos",
  "e)lpis" : "e)l#pis",
  "e)rgma" : "e)r#gma",
  "a)asamhn": "a)#a#sa#mhn",
  "e)u+" : "e)#u+",
  "ou(tos" : "ou(#tos",
  "r(a" : "r(a",
  "dia" : "di#a",
  "die" : "di#e",
  "dw|h" : "dw|#h",
  "eu)+" : "e#u)+",
  "eu+n" : "e#u+n",
  "oi(o" : "oi(#o",
  "pwu+" : "pw#u+",
  "sui+" : "su#i+",
  "tiw" :  "ti#w",
  "a)ll'": "a)ll'",
  "a)mf'" : "a)mf'",
  "e)aa|" : "e)#a#a|",
  "h)u+s" : "h)#u+s",
  "h)i+e" : "h)#i+#e",
  "o)i+w" : " o)#i+#w",
  "oi)w" : "oi)#w",
  "r(ea" : "r(e#a",
  "kien" : "ki#en",
  "kion" : "ki#on",
  "ui(ei+" : "ui(#e#i+",
  "xiwn"  : "xi#wn",
  "a)u+th" : " a)#u+#th"
]


String syllabify(String s) {
boolean verbose = false

  // Smyth 140.


  // split diphthong-verb combos
  java.util.regex.Pattern dv = ~/(ai[\)\(]?|oi[\)\(]?|ei[\)\(]?|au[\)\(]?|eu[\)\(]?|ou[\)\(]?|hu[\)\(]?|wu[\)\(]?|ui[\)\(]?)([aeiouhw])/
  java.util.regex.Pattern vd = ~/([\)\(aeiouhw])(ai|oi|ei|au|eu|ou|hu|wu|ui)/
  // split successive vowels otherwise
  // ALL VOWELS : [aehiouw]
  // Short vowel followed by vowel [aeo] followed by NOT [iu]
  java.util.regex.Pattern sv = ~/([aeo[\)\(]?])([aehow])/

  // Long vowel fllowd by vowel [hw] followed by NOT u
  java.util.regex.Pattern lv = ~/([hw[\)\(]?])([aehiow])/
  // u followed by NOT i
  java.util.regex.Pattern uv = ~/u([aehouw])/

  // mn starts a syllable
  java.util.regex.Pattern mn = ~/([\)\(aeiouhw\|\+])mn/
  // but otherwise, split when liquidy syllable ender follows a vowel:
  java.util.regex.Pattern split_ender = ~/([\)\(aeiouhw\|\+])([lmnr])([bgdzqkcprstfxy]+)/
  // split double consonants
  java.util.regex.Pattern dubble = ~/(b{2}|g{2}|d{2}|z{2}|q{2}|k{2}|l{2}|m{2}|n{2}|p{2}|r{2}|s{2}|t{2}|f{2}|x{2})/
  // other consonant clusters stay together.  Apply this rule later in pipline!
  java.util.regex.Pattern consclust = ~/([\)\(aeiouhw\|\+])([bgdzqkpcstfxy][mnbgdzqklcprstfxy]+)/
  // vowel-consonant-vowel
  java.util.regex.Pattern vcv = ~/([\)\(aeiouhw\|\+])([bgdzqklmncprstfxy][aeiouhw])/


  println "analyze " + s

  // mn starts a syllable
  String sylls = s.replaceAll(mn) { fullMatch, vow ->
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

  // adjacent vowels to split:
  // short followed by non-diphthong
  sylls = sylls.replaceAll(sv) {fullMatch, v1, v2 ->
    v1 + "#" + v2
  }
  if (verbose) { println "\tafter sv " + sylls }
  // long followed by non-diphthong
  sylls = sylls.replaceAll(lv) {fullMatch, v1, v2 ->
    v1 + "#" + v2
  }
  // upsilon followed by non-diphthong
  sylls = sylls.replaceAll(uv) {fullMatch, v ->
    "u#" + v
  }

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




  println "\t" + s + "-> " + sylls//.split(/#/)
  return sylls

}



testMap.each { w ->
  String syllables = syllabify(w.key)
  assert syllables == w.value


}


/*

File f = new File(args[0])
f.eachLine { t ->
  String syllables = syllabify(t)

}
*/
