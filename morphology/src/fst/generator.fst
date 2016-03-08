% generator.fst
%
% All symbols used in the FST:
#include "@workdir@symbols.fst"
% Dynamically loaded lexica of stems:
$stems$ = @lexica@
%
% Dynamically loaded inflectional rules:
$ends$ = "<@workdir@inflection.a>"
% @fstrules@

%
% Morphology data is the crossing of stems and endings:
$morph$ = $stems$ $separator$ $separator$ $ends$





% Ensure that input matches one of the eight defined analytical pattens.
% $acceptor$ = "<@workdir@acceptors/verb.a>" | "<@workdir@generators/noun.a>" | "<@workdir@acceptors/indeclinable.a>" | "<@workdir@acceptors/infinitive.a>" | "<@workdir@acceptors/participle.a>" | "<@workdir@acceptors/verbaladj.a>" | "<@workdir@acceptors/adverb.a>" | "<@workdir@acceptors/adjective.a>"


$generator$ =  "<@workdir@generators/noungen.a>"


% Final transducer:
$morph$ || $generator$
