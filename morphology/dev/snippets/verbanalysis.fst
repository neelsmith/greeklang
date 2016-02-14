% verbanalysis.fst

#include "../../build/greek/symbols.fst"

% TARGET LEXICON ENTRY:
% <u>lsjpool.n786_0</u><u>lexent.n786</u>a<sm>goreu<verb><w_regular>::w<1st><sg><pres><indic><act><u>verbinfl.w_indicative1</u>

% As variable with protected chars:
$dictionary$ =  <u>lsjpool\.n786\_0</u><u>lexent\.n786</u>a<sm>goreu<verb> <w_regular>\:\:<w_regular>w<1st><sg><pres><indic><act><u>verbinfl\.w\_indicative1</u>


%
%%%%%%%%%%%%%%%%%%%%%%%% VERB ACCEPTOR %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
$=verbclass$ = [#verbclass#]
$verb$ = <u>[#urnchar#]+ [#period#] [#urnchar#]+</u><u>lexent[#period#][#urnchar#]+</u>[#stemchars#]*<verb>$=verbclass$  $separator$+ $=verbclass$ [#stemchars#]* $person$ $number$ $tense$ $mood$ $voice$ <u>[#urnchar#]+[#period#][#urnchar#]+</u>


%
%%%%%%%%%%%%%%%%%%%% STRIP OUT VALUE STRINGS FROM URNS %%%%%%%%%%%%%%%%%%%%%%%%
%
$squashurn$ =  <u>[#urnchar#]:<>+ [#period#]:<> [#urnchar#]:<>+</u><u>{lexent}:<>[#period#]:<>[#urnchar#]:<>+</u>[#stemchars#]*<verb>$=verbclass$  $separator$+ $=verbclass$ [#stemchars#]* $person$ $number$ $tense$ $mood$ $voice$ <u>[#urnchar#]:<>+[#period#]:<>[#urnchar#]:<>+</u>



%
%%%%%%%%%%%%%%%%%%%% STRIP OUT ALL TAGS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
#analysissymbol# = #urn# #editorial# #morphtag# #stemtype# #separator# #urntag#
#surfacesymbol# = #character#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$striptag$ = .*

% <u>lsjpool.n786_0</u><u>lexent.n786</u>a<sm>goreu<verb><w_regular>::<w_regular>w<1st><sg><pres><indic><act><u>verbinfl.w_indicative1</u>


$dictionary$ || $verb$  || $squashurn$   || $striptag$
