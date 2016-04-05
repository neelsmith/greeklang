% participle.fst
% Acceptor for participle pattern:
% tense, voice, gender, case number
#include "@workdir@symbols.fst"




$ptcpl_stems$ = "<@workdir@/acceptors/participle/w_ptcpl_princparts.a>"


$=verbclass$ = [#verbclass#]
$squashptcplurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$ <ptcpl>[#stemchars#]*  [#gender#][#case#][#number#][#tense#]  [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


$ptcpl_stems$  || $squashptcplurn$
