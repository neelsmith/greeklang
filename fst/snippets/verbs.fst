%verbs.fst Verb morphology snippet
% Acceptor for conjugated verbal forms

#include "phonology.fst"
#include "morphsymbols.fst"
#include "stemtypes.fst"


% toy data set
$urn$ = [<n64316>]
#extratag# = <ml>
$extratag$ = [#extratag#]
$toylexicon$ = <n64316>lu<verb><w_regular><ml>
$toyending$ = <w_regular>w<1st><sg>[<pres><fut>][<indic><subj>]<act>




%%%%%%%% 1. Basic verb acceptor %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% #character# is defined in "phonology.fst"
#nonmorph# = #character# #extratag#
$nonmorph$ = [#nonmorph#]

% all defined in morphsymbol.fst
$=verbclass$ = [#verbclass#]
$person$ = [#person#]
$number$ = [#number#]
$tense$ = [#tense#]
$mood$ = [#mood#]
$voice$ = [#voice#]

$verbacceptor$ =  $urn$ $nonmorph$+ <verb> $=verbclass$  $extratag$* $separator$+ $=verbclass$ $nonmorph$* $person$ $number$ $tense$ $mood$ $voice$ $nonmorph$*

%%%%%%%%%% Snippet test

$morph$ = $toylexicon$ \:\: $toyending$

$morph$   || $verbacceptor$
