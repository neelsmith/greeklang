%%% This transducer should PRECEDE generic verb acceptor/squasher.

#include "../../build/smyth/symbols.fst"

% 2nd and 3rd principal part
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>

% Extend stem with sigma after a final vowel:
ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]




ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]


%%
% <u>smyth.n64316_0</u><u>lexent.n64316</u><#>lu<lo><verb><w_regular>::<w_regular><infin>ein<pres><act><u>verbinfl\.w_infin1</u>
%
%<u>smyth.n64316_0</u><u>lexent.n64316</u><#>lu<lo><verb><w_regular>::<w_regular><infin>ein<fut><act><u>verbinfl.w_infin4</u>
%
%%%

#=ltr# = #vowel# <lo> <sh>
$2nd_3rd_infin_pp$ = {[#=ltr#]}:{[#=ltr#][#sigma#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular><infin>[#stemchars#]+[#2nd_3rd_6th_tense#][#2nd_3rd_voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


$6th_infin_pp$ = {[#=ltr#]}:{[#=ltr#][#theta#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular><infin>[#stemchars#]+[#2nd_3rd_6th_tense#]<pass><u>[#urnchar#]+[#period#][#urnchar#]+</u> )






% Squash URN and strip symbol tags:

$=verbclass$ = [#verbclass#]
$squashinfinurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$  <infin> [#stemchars#]*  [#tense#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


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



$dictionary$ = <u>smyth\.n64316\_0</u><u>lexent\.n64316</u><#>lu<lo><verb><w_regular>\:\:"<../../build/smyth/inflection.a>"


%%%<w_regular><infin>ein<fut><act><u>verbinfl\.w_infin4</u>

$dictionary$  || $2nd_3rd_infin_pp$  || $6th_infin_pp$  || $squashinfinurn$  || $stripsym$
%
