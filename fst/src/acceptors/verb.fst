% noun.fst
% Limits input to valid morphological analyses of conjugated verbal forms
%
#include "@workdir@symbols.fst"

% #extratag# is defined in "extratags.fst"
$extratag$ = [#extratag#]
% #character# is defined in "phonology.fst"
#nonmorph# = #character# #extratag#
$nonmorph$ = [#nonmorph#]

$urn$ = [#urn#]
$=verb$ = [#verb#]
$person$ = [#person#]
$number$ = [#number#]
$tense$ = [#tense#]
$mood$ = [#mood#]
$voice$ = [#voice#]

$verbacceptor$ =  $urn$ $nonmorph$+ <verb> $=verb$  $extratag$* $separator$+ $=verb$ $nonmorph$* $person$ $number$ $tense$ $mood$ $voice$ $nonmorph$*


$verbacceptor$
