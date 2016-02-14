%%remove quantity markers!

#include "../../build/greek/symbols.fst"


% $dictionary$ =  <u>lsjpool\.n47039\_0</u><u>lexent\.n47039</u>ni<lo>k<noun><fem><h_hs><stemultacc>\:\:<h\_hs><u>nouninfl\.h\_hs9</u>a<lo>s<fem><acc><pl> |  <u>lsjpool\.n47039\_0</u><u>lexent\.n47039</u>ni<lo>k<noun><fem><h\_hs><stemultacc>\:\:<h\_hs><u>nouninfl\.h_hs8</u>ais<fem><dat><pl>


$dictionary$ = <u>lsjpool\.n47039\_0</u><u>lexent\.n47039</u>ni<lo>ka<lo>s<noun><fem><h_hs><stemultacc>\:\:<h_hs> <u>nouninfl\.h\_hs9</u><fem><acc><pl> | <u>lsjpool\.n47039\_0</u><u>lexent\.n47039</u>ni<lo>kais<noun><fem><h_hs><stemultacc>\:\:<h_hs><u>nouninfl\.h_hs8</u><fem><dat><pl> | <u>lsjpool\.n786\_0</u><u>lexent\.n786</u>a<sm>goreu<verb> <w_regular>\:\:<w_regular>w<1st><sg><pres><indic><act><u>verbinfl\.w\_indicative1</u> | <u>lsjpool\.n19546\_0</u><u>lexent\.n19546</u>basil<noun><masc><eus\_ews><inflacc>\:\:<eus\_ews><u>nouninfl\.eus\_ews1</u>eu/s<masc><nom><sg>






%%% COMBINE ACCEPTOR AND URN SQUASHER IN ONE TRANSDUCER:
%
$=nounclass$ = [#nounclass#]
$squashnounurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<noun>$=gender$ $=nounclass$  [#persistacc#]  $separator$+ $=nounclass$ <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> [#stemchars#]* $=gender$ $case$ $number$



$=verbclass$ = [#verbclass#]
$squashverburn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$ $separator$+$=verbclass$ [#stemchars#]* [#person#] [#number#] [#tense#] [#mood#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


% Union of all acceptor squashers:
$acceptor$ = $squashverburn$ | $squashnounurn$

%% Strip out all tags:
%
#analysissymbol# = #editorial# #urntag# <noun><verb> #morphtag# #stemtype#  #separator# #accent#
#surfacesymbol# = #letter# #diacritic#  #breathing#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$stripsym$ = .+


%% The canonical pipeline: morph data -> acceptor
$dictionary$ || $acceptor$ || $stripsym$
