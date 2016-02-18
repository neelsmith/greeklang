% verb.fst
% Limits input to valid morphological analyses of conjugated verbal forms.


#include "@workdir@symbols.fst"

$=verbclass$ = [#verbclass#]
$verbanalysis$ = [#stemchars#]+<verb><w_regular>[#extratag#]*\:\:<w_regular>[#letter#]*[#person#][#number#][#tense#][#mood#][#voice#][#extratag#]*

$princparts$ =  "<@workdir@acceptors/verb/w_princparts.a>"
$augment$ =  "<@workdir@acceptors/verb/augment.a>"

$verbacceptor$  = $princparts$ || $augment$ || $verbanalysis$

$verbacceptor$
