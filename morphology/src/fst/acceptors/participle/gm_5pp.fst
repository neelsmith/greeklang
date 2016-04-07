%  gm_5pp.fst
%
% Generate fifth principal parts for verbs of type
% gm_pp5, eg, πράττω
%
#include "@workdir@symbols.fst"


#mp# = <mid><pass>

ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]


#=ltr# = #vowel# <lo> <sh>

#=ltr# = #vowel# <lo> <sh>
$ptcpl_gm_5pp$ = {[#=ltr#]}:{[#=ltr#][#gamma#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+ __ <verb><gm_pp5>\:\:<gm_pp5><ptcpl>[#stemchars#]+[#gender#][#case#][#number#]<pft>[#mp#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )

$ptcpl_gm_5pp$
