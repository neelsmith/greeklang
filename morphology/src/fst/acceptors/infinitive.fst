% Acceptor pattern for infinitives:

#include "@workdir@symbols.fst"
$omega_stems$ = "<@workdir@/acceptors/infinitive/w_infin_princparts.a>"


$=verbclass$ = [#verbclass#]
$squashinfinurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$  <infin> [#stemchars#]*  [#tense#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


$omega_stems$  || $squashinfinurn$
