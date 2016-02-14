%%remove quantity markers!

#include "../../build/greek/symbols.fst"


% $dictionary$ =  <u>lsjpool\.n47039\_0</u><u>lexent\.n47039</u>ni<lo>k<noun><fem><h_hs><stemultacc>\:\:<h\_hs><u>nouninfl\.h\_hs9</u>a<lo>s<fem><acc><pl> |  <u>lsjpool\.n47039\_0</u><u>lexent\.n47039</u>ni<lo>k<noun><fem><h\_hs><stemultacc>\:\:<h\_hs><u>nouninfl\.h_hs8</u>ais<fem><dat><pl>


$dictionary$ = <u>lsjpool\.n47039\_0</u><u>lexent\.n47039</u>ni<lo>ka<lo>s<noun><fem><h_hs><stemultacc>\:\:<h_hs> <u>nouninfl\.h\_hs9</u><fem><acc><pl> | <u>lsjpool\.n47039\_0</u><u>lexent\.n47039</u>ni<lo>kais<noun><fem><h_hs><stemultacc>\:\:<h_hs><u>nouninfl\.h_hs8</u><fem><dat><pl>

$=nounclass$ = [#nounclass#]
$squashurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<noun>$=gender$ $=nounclass$  [#persistacc#]  $separator$+ $=nounclass$ <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> [#stemchars#]* $=gender$ $case$ $number$


%
%%%%%%%%%%%%%%%%%%%% STRIP OUT ALL TAGS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
#analysissymbol# = #editorial# #urntag# <noun> #morphtag# #stemtype#  #separator#

#surfacesymbol# = #character#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$stripsym$ = .+


$dictionary$ || $squashurn$ || $stripsym$
