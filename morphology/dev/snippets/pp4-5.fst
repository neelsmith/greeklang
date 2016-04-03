%%% This transducer should PRECEDE generic verb acceptor/squasher.

#include "../../build/smyth/symbols.fst"

% Cross one verb with full inflection:



%%<w_regular>  a<1st><sg><pft><indic><act><u>verbinfl\.w\_indicative43</u>

$tiny$ = <u>lsjpool\.n786\_0</u><u>lexent\.n786</u>lu<verb><w_regular>\:\:<w_regular>mai<1st><sg><pft><indic><mid><u>verbinfl\.w_indicative49</u> | <u>lsjpool\.n786\_0</u><u>lexent\.n786</u>lu<verb><w_regular>\:\:<w_regular>mai<1st><sg><pft><indic><pass><u>verbinfl\.w\_indicative49</u> | <u>lsjpool\.n786\_0</u><u>lexent\.n786</u>lu<verb><w_regular>\:\:<w_regular>a<1st><sg><pft><indic><act><u>verbinfl\.w\_indicative43</u>



% 4th=5th principal part
#4th_5th_tense# = <pft><plupft>


% Extend stem with sigma after a final vowel:
ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]

#=ltr# = #vowel# <lo> <sh>
$kappa$ = {[#=ltr#]}:{[#=ltr#][#kappa#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular><verb>[#stemchars#]+[#person#][#number#][#4th_5th_tense#][#mood#]<act><u>[#urnchar#]+[#period#][#urnchar#]+</u> )




#=cons# = #consonant#
$redupe$ = {[#=cons#]}:{[#=cons#][#epsilon#][#=cons#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]*<#> __ [#stemchars#]+<verb><w_regular>\:\:<w_regular><verb>[#stemchars#]+[#person#][#number#][#4th_5th_tense#][#mood#][#voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


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


$dictionary$ = <u>smyth\.n64316\_0</u><u>lexent\.n64316</u><#>lu<lo><verb><w_regular>\:\:<w\_regular><verb>a<1st><sg><pft><indic><act><u>verbinfl\.w\_pft\_indic1</u>

%%$dictionary$ || $kappa$   || $redupe$ %%|| $squashverburn$  || $stripsym$
$dictionary$  || $redupe$  || $kappa$  || $squashverburn$  || $stripsym$
