% noun.fst
% Limits input to valid morphological analyses of nouns
%
#include "@workdir@symbols.fst"

% #extratag# is defined in "extratags.fst"
% $extratag$ = [#extratag#]


%%%%%%%%%%%%%%%%%%%%%%%% NOUN ANALYSIS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
$=nounclass$ = [#nounclass#]
$noun$ = <u>[#urnchar#]+ [#period#] [#urnchar#]+</u><u>lexent[#period#][#urnchar#]+</u>[#stemchars#]+<noun>$=gender$ $=nounclass$ $separator$+ $=nounclass$ [#stemchars#]* $=gender$ $case$ $number$ <u>[#urnchar#]+[#period#][#urnchar#]+</u>
%
%%%%%%%%%%%%%%%%%%%% STRIP OUT VALUE STRINGS FROM URNS %%%%%%%%%%%%%%%%%%%%%%%%
%
$squashurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<noun>$=gender$ $=nounclass$  $separator$+ $=nounclass$ [#stemchars#]* $=gender$ $case$ $number$ <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>
%
%%%%%%%%%%%%%%%%%%%% STRIP OUT ALL TAGS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
#analysissymbol# = #urn# #editorial# #morphtag# #stemtype# #separator# #urntag#
#surfacesymbol# = #character#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$striptag$ = .*

$nounacceptor$ =  $noun$ || $squashurn$ || $striptag$
$nounacceptor$
