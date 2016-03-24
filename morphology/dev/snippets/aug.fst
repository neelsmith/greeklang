%

#include "../../build/smyth/symbols.fst"


ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]

#augmenttense# = <aor><impft><plupft>

$dictionary$ = <u>smyth\.n64316\_0</u><u>lexent\.n64316</u><#>lu<lo><verb><w_regular>\:\: "<../../build/smyth/inflection.a>"

%%<w_regular><verb>on<3rd><pl><impft><indic><act><u>verbinfl\.w\_impf\_indic8</u>


#=ltr# = #consonant#
$augmentsimplecons$ = {[#=ltr#]}:{e<sm>[#=ltr#]} ^-> ( <#> __ [#stemchars#]+<verb><w_regular>\:\:<w_regular><verb>[#stemchars#]+[#person#][#number#][#augmenttense#]<indic>[#voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u>)


%% add simplex vowels
%% add compounds...

$simplex$ = $augmentsimplecons$






% Squash URN and strip symbol tags:
$=verbclass$ = [#verbclass#]
$squashverburn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$ <verb>[#stemchars#]* [#person#] [#number#] [#tense#] [#mood#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% THE UNIVERSAL FINISHER: don't touch this:
%
%% Put all symbols in 2 categories:  pass through
%% surface symbols, squash analytical symbols.
#analysissymbol# = #editorial# #urntag# <noun><verb> #morphtag# #stemtype#  #separator# #accent#
#surfacesymbol# = #letter# #diacritic#  #breathing#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$stripsym$ = .+
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


$dictionary$  ||  $simplex$ ||  $squashverburn$  || $stripsym$
