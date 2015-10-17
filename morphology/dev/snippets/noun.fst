% noun snippet

#include "../../build/fst/symbols.fst"



% TARGET LEXICON ENTRY:
%  <u>coretests.n67485_0</u><u>lexent.n67485</u>mhn<noun><fem><is_ios>::<is_ios>is<fem><nom><sg><u>is_ios.1</u>
%
%% As variable with protected chars:
$target$ = <u>coretests\.n67485_0</u><u>lexent\.n67485</u>mhn<noun><fem><is_ios>\:\:<is_ios>is<fem><nom><sg><u>is_ios\.1</u>






%
%%%%%%%%%%%%%%%%%%%%%%%% NOUN ACCEPTOR %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
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


% Real transducer pipeline:
%% $noun$ || $squashurn$ || $striptag$

% Test with data:
$target$ ||  $noun$ || $squashurn$ || $striptag$



% whattogen:WHATtoANALYZE
%[a-za-z]:[A-Za-z]*
