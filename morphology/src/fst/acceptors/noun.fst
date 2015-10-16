% noun.fst
% Limits input to valid morphological analyses of nouns
%
#include "@workdir@symbols.fst"

% #extratag# is defined in "extratags.fst"
% $extratag$ = [#extratag#]


%%%%%%%%%%%%%%%%%%%%%%%% NOUN ANALYSIS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
$=nounclass$ = [#nounclass#]
$noun$ = <abburn>[#urnchar#]+ [#period#] [#urnchar#]+</abburn><abburn>lexent[#period#][#urnchar#]+</abburn>[#stemchars#]+<noun>$=gender$ $=nounclass$ $separator$+ $=nounclass$ [#stemchars#]* $=gender$ $case$ $number$ <abburn>[#urnchar#]+[#period#][#urnchar#]+</abburn>
%
%%%%%%%%%%%%%%%%%%%% STRIP OUT VALUE STRINGS FROM URNS %%%%%%%%%%%%%%%%%%%%%%%%
%
$squashurn$ = <abburn>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</abburn> <abburn>{lexent}:<>\.:<>[#urnchar#]:<>+</abburn>[#stemchars#]+<noun>$=gender$ $=nounclass$  $separator$+ $=nounclass$ [#stemchars#]* $=gender$ $case$ $number$ <abburn>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</abburn>
%
%%%%%%%%%%%%%%%%%%%% STRIP OUT ALL TAGS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
#analysissymbol# = #urn# #editorial# #morphtag# #stemtype# #separator# #urntag#
#surfacesymbol# = #character#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$striptag$ = .*

$nounacceptor$ =  $noun$ || $squashurn$ || $striptag$
$nounacceptor$
