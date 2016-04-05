%  w_2_3_6pp.fst
%
% Generate second, third and sixth principal parts for
% regular omega verbs.
%
#include "@workdir@symbols.fst"


%% Extend stems for regular verbs:


% 2nd and 3rd principal part
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>


ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]

#=ltr# = #vowel# <lo> <sh> #consonant#
$ow_2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#][#omega#][#sigma#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+ __ <verb><ow_contract>\:\:<ow_contract><verb>[#stemchars#]+[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


$ow_6th_pp$ = {[#=ltr#]}:{[#=ltr#][#omega#][#theta#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+ __ <verb><ow_contract>\:\:<ow_contract><verb>[#stemchars#]+[#person#][#number#][#2nd_3rd_6th_tense#][#mood#]<pass><u>[#urnchar#]+[#period#][#urnchar#]+</u> )


$ow_2nd_3rd_pp$  || $ow_6th_pp$
