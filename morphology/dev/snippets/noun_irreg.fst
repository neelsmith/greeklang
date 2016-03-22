% snippet testing noun acceptor in new unified acceptor transducer

#include "../../build/smyth/symbols.fst"

% Raw:
% <u>smyth.n23069_0</u><u>lexent.n23069</u>gunaiko/s<fem><gen><sg><irregnoun>::<irregnoun><noun><u>irreginfl.1</u>

$stem$ = <u>smyth\.n23069\_0</u><u>lexent\.n23069</u>gunaiko/s<fem><gen><sg><irregnoun>

$inflection$ = <irregnoun><noun><u>irreginfl\.1</u>


$morphdb$ = $stem$   \:\: $inflection$

$=nounclass$ = [#nounclass#]
$squashirregnounurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+ $gender$ $case$ $number$ <irregnoun>  $separator$+ <irregnoun><noun><u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>



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

$morphdb$  || $squashirregnounurn$  || $stripsym$


% .wq
