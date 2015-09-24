#include "@workdir@symbols.fst"
#include "@workdir@extratags.fst"
#include "@workdir@phonology.fst"
#include "@workdir@stemtypes.fst"


% #extratag# is defined in "extratags.fst"
$extratag$ = [#extratag#]
% #character# is defined in "phonology.fst"
#nonmorph# = #character# #extratag#
$nonmorph$ = [#nonmorph#]

% #noun# is the set of stemtypes for nouns,
% defined in stemtypes.fst
$=noun$ = [#noun#]
$nounacceptor$ =  $nonmorph$+ <noun> $=gender$ $=noun$ $extratag$* $separator$+ $=noun$  $nonmorph$* $=gender$ $=case$ $=number$ $nonmorph$*



$acceptor$  = $nounacceptor$
$acceptor$
