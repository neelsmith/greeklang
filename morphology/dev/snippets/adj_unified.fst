% snippet testing noun acceptor in new unified acceptor transducer

#include "../../build/smyth/symbols.fst"

% Raw:
% <u>smyth.n260_0</u><u>lexent.n260</u>a<sm>gaq<adj><os_h_on><inflacc>
% <u>smyth.n260_0</u><u>lexent.n260</u>a<sm>gaq<adj><os_h_on><inflacc>
%::
%<os_h_on><adj>os<masc><nom><sg><pos><u>adjinfl.os_h_on1</u>
%<os_h_on><adj>os<masc><nom><sg><pos><u>adjinfl\.os\_h\_on1</u>

$stem$ = <u>smyth\.n260\_0</u><u>lexent\.n260</u>a<sm>gaq<adj><os_h_on><inflacc>


$inflection$ = <os_h_on><adj>os<masc><nom><sg><pos><u>adjinfl\.os\_h\_on1</u>

%<os_h_on><adj>os<masc><nom><sg><posit><u>adjinfl\.os\_h\_on1</u>

$morphdb$ = $stem$  \:\: $inflection$

$=adjclass$ = [#adjectiveclass#]

$squashadjurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<adj>$=adjclass$  [#persistacc#]  $separator$+ $=adjclass$ <adj> [#stemchars#]* $gender$ $case$ $number$ [#degree#] <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>



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

$morphdb$ || $squashadjurn$ || $stripsym$


% .wq
