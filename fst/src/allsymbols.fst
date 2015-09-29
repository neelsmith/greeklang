% allsymbols.fst
% Single include file for all symbols in this FST
%
% Tokens in our alphabet:
% 1. morphological tags
#include "@workdir@morphsymbols.fst"
#include "@workdir@stemtypes.fst"

#include "@workdir@extratags.fst"
#include "@workdir@urns.fst"

% 2. ASCII representation of polytonic Greek
#include "@workdir@phonology.fst"
