%% morphology.fst : a Finite State Transducer for ancient Greek morphology
%
% All symbols used in the FST:
#include "@workdir@allsymbols.fst"
%
% Dynamically loaded lexica of stems:
$stems$ = @lexica@
%
% Dynamically loaded inflectional rules:
$ends$ =  "<@workdir@inflection.a>" | @extrafstrules@
%
% Morphology data is the crossing of stems and endings:
$morph$ = $stems$ $separator$ $separator$ $ends$
%
% Acceptor filters for content satisfying requirements for morphological analysis
$acceptor$ = "<@workdir@acceptor.a>"

% Formatting: strip out all tags at surface level.
%
% #morphtag# is defined in "symbols.fst"
% #stemtype#  is defined in "stemtypes.fst"
% #extratag#  is defined in "extratgs.fst"
ALPHABET = [#character#] [#extratag#]:<> [#morphtag#]:<> [#stemtype#]:<> [#separator#]:<> [#urn#]:<>
$striptags$ = .*


% Final transducer:
$acceptor$ || $morph$ || $striptags$

% Examples of translations from input to analysis:
% input:  mhnis
% output: <n67485>mhn<noun><fem><is_ios>::<is_ios>is<fem><nom><sg>
% input:  luw
% output: <n64316><#>lu<verb><w_regular>::<w_regular>w<1st><sg><pres><indic><act>
