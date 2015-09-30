% verb.fst
% Limits input to valid morphological analyses of conjugated verbal forms.
% Works correctly with input like this:
%<n64316><#>lu<verb><w_regular>::<w_regular>w<1st><sg><pres><indic><act>
%

#include "@workdir@symbols.fst"

$=verbclass$ = [#verbclass#]
$verbanalysis$ = [#urn#][#stemchars#]+<verb><w_regular>[#extratag#]*\:\:<w_regular>[#letter#]*[#person#][#number#][#tense#][#mood#][#voice#][#extratag#]*

$princparts$ =  "<@workdir@acceptors/w_princparts.a>"
$augment$ =  "<@workdir@acceptors/augment.a>"

$verbacceptor$  = $princparts$ || $augment$ || $verbanalysis$

$verbacceptor$
