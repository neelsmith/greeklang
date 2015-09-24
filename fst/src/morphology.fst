%% morphology.fst : a Finite State Transducer for ancient Greek morphology %%

% Tokens in our alphabet:
% 1. morphological tags
#include "@workdir@symbols.fst"
#include "@workdir@extratags.fst"
% 2. ASCII representation of polytonic Greek
#include "@workdir@phonology.fst"


% Assemble list of lexica in gradle build,
% and insert here with token filter:
$stemraw$ = "@workdir@lexicon.fst" |  "@workdir@iliad.fst"
$stems$ = $stemraw$

% Assemble list of stemtypes in gradle build,
% and insert here with token filter:
$basicend$ = "<@workdir@inflection.a>"
$extrainfl$ = "<@workdir@extrainfl.a>"

$ends$ = $basicend$ | $extrainfl$


$morph$ = $stems$ $separator$ $separator$ $ends$

% #morphtags# is defined in "symbols.fst"
% #stemtype#  is defined in "stemtypes.fst"
% #extratag#  is defined in "extratgs.fst"
ALPHABET = [#character#] [#extratag#]:<> [#morphtags#]:<> [#stemtype#]:<> [#separator#]:<>
$striptags$ = .*

$acceptor$ = "<@workdir@acceptor.a>"
$acceptor$ || $morph$ || $striptags$
