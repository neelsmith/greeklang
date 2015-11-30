%% rawmorph.fst :
% unmodified combinations of stems+inflectional patterns
%
% All symbols used in the FST:
#include "@workdir@symbols.fst"
%
% Dynamically loaded lexica of stems:
$stems$ = @lexica@
%
% Dynamically loaded inflectional rules:
$ends$ = "<@workdir@core_inflection/inflection.a>" @fstrules@
%
% Morphology data is the crossing of stems and endings:
$morph$ = $stems$  $separator$ $separator$ $ends$

$morph$


% Examples of combinations of stem+ending pairings that will pass screening by the `acceptor.a` transducer:
%
% conjugated verb:
% <coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>
