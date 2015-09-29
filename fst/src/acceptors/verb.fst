% verb.fst
% Limits input to valid morphological analyses of conjugated verbal forms.
% works correctly with input like this:
%<n64316><#>lu<verb><w_regular>::<w_regular>w<1st><sg><pres><indic><act>
%

#include "@workdir@symbols.fst"

$=verbclass$ = [#verbclass#]
$verbanalysis$ = [#urn#][#stemchars#]+<verb><w_regular>[#extratag#]*\:\:<w_regular>[#letter#]*[#person#][#number#][#tense#][#mood#][#voice#][#extratag#]*

$princparts$ =  "<@workdir@/acceptors/w_princparts.a>"

$verbacceptor$  = $princparts$ || $verbanalysis$

$verbacceptor$
