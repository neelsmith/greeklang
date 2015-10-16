% noun snippet

#include "../../build/fst/symbols.fst"

#urnchar# = a-z 0-9 _
#urntag# = <abburn> </abburn>
#period# = \.

$period$ = [#period#]

% TARGET LEXICON ENTRY:
$target$ = <abburn>coretests$period$n67485_0</abburn><abburn>lexent$period$n67485</abburn>mhn<noun><fem><is_ios>\:\:<is_ios>is<fem><nom><sg><abburn>is_ios$period$1</abburn>

#analysissymbol# = #urn# #editorial# #morphtag# #stemtype# #separator# #urntag#
#surfacesymbol# = #character#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$striptag$ = .*



%%%  $=nounclass$ = [#nounclass#]
%%% $stripurn$ = <abburn>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</abburn> <abburn>{lexent}:<>\.:<>[#urnchar#]:<>+</abburn>[#stemchars#]+<noun>$=gender$ $=nounclass$  $separator$+ $=nounclass$ $=gender$ $=case$ $=number$


$=nounclass$ = [#nounclass#]
$noun$ = <abburn>[#urnchar#]+ [#period#] [#urnchar#]+</abburn>



% <abburn>{lexent}$period$[#urnchar#]+</abburn>[#stemchars#]+<noun>$=gender$ $=nounclass$  $separator$+ $=nounclass$  $=gender$ $case$ $number$  <abburn>[#urnchar#]+ $period$  [#urnchar#]+</abburn>



$noun$

%% <abburn>1.1</abburn><abburn>lexent.1</abburn>mhn<noun><fem><is_ios>\:\:<is_ios><fem><nom><sg> || $stripurn$   || $striptag$

% whattogen:WHATtoANALYZE
%[a-za-z]:[A-Za-z]*
