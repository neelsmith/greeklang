%%% This transducer should PRECEDE generic verb acceptor/squasher.

#include "../../build/smyth/symbols.fst"

% 2nd and 3rd principal part
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>

% Extend stem with sigma after a final vowel:
ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]





#=ltr# = #vowel# <lo> <sh> #consonant#
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#][#omega#][#sigma#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+ __ <verb><ow_contract>\:\:<ow_contract><verb>[#stemchars#]+[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


$6th_pp$ = {[#=ltr#]}:{[#=ltr#][#omega#][#theta#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+ __ <verb><ow_contract>\:\:<ow_contract><verb>[#stemchars#]+[#person#][#number#][#2nd_3rd_6th_tense#][#mood#]<pass><u>[#urnchar#]+[#period#][#urnchar#]+</u> )








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


$dictionary$ =  <u>smyth\.n24342\_0</u><u>lexent\.n24342</u><#>dhl<verb><ow_contract>\:\:"<../../build/smyth/inflection.a>"



%%<ow_contract><verb>w<1st><sg><fut><indic><act><u>verbinfl\.ow\_fut\_indic1</u>


%%





%% <ow_contract><verb>w<1st><sg><fut><indic><act><u>verbinfl\.ow\_fut\_indic1</u>

$dictionary$  || $2nd_3rd_pp$   || $6th_pp$  || $squashverburn$  || $stripsym$
%%

%%
