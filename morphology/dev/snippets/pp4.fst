%%% This transducer should PRECEDE generic verb acceptor/squasher.

#include "../../build/greek/symbols.fst"

% Cross one verb with full inflection:

$dictionary$ =  <u>lsjpool\.n786\_0</u><u>lexent\.n786</u>lu<verb> <w_regular> \:\:  "<../../build/greek/core_inflection/inflection.a>"

%%<w_regular>  a<1st><sg><pft><indic><act><u>verbinfl\.w\_indicative43</u>






% 2nd and 3rd principal part
#4th_5th_tense# = <pft><plupft>


% Extend stem with sigma after a final vowel:
ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]

#=ltr# = #vowel#




$kappa$ = {[#=ltr#]}:{[#=ltr#]k} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+ __ <verb><w_regular>\:\:<w_regular>[#stemchars#]+[#person#][#number#][#4th_5th_tense#][#mood#][#voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


#=cons# = #consonant#
$redupe$ = {[#=cons#]}:{[#=cons#]e[#=cons#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u> __ [#stemchars#]+ <verb><w_regular>\:\:<w_regular>[#stemchars#]+[#person#][#number#][#4th_5th_tense#][#mood#][#voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


% Squash URN and strip symbol tags:

$=verbclass$ = [#verbclass#]
$squashverburn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$ $separator$+$=verbclass$ [#stemchars#]* [#person#] [#number#] [#tense#] [#mood#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

#analysissymbol# = #editorial# #urntag# <noun><verb> #morphtag# #stemtype#  #separator# #accent#
#surfacesymbol# = #letter# #diacritic#  #breathing#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$stripsym$ = .+

$dictionary$  || $redupe$ || $kappa$ || $squashverburn$  || $stripsym$
