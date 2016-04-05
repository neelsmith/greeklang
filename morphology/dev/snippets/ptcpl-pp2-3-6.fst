%%% This transducer should PRECEDE generic verb acceptor/squasher.

#include "../../build/smyth/symbols.fst"

% 2nd and 3rd principal part
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>

% Extend stem with sigma after a final vowel:
ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]





#=ltr# = #vowel# <lo> <sh>
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular><ptcpl>[#stemchars#]+[#gender#][#case#][#number#][#2nd_3rd_6th_tense#][#2nd_3rd_voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


$6th_pp$ = {[#=ltr#]}:{[#=ltr#]q} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular><ptcpl>[#stemchars#]+[#gender#][#case#][#number#][#2nd_3rd_6th_tense#]<pass><u>[#urnchar#]+[#period#][#urnchar#]+</u> )



%







% Squash URN and strip symbol tags:
$=verbclass$ = [#verbclass#]
$squashptcplurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$ <ptcpl>[#stemchars#]*  [#gender#][#case#][#number#][#tense#]  [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

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

% Cross one verb with full inflection:
$dictionary$ =  <u>smyth\.n64316\_0</u><u>lexent\.n64316</u><#>lu<lo><verb><w_regular> \:\: "<../../build/smyth/inflection.a>"

%% <w_regular><ptcpl>wn<masc><nom><sg><fut><act><u>verbinfl\.w\_fut\_ptcp1</u>

%%% "<../../build/smyth/inflection.a>"

$dictionary$  || $2nd_3rd_pp$   || $6th_pp$  || $squashptcplurn$  || $stripsym$
%%

%%
