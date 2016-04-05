% 4th_5th_pp.sft
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

#=ltr# = #vowel# <lo> <sh>
$kappa$ = {[#=ltr#]}:{[#=ltr#][#kappa#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><w_regular>\:\:<w_regular><ptcpl>[#stemchars#]+[#gender#][#case#][#number#][#4th_5th_tense#]<act><u>[#urnchar#]+[#period#][#urnchar#]+</u> )


#=cons# = #consonant#
$redupe$ = {[#=cons#]}:{[#=cons#][#epsilon#][#=cons#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]*<#> __ [#stemchars#]+<verb><w_regular>\:\:<w_regular><ptcpl>[#stemchars#]+[#gender#][#case#][#number#][#4th_5th_tense#][#voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )

$4th_5th_pp$ =   $kappa$ || $redupe$
$4th_5th_pp$
