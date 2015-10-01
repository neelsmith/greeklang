% noun.fst
% Limits input to valid morphological analyses of nouns
%
#include "@workdir@symbols.fst"

% #extratag# is defined in "extratags.fst"
$extratag$ = [#extratag#]
% #character# is defined in "phonology.fst"
#nonmorph# = #character# #extratag#
$nonmorph$ = [#nonmorph#]

$urn$ = [#urn#]
% #nounclass# is the set of stemtypes for nouns,
% defined in stemtypes.fst
$=nounclass$ = [#nounclass#]
$nounacceptor$ =  $urn$ $nonmorph$+ <noun> $=gender$ $=nounclass$ $extratag$* $separator$+ $=nounclass$  $nonmorph$* $=gender$ $=case$ $=number$ $nonmorph$*


$nounacceptor$
