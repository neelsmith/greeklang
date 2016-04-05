%  w_2_3_6pp.fst
%
% Generate second, third and sixth principal parts for
% infinitive of regular omega verbs.
%
#include "@workdir@symbols.fst"


%% Extend stems for regular verbs:


% 2nd and 3rd principal part
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>


ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]


%%
% <u>smyth.n64316_0</u><u>lexent.n64316</u><#>lu<lo><verb><w_regular>::<w_regular><infin>ein<pres><act><u>verbinfl.w_infin1</u>
%
%<u>smyth.n64316_0</u><u>lexent.n64316</u><#>lu<lo><verb><w_regular>::<w_regular><infin>ein<fut><act><u>verbinfl.w_infin4</u>
%
%%%

#=ltr# = #vowel# <lo> <sh>
$2nd_3rd_infin_pp$ = {[#=ltr#]}:{[#=ltr#][#sigma#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular><infin>[#stemchars#]+[#2nd_3rd_6th_tense#][#2nd_3rd_voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


$6th_infin_pp$ = {[#=ltr#]}:{[#=ltr#][#theta#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular><infin>[#stemchars#]+[#2nd_3rd_6th_tense#]<pass><u>[#urnchar#]+[#period#][#urnchar#]+</u> )

$2nd_3rd_infin_pp$  || $6th_infin_pp$
