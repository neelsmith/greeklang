%%% This transducer should PRECEDE generic verb acceptor/squasher.

#include "../../build/greek/symbols.fst"

% Cross two verb with full inflection of omega verbs:
$dictionary$ =  <u>lsjpool\.n64316\_0</u><u>lexent\.n64316</u>lu<verb> <w_regular> \:\: "<../../build/greek/core_inflection/inflection.a>" | <u>lsjpool\.n105945\_0</u><u>lexent\.n105945</u>tupt<verb> <w_pp1> \:\: "<../../build/greek/core_inflection/inflection.a>" |  <u>lsjpool\.n105945\_1</u><u>lexent\.n105945</u>tuy<verb> <w_pp2> \:\: "<../../build/greek/core_inflection/inflection.a>" | <u>lsjpool\.n105945\_2</u><u>lexent\.n105945</u>tuy<verb> <w_pp3> \:\: "<../../build/greek/core_inflection/inflection.a>"


ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]

% Handy shorthands:
% Tenses for 1st principal part
#1st_tense# = <pres><impft>
#1stppclasses# = <w_regular><w_pp1>
% Tenses 2nd and 3rd principal part
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>
%%% 6th = passive voice
% tenses for 4th-5th principal parts
#4th_5th_tense# = <pft><plupft>
%%%% 4th = act , 5th = m-p


#=pp1class# = #1stppclasses#
$1stpp$ = <u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+<verb>[#=pp1class#]\:\:[#=pp1class#][#stemchars#]+[#person#][#number#][#1st_tense#][#mood#][#voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u>


% 2nd,3rd: extend stem with sigma after a final vowel:
#=ltr# = #vowel#
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+ __ <verb><w_regular>\:\:<w_regular>[#stemchars#]+[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


% 6th: extend stem with sigma after a final vowel
$6th_pp$ = {[#=ltr#]}:{[#=ltr#]q} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+ __ <verb><w_regular>\:\:<w_regular>[#stemchars#]+[#person#][#number#][#2nd_3rd_6th_tense#][#mood#]<pass><u>[#urnchar#]+[#period#][#urnchar#]+</u> )




% Extend 4th part with kappa
$kappa$ = {[#=ltr#]}:{[#=ltr#]k} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u>[#stemchars#]+ __ <verb><w_regular>\:\:<w_regular>[#stemchars#]+[#person#][#number#][#4th_5th_tense#][#mood#]<act><u>[#urnchar#]+[#period#][#urnchar#]+</u> )

%  Reduplicate 4th and 5th when initial consonant:
#=cons# = #consonant#
$redupe$ = {[#=cons#]}:{[#=cons#]e[#=cons#]} ^->  (<u>[#urnchar#]+[#period#][#urnchar#]+</u><u>[#urnchar#]+[#period#][#urnchar#]+</u> __ [#stemchars#]+ <verb><w_regular>\:\:<w_regular>[#stemchars#]+[#person#][#number#][#4th_5th_tense#][#mood#][#voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u> )


$4th_5th_pp$   = $redupe$ ||  $kappa$

% Clean up the rest for testing in this snippet.
% Squash URN and strip symbol tags:

$=verbclass$ = [#verbclass#]
$squashverburn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$ $separator$+$=verbclass$ [#stemchars#]* [#person#] [#number#] [#tense#] [#mood#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

#analysissymbol# = #editorial# #urntag# <noun><verb> #morphtag# #stemtype#  #separator# #accent#
#surfacesymbol# = #letter# #diacritic#  #breathing#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$stripsym$ = .+

%$dictionary$ || $1stpp$ || $2nd_3rd_pp$  || $4th_5th_pp$  || $6th_pp$ || $squashverburn$  || $stripsym$
$dictionary$ ||  $2nd_3rd_pp$  || $4th_5th_pp$  || $6th_pp$ || $squashverburn$  || $stripsym$
