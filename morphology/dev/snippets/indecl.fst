% test indeclinable acceptor

% indeclinable.fst
% Acceptor for indeclinable literals:

#include "../../build/greek/symbols.fst"

%%%%%%% for copy/paste:
% <u>coretests.n23596_0</u><u>lexent.n21618</u>ga/r<indecl>::<indecl>  <u>indeclinfl.0</u>
%%%%%%%




$dict$ = <u>coretests\.n23596\_0</u><u>lexent\.n21618</u>ga/r<indecl>\:\:<indecl>   <u>indeclinfl\.0</u>


$indecl$ = <u>[#urnchar#]+ [#period#] [#urnchar#]+</u><u>lexent[#period#][#urnchar#]*</u>[#stemchars#]+ <indecl> $separator$+ <indecl>  <u>indeclinfl\.0</u>

%
%Strip out string values from URNs:
%
$squashurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<indecl> $separator$+ <indecl> <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

%
% Strip out all tags
%
#analysissymbol# = #urn# #editorial# #morphtag# #stemtype# #separator# #urntag#
#surfacesymbol# = #character#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$striptag$ = .*




$indeclacceptor$ =  $dict$ || $indecl$ || $squashurn$  || $striptag$
$indeclacceptor$
