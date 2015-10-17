% noun.fst
% Limits input to valid morphological analyses of nouns
%
#include "@workdir@symbols.fst"

% #extratag# is defined in "extratags.fst"
% $extratag$ = [#extratag#]

%
%%%%%%%%%%%%%%%%%%%%%%%% NOUN ACCEPTOR %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
$=nounclass$ = [#nounclass#]
$noun$ = <u>[#urnchar#]+ [#period#] [#urnchar#]+</u><u>lexent[#period#][#urnchar#]+</u>[#stemchars#]+<noun>$=gender$ $=nounclass$ $separator$+ $=nounclass$ <u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]* $=gender$ $case$ $number$
%
%%%%%%%%%%%%%%%%%%%% STRIP OUT VALUE STRINGS FROM URNS %%%%%%%%%%%%%%%%%%%%%%%%
%
$squashurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<noun>$=gender$ $=nounclass$  $separator$+ $=nounclass$ <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> [#stemchars#]* $=gender$ $case$ $number$
%
%%%%%%%%%%%%%%%%%%%% STRIP OUT ALL TAGS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
#analysissymbol# = #urn# #editorial# #morphtag# #stemtype# #separator# #urntag#
#surfacesymbol# = #character#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$striptag$ = .*




$nounacceptor$ =  $noun$ || $squashurn$ || $striptag$
$nounacceptor$
