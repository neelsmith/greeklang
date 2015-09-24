%% morphology.fst : a Finite State Transducer for ancient Greek morphology %%

#include "@workdir@symbols.fst"
#include "@workdir@phonology.fst"


% Assemble list of lexica in gradle build,
% and insert here with token filter:
$stemraw$ = "@workdir@lexicon.fst" |  "@workdir@iliad.fst"
$stems$ = $stemraw$

% Assemble list of stemtypes in gradle build,
% and insert here with token filter:
$ends$ = "<@workdir@inflection.a>"
$extrainfl$ = "<@workdir@extrainfl.a>"


ALPHABET = $character$ [#morphtags#] [#stemtype#]:<>
$stripstemtype$ = .*

$morph$ = $stems$  ($ends$ | $extrainfl$ ) || $stripstemtype$

% $morph$ YIELDS:
%generate> mhn<fem><is_ios><is_ios>is<nom><sg>
%mhn<fem><is_ios><is_ios>is<nom><sg>
%generate>
%analyze> mhn<fem><is_ios><is_ios>is<nom><sg>
%mhn<fem><is_ios><is_ios>is<nom><sg>


$acceptor$ = "<@workdir@acceptor.a>"



$acceptor$ || $morph$

%$morph$
%$stems$

% analyze> basil<masc><eus_ews><eus_ews>eus<masc><nom><sg>
% basil<masc><eus_ews><eus_ews>eus<masc><nom><sg>
