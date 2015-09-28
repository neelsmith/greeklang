%verbs.fst Verb morphology snippet
% Acceptor for conjugated verbal forms

%#include "@workdir@symbols.fst"
%#include "@workdir@phonology.fst"
%#include "@workdir@stemtypes.fst"




$morph$ = $toylexicon$ = <n64316>lu<verb><w_regular>
$ending$ = <w_regular>w<1st><sg>[<pres><fut>][<indic><subj>]<act>

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
