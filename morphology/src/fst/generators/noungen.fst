% noun generator

#include "@workdir@symbols.fst"




$=nounclass$ = [#nounclass#]

% Generator pattern ensuring matches on nounclass and
% gender:
$gen$ = <u>:<>[#urnchar#]:<>+ [#period#]:<> [#urnchar#]:<>+</u>:<><u>lexent[#period#][#urnchar#]+</u>[#stemchars#]:<>*<noun>:<>$=gender$$=nounclass$[#persistacc#]:<>[#separator#]:<>+$=nounclass$<u>:<>[#urnchar#]:<>+[#period#]:<>[#urnchar#]:<>+</u>:<>[#stemchars#]:<>* $=gender$ $case$ $number$

% Final surface level only requries a URN and gender+number
#analysissymbol# =  #gender#  #stemtype#
#surfacesymbol# = #character# #case# #number# #urntag#  #editorial#  #urnchar# \.
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$trimMatches$ = .*

% Test with data:
$gen$  || $trimMatches$







%
