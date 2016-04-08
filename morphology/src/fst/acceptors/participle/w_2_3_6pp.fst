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

% Extend stem with sigma after a final vowel:
ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]





#=ltr# = #vowel# <lo> <sh>
$ptcpl_2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular><ptcpl>[#stemchars#]+[#gender#][#case#][#number#][#2nd_3rd_6th_tense#][#2nd_3rd_voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


$ptcpl_6th_pp$ = {[#=ltr#]}:{[#=ltr#]q} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular><ptcpl>[#stemchars#]+[#gender#][#case#][#number#][#2nd_3rd_6th_tense#]<pass><u>[#urnchar#]+[#period#][#urnchar#]+</u> )

$ptcpl_2nd_3rd_pp$  || $ptcpl_6th_pp$
