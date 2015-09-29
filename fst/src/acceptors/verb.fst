% verb.fst
% Limits input to valid morphological analyses of conjugated verbal forms.
%
#include "@workdir@symbols.fst"

$=verbclass$ = [#verbclass#]
%$verbacceptor$ = [#urn#][#stemchars#]+<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#letter#]*[#person#][#number#][#tense#][#mood#][#voice#][#extratag#]*


$verbacceptor$ = [#urn#][#stemchars#]+<verb><w_regular>[#extratag#]*\:\:<w_regular>[#letter#]*[#person#][#number#][#tense#][#mood#][#voice#][#extratag#]*

$verbacceptor$

% works correctly with:
%<n64316><#>lu<verb><w_regular>\:\:<w_regular>w<1st><sg><pres><indic><act>
