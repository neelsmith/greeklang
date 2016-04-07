%  m_5pp.fst
%
% Generate fifth principal parts for verbs of type
% m_pp5.
%
#include "@workdir@symbols.fst"


#mp# = <mid><pass>

ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]


#=ltr# = #vowel# <lo> <sh>

#=ltr# = #vowel# <lo> <sh>
$ptcpl_m_5pp$ = {[#=ltr#]}:{[#=ltr#][#mu#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+[#vowel#] __ <verb><m_pp5>\:\:<m_pp5><ptcpl>[#stemchars#]+[#gender#][#case#][#number#]<pft>[#mp#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )

$ptcpl_m_5pp$
