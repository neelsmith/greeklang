% noun snippet

#include "../../build/fst/symbols.fst"



% TARGET LEXICON ENTRY:
%  <abburn>coretests.n67485_0</abburn><abburn>lexent.n67485</abburn>mhn<noun><fem><is_ios>::<is_ios>is<fem><nom><sg><abburn>is_ios.1</abburn>
%
%% As variable with protected chars:
$target$ = <abburn>coretests\.n67485_0</abburn><abburn>lexent\.n67485</abburn>mhn<noun><fem><is_ios>\:\:<is_ios>is<fem><nom><sg><abburn>is_ios\.1</abburn>




%
%%%%%%%%%%%%%%%%%%% ADD THESE TO GLOBAL SYMBOLS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%
#urnchar# = a-z 0-9 _
#urntag# = <abburn> </abburn>
#period# = \.

$period$ = [#period#]

%
%%%%%%%%%%%%%%%%%%%%%%%% NOUN ACCEPTOR %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
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


% Real transducer pipeline:
%% $noun$ || $squashurn$ || $striptag$

% Test with data:
$target$ ||  $noun$ || $squashurn$ || $striptag$



% whattogen:WHATtoANALYZE
%[a-za-z]:[A-Za-z]*
