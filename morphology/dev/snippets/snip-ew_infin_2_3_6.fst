%%% This transducer should PRECEDE generic verb acceptor/squasher.

#include "../../build/smyth/symbols.fst"

% 2nd and 3rd principal part
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>

ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]


% Extend stem with sigma after a final vowel:
#=ltr# = #vowel# <lo> <sh> #consonant#
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#][#eta#][#sigma#]} ^-> (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><ew_contract>\:\:<ew_contract><infin>[#stemchars#]+[#2nd_3rd_6th_tense#][#2nd_3rd_voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


$6th_pp$ = {[#=ltr#]}:{[#=ltr#][#eta#][#theta#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><ew_contract>\:\:<ew_contract><infin>[#stemchars#]+[#2nd_3rd_6th_tense#]<pass><u>[#urnchar#]+[#period#][#urnchar#]+</u> )








% Squash URN and strip symbol tags:
$=verbclass$ = [#verbclass#]
$squashinfinurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$ <infin>[#stemchars#]* [#tense#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

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


$dictionary$ =  <u>smyth\.n24342\_0</u><u>lexent\.n24342</u><#>poi<verb><ew_contract>\:\:"<../../build/smyth/inflection.a>"







%% $dictionary$ = <u>smyth\.n24342\_0</u><u>lexent\.n24342</u><#>poi<verb><ew_contract>\:\:<ew_contract><infin>ein<fut><act><u>verbinfl\.ew\_fut\_indic1</u>




$dictionary$  || $2nd_3rd_pp$  || $6th_pp$  || $squashinfinurn$  || $stripsym$
%%

%%
