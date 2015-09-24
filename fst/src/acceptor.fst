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
$nounacceptor$ =  $nonmorph$+ <noun> $=gender$ $=noun$ $extratag$* $=noun$  $nonmorph$* $=gender$ $=case$ $=number$ $nonmorph$*


$acceptor$  = $nounacceptor$

$acceptor$

%% Example of accepted form:
% analyze> mhn<noun><fem><is_ios><is_ios>is<fem><nom><sg>
% mhn<noun><fem><is_ios><is_ios>is<fem><nom><sg>
