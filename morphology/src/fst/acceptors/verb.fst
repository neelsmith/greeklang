#include "@workdir@symbols.fst"
$omega_stems$ = "<@workdir@/acceptors/verb/w_princparts.a>"

$augment$ = "<@workdir@/acceptors/verb/augment.a>"

%% Add contract stems, too

$=verbclass$ = [#verbclass#]
$squashverburn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$ <verb>[#stemchars#]* [#person#] [#number#] [#tense#] [#mood#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

$omega_stems$ || $augment$ || $squashverburn$
