% acceptor.fst
% Ensure that input matches one of the eight defined analytical pattens,
% squash URN values.

% $acceptor$ = "<@workdir@acceptors/verb.a>" | "<@workdir@acceptors/noun.a>" | "<@workdir@acceptors/indeclinable.a>" | "<@workdir@acceptors/infinitive.a>" | "<@workdir@acceptors/participle.a>" | "<@workdir@acceptors/verbaladj.a>" | "<@workdir@acceptors/adverb.a>" | "<@workdir@acceptors/adjective.a>"




#include "@workdir@symbols.fst"

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%% COMBINE ACCEPTOR AND URN SQUASHER IN ONE TRANSDUCER:
%
$=nounclass$ = [#nounclass#]
$squashnounurn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<noun>$=gender$ $=nounclass$  [#persistacc#]  $separator$+ $=nounclass$ <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> [#stemchars#]* $=gender$ $case$ $number$



$=verbclass$ = [#verbclass#]
$squashverburn$ = <u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u> <u>{lexent}:<>\.:<>[#urnchar#]:<>+</u>[#stemchars#]+<verb>$=verbclass$ $separator$+$=verbclass$ [#stemchars#]* [#person#] [#number#] [#tense#] [#mood#] [#voice#]<u>[#urnchar#]:<>+\.:<>[#urnchar#]:<>+</u>


% Union of all acceptor squashers:
$squasher$ = $squashverburn$ | $squashnounurn$


%%%%%%%%%%%%%%%%%%%% STRIP OUT ALL TAGS %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
#analysissymbol# = #editorial# #urntag# <noun><verb> #morphtag# #stemtype#  #separator#

#surfacesymbol# = #character#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$stripsym$ = .+



%% Finally, strip accents in irregulars and fixed accent words:
#bareletter# = #letter# #diacritic#  #breathing#
ALPHABET = [#bareletter#] [#accent#]:<>
$stripacc$ = .+

$squasher$ || $stripsym$ || $stripacc$
