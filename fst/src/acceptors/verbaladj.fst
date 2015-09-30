%  verbaladj.fst
% Limits input to valid morphological analyses of the verbal adjective
% gen, case, number but no degree
% URN should refer to a verbal lexical entity, but this cannot be
% enforced syntatically.

#include "@workdir@symbols.fst"


$vadjacceptor$ = [#urn#][#stemchars#]+<verb>[#verbclass#][#extratag#]*\:\:<vadj>[#stemchars#]+[#gender#][#case#][#number#]


%<vadj>[#stemchars#]+[#gender#][#case#][#number#][#extratag#]*


$vadjacceptor$

% Example:
% <n64316><#>lu<verb><w_regular>::<vadj>teon<neut><nom><sg>
