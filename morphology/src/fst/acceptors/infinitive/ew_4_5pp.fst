% 4th_5th_pp.sft
% Generate  infintive stems for fourth and fifth principal
% parts of epsilon contract verbs
%
#include "@workdir@symbols.fst"

% Tense/voice combinations for fourth-fifth principal parts
%
% For regular omega verbs,  reduplicate in all voices.
% In perfect active, extend stem with kappa.



% 4th=5th principal part
#4th_5th_tense# = <pft><plupft>


% Extend stem with sigma after a final vowel:
ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]

#=ltr# = #consonant# #vowel# <lo> <sh>
$kappa$ = {[#=ltr#]}:{[#=ltr#][#eta#][#kappa#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+ __ <verb><ew_contract>\:\:<ew_contract><infin>[#stemchars#]+[#4th_5th_tense#]<act><u>[#urnchar#]+[#period#][#urnchar#]+</u> )




#=cons# = #consonant#
$redupe$ = {[#=cons#]}:{[#=cons#][#epsilon#][#=cons#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]*<#> __ [#stemchars#]+<verb><ew_contract>\:\:<ew_contract><infin>[#stemchars#]+[#4th_5th_tense#][#voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )

$4th_5th_pp$ =   $kappa$ || $redupe$
$4th_5th_pp$
