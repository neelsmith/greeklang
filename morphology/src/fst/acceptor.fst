% acceptor.fst
%
% Ensure that input matches one of the eight defined analytical pattens.
% To map to surface form, first squash URN values, then remove tags.
%
#include "@workdir@symbols.fst"

%%  Acceptors for each of the 8 analytical patterns
%
% Noun acceptor:
$=nounclass$ = [#nounclass#]
$squashnounurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<noun>$=gender$ $=nounclass$  [#persistacc#]  $separator$+ $=nounclass$ <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> [#stemchars#]* $=gender$ $case$ $number$

% Adjective acceptor:
$squashadjurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<adj>$=adjclass$  [#persistacc#]  $separator$+ <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>$=adjclass$ [#stemchars#]* <adj>$gender$ $case$ $number$ [#degree#]


% Conjugated verb acceptor:
$=verbclass$ = [#verbclass#]
$squashverburn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$ $separator$+$=verbclass$ [#stemchars#]* [#person#] [#number#] [#tense#] [#mood#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


% Verb: infinitive acceptor:
$squashinfinurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$ [#stemchars#]*  [#tense#]  [#voice#]<infin><u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

% Verb: participle acceptor:
$squashptcplurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$ [#stemchars#]*  [#gender#][#case#][#number#][#tense#]  [#voice#]<ptcpl><u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

% Verb: verbal adjective acceptor
$squashvadjurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$ [#stemchars#]*  [#gender#][#case#][#number#]<vadj1><u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


% Indeclinable form acceptor:
$=indeclclass$ = [#indeclclass#]
$squashindeclurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+ $=indeclclass$ $separator$+ $=indeclclass$ <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>



%% Union of all acceptor squashers:
$acceptor$ = $squashverburn$ | $squashnounurn$ | $squashinfinurn$ | $squashptcplurn$ | $squashvadjurn$  | $squashindeclurn$


%% Put all symbols in 2 categories:  pass through
%% surface symbols, squash analytical symbols.
#analysissymbol# = #editorial# #urntag# <noun><verb> #morphtag# #stemtype#  #separator# #accent#
#surfacesymbol# = #letter# #diacritic#  #breathing#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$stripsym$ = .+


%% The canonical pipeline: (morph data) -> acceptor -> parser/stripper
$acceptor$ || $stripsym$
