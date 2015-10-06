% harness for testing morphology of regular omega verbs
#ltr# = a-z
#smooth# =  \)
#rough# = \(
#breathing# = #smooth# #rough#
#alphachar# = #ltr# #breathing#

$w_princparts$ = "<w_princparts.a>"

$synoptic$ = <n64316><#>lu<verb><w_regular><ml>\:\:<w_regular> ( \
  w<1st><sg><pres><indic><act> |\
  omai<1st><sg><pres><indic><mid> |\
  a<1st><sg><aor><indic><act> |\
  amhn<1st><sg><aor><indic><mid> |\
  w<1st><sg><fut><indic><act> |\
  omai<1st><sg><fut><indic><mid> |\
  omai<1st><sg><fut><indic><mid> |\
  hsomai<1st><sg><fut><indic><pass> |\
  hn<1st><sg><aor><indic><pass> |\
  a<1st><sg><pft><indic><act> |\
  mai<1st><sg><pft><indic><pass> \
)


#urn# = <n64316>
#pos# = <verb>
#tense# = <pres><impft><aor><pft><plupft><fut><futpft>
#person# = <1st>
#number# = <sg>
#mood# = <indic>
#voice# = <act><mid><pass>

#morphtag# = #pos# #person# #number# #tense# #mood# #voice#

#stemtype# = <w_regular>

#extras# = <ml><hmt>


% Formatting for final display
ALPHABET = [#alphachar#] [#morphtag#]:<> [#urn#]:<> [\:]:<> [<#>]:<> [#stemtype#]:<> [#extras#]:<>
$striptag$ = .*




$synoptic$ || $w_princparts$ || $striptag$
