%  verbaladj.fst
% Limits input to valid morphological analyses of the verbal adjective
% gen, case, number but no degree
% URN must refer to a verbal lexical entity.
%
% Smyth #471.
%

#include "@workdir@symbols.fst"

% It's not generically correct to use #verbclass# for all
% verbal adjectives: it should be either regular classes such as w_regular
% or 6th part classes.
#vadjclass# = #verbclass#

$vadjacceptor$ = [#urn#][#stemchars#]+<verb>[#vadjclass#][#extratag#]*\:\:<vadj>[#stemchars#]+[#gender#][#case#][#number#]


%<vadj>[#stemchars#]+[#gender#][#case#][#number#][#extratag#]*


$vadjacceptor$

% Example:
% <n64316><#>lu<verb><w_regular>::<vadj>teon<neut><nom><sg>
