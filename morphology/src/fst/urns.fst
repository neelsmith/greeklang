%
% urns.fst
%
% 1. Lexical entities, summarized in #lexicon#
#include "@workdir@urns/lexent.fst"

% 2. Morphological stems, summarized in #stemurn#
#include "@workdir@urns/morphstems.fst"

% 3. Inflectional patterns, summarized in #inflectionurn#
#include "@workdir@urns/inflectionurns.fst"



#urn# = #lexicon# | #stemurn# | #inflectionurn#
