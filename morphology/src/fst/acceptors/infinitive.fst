%infinitive.fst
% Acceptor for infinitive pattern:
% tense, <inf>, voice


#include "@workdir@symbols.fst"


$infinacceptor$ = [#urn#]+[#stemchars#]+<verb>[#verbclass#][#extratag#]*\:\:<infin>[#stemchars#]+[#tense#][#voice#][#persistacc#]




$princparts$ = "<@workdir@acceptors/infinitive/w_infin_princparts.a>"

$princparts$ || $infinacceptor$

% Example:
% <coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<infin>ein<pres><act><penacc>
