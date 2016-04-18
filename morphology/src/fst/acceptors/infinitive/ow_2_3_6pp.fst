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


#=ltr# = #consonant# #vowel# <lo> <sh>
$ew_2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#][#omega#][#sigma#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><ew_contract>\:\:<ew_contract><infin>[#stemchars#]+[#2nd_3rd_6th_tense#][#2nd_3rd_voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


$ew_6th_pp$ = {[#=ltr#]}:{[#=ltr#][#omega#][#theta#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><ew_contract>\:\:<ew_contract><infin>[#stemchars#]+[#2nd_3rd_6th_tense#]<pass><u>[#urnchar#]+[#period#][#urnchar#]+</u> )

$ew_2nd_3rd_pp$  || $ew_6th_pp$
