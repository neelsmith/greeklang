% snippet testing noun acceptor in new unified acceptor transducer

#include "../../build/smyth/symbols.fst"

% Raw:
%  <u>lsjpool.n8909_0</u><u>lexent.n8909</u>a<sm>nqrwp<noun><masc><os_ou><stempenacc>::<os_ou><oun>ou<masc><gen><sg><u>nouninfl.os_ou2m</u>
%

$stem$ = <u>lsjpool\.n8909\_0</u><u>lexent\.n8909</u>a<sm>nqrwp<noun><masc><os_ou><stempenacc>

$inflection$ = <os_ou><noun>ou<masc><gen><sg> <u>nouninfl\.os\_ou2m</u>


$morphdb$ = $stem$ \:\: $inflection$

$=nounclass$ = [#nounclass#]
$squashnounurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<noun>$=gender$ $=nounclass$  [#persistacc#]  $separator$+ $=nounclass$  <noun> [#stemchars#]* $=gender$ $case$ $number$ <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% THE UNIVERSAL FINISHER: don't touch this:
%
%% Put all symbols in 2 categories:  pass through
%% surface symbols, squash analytical symbols.
#analysissymbol# = #editorial# #urntag# <noun><verb> #morphtag# #stemtype#  #separator# #accent#
#surfacesymbol# = #letter# #diacritic#  #breathing#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$stripsym$ = .+
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

$morphdb$ || $squashnounurn$ || $stripsym$


% .wq
