% symbols.fst
% A single include file for all symbols used in this FST.
%
% 1. morphological tags
#include "@workdir@symbols/morphsymbols.fst"
#include "@workdir@symbols/stemtypes.fst"
%
% 2. ASCII representation of polytonic Greek
#include "@workdir@symbols/phonology.fst"
%
% 3. Other data symbols:
% taxonomic tagging
#include "@workdir@extratags.fst"
% URN ID values
#include "@workdir@urns.fst"
