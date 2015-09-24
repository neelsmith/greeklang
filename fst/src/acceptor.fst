#include "symbols.fst"
#include "extratags.fst"
#include "phonology.fst"
#include "stemtypes.fst"


% #extratag# is defined in "extratags.fst"
$extratag$ = [#extratag#]
% #character# is defined in "phonology.fst"
#nonmorph# = #character# #extratag#
$nonmorph$ = [#nonmorph#]

% #noun# is the set of stemtypes for nouns.
$=noun$ = [#noun#]
$nounacceptor$ =  $nonmorph$* $=gender$ $=noun$ $extratag$* $=noun$  $nonmorph$* $=gender$ $=case$ $=number$ $nonmorph$*


$acceptor$  = $nounacceptor$

$acceptor$
