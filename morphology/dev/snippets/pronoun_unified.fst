% snippet testing noun acceptor in new unified acceptor transducer

#include "../../build/smyth/symbols.fst"

%%% <u>smyth.n31951_0</u><u>lexent.n31951</u>e<sm>kein<pron><os_h_on><stemultacc>::<os_h_on><adj>ou<masc><gen><sg><pos><u>adjinfl.os_h_on2</u>
%%%%
%
% Raw:
%  <u>smyth.n71882_00</u><u>lexent.n71882</u>t<pron><os_h_on><inflacc>
 %::
%<os_h_on><adj>ou<masc><gen><sg><pos><u>adjinfl.os_h_on2</u>


$stem$ = <u>smyth\.n31951\_0</u><u>lexent\.n31951</u>e<sm>kein<pron><os_h_on><stemultacc>


$inflection$ = <os_h_on><adj>ou<masc><gen><sg><pos><u>adjinfl\.os\_h\_on2</u>

$morphdb$ = $stem$  \:\: $inflection$

$=adjclass$ = [#adjectiveclass#]

$squashpronounurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+  <pron> $=adjclass$  [#persistacc#]  $separator$+ $=adjclass$ <adj> [#stemchars#]* $gender$ $case$ $number$ <pos> <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>



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

$morphdb$ || $squashpronounurn$  ||  $stripsym$


% .wq
