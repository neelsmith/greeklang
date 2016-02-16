% verb.fst
% Limits input to valid morphological analyses of conjugated verbal forms.
% Works correctly with input like this:
% <coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>
%

#include "@workdir@symbols.fst"

$=verbclass$ = [#verbclass#]
$verbanalysis$ = [#stemchars#]+<verb><w_regular>[#extratag#]*\:\:<w_regular>[#letter#]*[#person#][#number#][#tense#][#mood#][#voice#][#extratag#]*

$princparts$ =  "<@workdir@acceptors/verb/w_princparts.a>"
$augment$ =  "<@workdir@acceptors/verb/augment.a>"

$verbacceptor$  = $princparts$ || $augment$ || $verbanalysis$

$verbacceptor$
