% noun snippet

#include "../../build/greek/symbols.fst"


% TARGET LEXICON ENTRY:
  % <u>coretests.n67485_0</u><u>lexent.n67485</u>mhn<noun><fem><is_ios>::<is_ios><u>nouninfl.is_ios1</u>is<fem><nom><sg>

% As variable with protected chars:
%$target$ = <u>coretests\.n67485\_0</u><u>lexent\.n67485</u>mhn<noun><fem><is\_ios><stemultacc>\:\:<is\_ios><u>nouninfl\.is\_ios1</u>is<fem><nom><sg>


% Test an irregular form:
%%$target$ = <u>coretests\.n23069\_0</u><u>lexent\.n23069</u><noun><fem><gunh><irregacc>\:\:<gunh><u>nouninfl\.gunh1</u>gunh/<fem><nom><sg>

$target$ = <u>coretests\.n23069\_0</u><u>lexent\.n23069</u><noun><fem><gunh><irregacc>\:\:<gunh><u>nouninfl\.gunh2</u>gunaiko/s<fem><gen><sg>


%%%% ADD TAG FOR ACCENT CHARACTERISTIC TO NOUNS STEM LEXICON %%%%
% <u>coretests.n67485_0</u><u>lexent.n67485</u>mhn<noun><fem><is_ios><stemultacc>::<is_ios><u>nouninfl.is_ios1</u>is<fem><nom><sg>





%
%%%%%%%%%%%%%%%%%%%%%%%% NOUN ACCEPTOR %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
$=nounclass$ = [#nounclass#]
$noun$ = <u>[#urnchar#]+ [#period#] [#urnchar#]+</u><u>lexent[#period#][#urnchar#]+</u>[#stemchars#]* <noun>$=gender$ $=nounclass$ [#persistacc#] $separator$+ $=nounclass$ <u>[#urnchar#]+[#period#][#urnchar#]+</u> [#stemchars#]* $=gender$ $case$ $number$


%
%%%%%%%%%%%%%%%%%%%% STRIP OUT VALUE STRINGS FROM URNS %%%%%%%%%%%%%%%%%%%%%%%%
%
$squashurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]*<noun>$=gender$ $=nounclass$  [#persistacc#]  $separator$+ $=nounclass$ <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> [#stemchars#]* $=gender$ $case$ $number$

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
$target$ || $noun$   || $squashurn$   || $striptag$




% whattogen:WHATtoANALYZE
%[a-za-z]:[A-Za-z]*
