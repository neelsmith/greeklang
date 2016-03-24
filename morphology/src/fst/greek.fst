%% morphology.fst : a Finite State Transducer for ancient Greek morphology
%
% All symbols used in the FST:
#include "@workdir@symbols.fst"
%
% Dynamically loaded lexica of stems:
$stems$ = @lexica@
%
% Dynamically loaded inflectional rules:
$ends$ = "<@workdir@inflection.a>"
%
% Morphology data is the crossing of stems and endings:
$morph$ = $stems$ $separator$ $separator$ $ends$

%
% Acceptor filters for content satisfying requirements for
% morphological analysis and maps from underlying to surface form.
$acceptor$ = "<@workdir@acceptor.a>"

% Final transducer:
$morph$ || $acceptor$
