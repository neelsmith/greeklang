%% morphology.fst : a Finite State Transducer for ancient Greek morphology %%

% Tokens in our alphabet:
% 1. morphological tags
#include "@workdir@symbols.fst"
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

ALPHABET = $character$ [#morphtags#] [#stemtype#]:<>
$stripstemtype$ = .*

$morph$ = $stems$ $ends$ || $stripstemtype$

$acceptor$ = "<@workdir@acceptor.a>"
$acceptor$ || $morph$

%YIELDS:
%analyze> mhn<noun><fem>is<fem><nom><sg>
%mhn<noun><fem><is_ios><is_ios>is<fem><nom><sg>
