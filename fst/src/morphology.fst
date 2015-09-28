%% morphology.fst : a Finite State Transducer for ancient Greek morphology %%

% Tokens in our alphabet:
% 1. morphological tags
#include "@workdir@morphsymbols.fst"
#include "@workdir@stemtypes.fst"

#include "@workdir@extratags.fst"
#include "@workdir@urns.fst"

% 2. ASCII representation of polytonic Greek
#include "@workdir@phonology.fst"


% Assemble list of lexica of stems in gradle build,
% and insert here with token filter:
$stemraw$ = "@workdir@lexicon.fst" |  "@workdir@iliad.fst"
$stems$ = $stemraw$

% Assemble list of inflectional patterns in gradle build,
% and insert here with token filter:
$basicend$ = "<@workdir@inflection.a>"
$extrainfl$ = "<@workdir@extrainfl.a>"

$ends$ = $basicend$ | $extrainfl$


$morph$ = $stems$ $separator$ $separator$ $ends$

% #morphtag# is defined in "symbols.fst"
% #stemtype#  is defined in "stemtypes.fst"
% #extratag#  is defined in "extratgs.fst"
ALPHABET = [#character#] [#extratag#]:<> [#morphtag#]:<> [#stemtype#]:<> [#separator#]:<> [#urn#]:<>
$striptags$ = .*



$acceptor$ = "<@workdir@acceptor.a>"
$acceptor$ || $morph$ || $striptags$


% From input to analysis:
% mhnis
% we get analysis output:
% <n67485>mhn<noun><fem><is_ios>::<is_ios>is<fem><nom><sg>
% Verb example: luw
% We hope to get
% <n64316>lu<verb><w_regular>::<w_regular>w<1st><sg><pres><indic><act>
