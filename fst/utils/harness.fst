% harness for testing morphology of regular omega verbs

#include "symbols.fst"
$w_princparts$ = "<acceptors/w_princparts.a>"

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



% Formatting for final display
ALPHABET = [#letter#] [#morphtag#]:<> [#urn#]:<> [\:]:<> [<#>]:<> [#stemtype#]:<> [#extratag#]:<>
$striptag$ = .*




$synoptic$ || $w_princparts$ || $striptag$
