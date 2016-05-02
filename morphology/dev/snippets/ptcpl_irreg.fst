% snippet testing noun acceptor in new unified acceptor transducer

#include "../../build/smyth/symbols.fst"

% Raw:
% <u>smyth.n31130_0s</u><u>lexent.n31130</u>w<sm>/n<pres><act><masc><nom><sg><irregptcpl>::<irregptcpl><ptcpl><u>irreginfl.5</u>

$stem$ = <u>smyth\.n31130\_0s</u><u>lexent\.n31130</u>w<sm>/n<pres><act><masc><nom><sg><irregptcpl>


$inflection$ =<irregptcpl><ptcpl><u>irreginfl\.5</u>




$morphdb$ = $stem$   \:\: $inflection$

$squashirregptcplurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+ $tense$ $voice$ $gender$ $case$ $number$ <irregptcpl>  $separator$+ <irregptcpl><ptcpl><u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>



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

$morphdb$  || $squashirregptcplurn$  || $stripsym$


% .wq
