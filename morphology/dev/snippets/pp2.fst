%%% This transducer should PRECEDE generic verb acceptor/squasher.

#include "../../build/greek/symbols.fst"


% 2nd and 3rd principal part
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>

% Extend stem with sigma after a final vowel:
ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]

#=ltr# = #vowel#
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular>[#stemchars#]+[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )

$dictionary$ = <u>lsjpool\.n786\_0</u><u>lexent\.n786</u>a<sm>goreu<verb> <w_regular>\:\:<w_regular>w<1st><sg><fut><indic><act><u>verbinfl\.w\_indicative1</u>


$dictionary$ || $2nd_3rd_pp$
