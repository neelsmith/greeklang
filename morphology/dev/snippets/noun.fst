% noun snippet

#include "../../build/fst/symbols.fst"



% $nonmorph$+ <noun> $=gender$ $=nounclass$ $extratag$* $separator$+ $=nounclass$  $nonmorph$* $=gender$ $=case$ $=number$ $nonmorph$*


#urnchar# = a-z 0-9 _


%% STRIPS URN VALUES OUT OF A NOUN PATTERN PREPARTORY TO
% REMOVING TAGS

$=nounclass$ = [#nounclass#]
$stripurn$ = <abburn>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</abburn> <abburn>{lexent}:<>\.:<>[#urnchar#]:<>+</abburn>[#stemchars#]+<noun>$=gender$ $=nounclass$  $separator$+ $=nounclass$ $=gender$ $=case$ $=number$

%$noun$ = <abburn>[#urnchar#]+[\.][#urnchar#]+</abburn> <abburn>{lexent.}[#urnchar#]+</abburn>[#stemchars#]+<noun>$=gender$ $=nounclass$  $separator$+ $=nounclass$  $=gender$ $case$ $number$


#analysissymbol# = #urn# #editorial# #morphtag# #stemtype# #separator# <abburn> </abburn>
#surfacesymbol# = #character#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$striptag$ = .*


%$noun$ ||

<abburn>1.1</abburn><abburn>lexent.1</abburn>mhn<noun><fem><is_ios>\:\:<is_ios><fem><nom><sg> || $stripurn$   || $striptag$

% whattogen:WHATtoANALYZE
%[a-za-z]:[A-Za-z]*
