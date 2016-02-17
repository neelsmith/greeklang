
#include "../../build/greek/symbols.fst"

% Cross one verb with full inflection of omega verbs:
$dictionary$ =  <u>lsjpool\.n64316\_0</u><u>lexent\.n64316</u>lu<verb> <w_regular> \:\: "<../../build/greek/core_inflection/inflection.a>" | <u>lsjpool\.n105945\_0</u><u>lexent\.n105945</u>tupt<verb> <w_pp1> \:\: "<../../build/greek/core_inflection/inflection.a>" |  <u>lsjpool\.n105945\_1</u><u>lexent\.n105945</u>tuy<verb> <w_pp2> \:\: "<../../build/greek/core_inflection/inflection.a>" | <u>lsjpool\.n105945\_2</u><u>lexent\.n105945</u>tuy<verb> <w_pp3> \:\: "<../../build/greek/core_inflection/inflection.a>"

$tiny$ =  <u>lsjpool\.n105945\_0</u><u>lexent\.n105945</u>tupt<verb> <w_pp1>\:\:<w_pp1>w<1st><sg><pres><indic><act><u>verbinfl\.w_indicative1</u>

% <u>lsjpool\.n64316\_0</u><u>lexent\.n64316</u>lu<verb><w_regular>\:\:<w_regular>w<1st><sg><pres><indic><act><u>verbinfl\.w\_indicative1</u> |

% 1st principal part
#1st_tense# = <pres><impft>
#classes# = <w_regular><w_pp1>


ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]

#=vbclass# = #classes#
$1stpp$ = <u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+<verb>[#=vbclass#]\:\:[#=vbclass#][#stemchars#]+[#person#][#number#][#1st_tense#][#mood#][#voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u>


% Clean up the rest for testing in this snippet.
% Squash URN and strip symbol tags:

$=verbclass$ = [#verbclass#]
$squashverburn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$ $separator$+$=verbclass$ [#stemchars#]* [#person#] [#number#] [#tense#] [#mood#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

#analysissymbol# = #editorial# #urntag# <noun><verb> #morphtag# #stemtype#  #separator# #accent#
#surfacesymbol# = #letter# #diacritic#  #breathing#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$stripsym$ = .+

% $tiny$ || $1stpp$ || $squashverburn$  || $stripsym$

$dictionary$ || $1stpp$ || $squashverburn$  || $stripsym$
