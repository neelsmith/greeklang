%%% This transducer should PRECEDE generic verb acceptor/squasher.

#include "../../build/greek/symbols.fst"


% 2nd and 3rd principal part
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>

% Extend stem with sigma after a final vowel:
ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]

#=ltr# = #vowel#
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular>[#stemchars#]+[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )



$6th_pp$ = {[#=ltr#]}:{[#=ltr#]q} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular>[#stemchars#]+[#person#][#number#][#2nd_3rd_6th_tense#][#mood#]<pass><u>[#urnchar#]+[#period#][#urnchar#]+</u> )

% Cross one verb with full inflection:

$dictionary$ =  <u>lsjpool\.n786\_0</u><u>lexent\.n786</u>a<sm>goreu<verb> <w_regular> \:\: "<../../build/greek/core_inflection/inflection.a>"


% Squash URN and strip symbol tags:


$squashverburn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb><w_regular> $separator$+<w_regular> [#stemchars#]* [#person#] [#number#] [#tense#] [#mood#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

#analysissymbol# = #editorial# #urntag# <noun><verb> #morphtag# #stemtype#  #separator# #accent#
#surfacesymbol# = #letter# #diacritic#  #breathing#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$stripsym$ = .+

$dictionary$  || $2nd_3rd_pp$  || $6th_pp$ || $squashverburn$  || $stripsym$
