% verb.fst
% Acceptor for conjugated verbal forms
#include "@workdir@symbols.fst"
#include "@workdir@extratags.fst"
#include "@workdir@phonology.fst"
#include "@workdir@urns.fst"
#include "@workdir@stemtypes.fst"

% #extratag# is defined in "extratags.fst"
$extratag$ = [#extratag#]
% #character# is defined in "phonology.fst"
#nonmorph# = #character# #extratag#
$nonmorph$ = [#nonmorph#]

$urn$ = [#urn#]
$=verb$ = [#verb#]
$person$ = [<1st>]
$number$ = [#number#]
$tense$ = [#tense#]
$mood$ = [#mood#]
$voice$ = [#voice#]

$verbacceptor$ =  $urn$ $nonmorph$+ <verb> $=verb$  $extratag$* $separator$+ $=verb$ $nonmorph$* $person$ $number$ $tense$ $mood$ $voice$ $nonmorph$*


$verbacceptor$
