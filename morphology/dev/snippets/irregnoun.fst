% noun snippet

#include "../../build/greek/symbols.fst"


% TARGET LEXICON ENTRY:
  % <u>coretests.n23069_0</u><u>lexent.n23069</u><noun><fem><gunh><irregacc>::<gunh><u>nouninfl.gunh1</u>gunh/<fem><nom><sg>

% As variable with protected chars:
$target$ = <u>coretests\.n23069\_0</u><u>lexent\.n23069</u><noun><fem><gunh><irregacc>\:\:<gunh><u>nouninfl\.gunh1</u>gunh/<fem><nom><sg>


%%%%%%%%%%
% 1. Acc must be added to accent symbols
% 2. Noun class must be added to symbols
%%%%%%%%

%
%%%%%%%%%%%%%%%%%%%%%%%% NOUN ACCEPTOR %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
$=nounclass$ = [#nounclass#]
%$noun$ = <u>[#urnchar#]+ [#period#] [#urnchar#]+</u><u>lexent[#period#][#urnchar#]+</u>[#stemchars#]* <noun>$=gender$ $=nounclass$ [#persistacc#] $separator$+ $=nounclass$ <u>[#urnchar#]+[#period#][#urnchar#]+</u> [#stemchars#]* $=gender$ $case$ $number$


$noun$ = <u>[#urnchar#]+ [#period#] [#urnchar#]+</u><u>lexent[#period#][#urnchar#]+</u>[#stemchars#]* <noun>$=gender$<gunh><irregacc> $separator$+ <gunh> <u>[#urnchar#]+[#period#][#urnchar#]+</u> [#stemchars#]* $=gender$ $case$ $number$


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
$target$ || $noun$   || $squashurn$    || $striptag$
