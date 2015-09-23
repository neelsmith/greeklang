#include "symbols.fst"
#include "extratags.fst"
#include "phonology.fst"
#include "stemtypes.fst"


% #character# if defined in "phonology.fst"
% #extratag# is defined in "extratags.fst"
#nonmorph# = #character# #extratag#
$nonmorph$ = [#nonmorph#]


% #noun# is the set of stemtypes for nouns.
$=noun$ = [#noun#]
%$nounacceptor$ = ($=case$ | $=number$ | $=gender$ | $nonmorph$ )* $=noun$ $=noun$ ($=case$ | $=number$ | $=gender$ | $nonmorph$ )*


$nounacceptor$ =  $nonmorph$* $=gender$ $=noun$ $=noun$  $nonmorph$* $=gender$ $=case$ $=number$ $nonmorph$*


$acceptor$  = $nounacceptor$

$acceptor$
