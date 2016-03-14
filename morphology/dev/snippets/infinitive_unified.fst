% snippet testing noun acceptor in new unified acceptor transducer

#include "../../build/smyth/symbols.fst"

% Raw:
% <u>lsjpool.n64316_0</u><u>lexent.n64316</u>lu_<verb><w_regular>::<w_regular>ein<pres><act><infin><u>verbinfl.w_infin1</u>

%

$stem$ = <u>lsjpool\.n64316\_0</u><u>lexent\.n64316</u>lu<lo><verb><w_regular>

$inflection$ = <w_regular>ein<pres><act><infin><u>verbinfl\.w\_infin1</u>



$morphdb$ = $stem$ \:\: $inflection$


$=verbclass$ = [#verbclass#]
$squashinfinurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$ [#stemchars#]*  [#tense#]  [#voice#]<infin><u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

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

$morphdb$  || $squashinfinurn$  || $stripsym$


% .wq
