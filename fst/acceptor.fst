#include "symbols.fst"
#include "phonology.fst"
#include "stemtypes.fst"


#nonmorph# = #character#
$nonmorph$ = [#nonmorph#]


% This pattern guarantees that only morphological tags
% appropirate for analyzing nouns are used with a noun
% stemtype.  It does NOT guarantee that all tags necessary
% for a complete analyis are included.
%
% #noun# is the set of stemtypes for nouns.
$=noun$ = [#noun#]
$nounacceptor$ = ($=case$ | $=number$ | $=gender$ | $nonmorph$ )* $=noun$ $=noun$ ($=case$ | $=number$ | $=gender$ | $nonmorph$ )*


$acceptor$  = $nounacceptor$

$acceptor$
