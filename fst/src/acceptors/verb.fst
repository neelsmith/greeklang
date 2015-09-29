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
$=verbclass$ = [#verbclass#]
$person$ = [#person#]
$number$ = [#number#]
$tense$ = [#tense#]
$mood$ = [#mood#]
$voice$ = [#voice#]

$verbacceptor$ =  $urn$ $nonmorph$+ <verb> $=verbclass$  $extratag$* $separator$+ $=verbclass$ $nonmorph$* $person$ $number$ $tense$ $mood$ $voice$ $nonmorph$*


$verbacceptor$
