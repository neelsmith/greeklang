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
$squashnounurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<noun>$=gender$ $=nounclass$  [#persistacc#]  $separator$+ $=nounclass$  <noun> [#stemchars#]* $=gender$ $case$ $number$ <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

% Adjective acceptor:
%% <u>smyth.n260_0</u><u>lexent.n260</u>a<sm>gaq<adj><os_h_on><inflacc>::<os_h_on>os<adj><masc><nom><sg><pos><u>adjinfl.os_h_on1</u>

$=adjclass$ = [#adjectiveclass#]
$squashadjurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<adj>$=adjclass$  [#persistacc#]  $separator$+ $=adjclass$ <adj> [#stemchars#]* $gender$ $case$ $number$ [#degree#] <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


% Adverb acceptor:
$squashadvurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<adj>$=adjclass$  [#persistacc#]   $separator$+ $=adjclass$ <adv> [#stemchars#]* [#degree#]  <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

% Conjugated verb acceptor:
$=verbclass$ = [#verbclass#]


$squashverburn$ = "<@workdir@acceptors/verb.a>"


% Verb: infinitive acceptor:
$squashinfinurn$  = "<@workdir@acceptors/infinitive.a>"


% Verb: participle acceptor:
$squashptcplurn$ =  "<@workdir@acceptors/participle.a>"


%%% <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$ <ptcpl>[#stemchars#]*  [#gender#][#case#][#number#][#tense#]  [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

% Verb: verbal adjective acceptor
$squashvadjurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$  $separator$+$=verbclass$ <vadj>[#stemchars#]*  [#gender#][#case#][#number#][#vadj#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


% Indeclinable form acceptor:
$=indeclclass$ = [#indeclclass#]
$squashindeclurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u> [#stemchars#]+  $=indeclclass$  $separator$+  $=indeclclass$ <indecl> <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


%% Irregular forms:
% Irregular noun acceptor
$squashirregnounurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+ $gender$ $case$ $number$ <irregnoun>  $separator$+ <irregnoun><noun><u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


$=ptcplclass$ = [#verbclass#]
$squashirregptcplurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+ $tense$ $voice$ $gender$ $case$ $number$ <irregptcpl>  $separator$+ <irregptcpl><ptcpl><u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


% Pronoun acceptor
$squashpronounurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+  <pron> $=adjclass$  [#persistacc#]  $separator$+ $=adjclass$ <adj> [#stemchars#]* $gender$ $case$ $number$ <pos> <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>

%% Union of all URN squashers:
$acceptor$ = $squashverburn$ | $squashnounurn$ | $squashinfinurn$ | $squashptcplurn$ | $squashvadjurn$  | $squashindeclurn$ | $squashadjurn$ | $squashadvurn$  | $squashpronounurn$ | $squashirregnounurn$ | $squashirregptcplurn$

%% Put all symbols in 2 categories:  pass
%% surface symbols through, suppress analytical symbols.
#analysissymbol# = #editorial# #urntag# <noun><verb><indecl><ptcpl><infin><vadj><adj><adv> #morphtag# #stemtype#  #separator# #accent#
#surfacesymbol# = #letter# #diacritic#  #breathing#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$stripsym$ = .+

%% The canonical pipeline: (morph data) -> acceptor -> parser/stripper
$acceptor$ || $stripsym$
