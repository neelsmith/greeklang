%% morphology.fst : a Finite State Transducer for ancient Greek morphology
%
% All symbols used in the FST:
#include "@workdir@symbols.fst"
%
% Dynamically loaded lexica of stems:
$stems$ = @lexica@
%
% Dynamically loaded inflectional rules:
$ends$ = "<@workdir@inflection.a>" @fstrules@
%
% Morphology data is the crossing of stems and endings:
$morph$ = $stems$ \:\: $ends$

$morph$


% Examples of valid formats. (These can be screened by the `acceptor.a` transducer.)
%
% noun: <n67485>mhn<noun><fem><is_ios>::<is_ios>is<fem><nom><sg>
%
% conjugated verb: <n64316><#>lu<verb><w_regular>::<w_regular>w<1st><sg><pres><indic><act>
% verbal adjective: <n64316><#>lu<verb><w_regular>::<vadj>teon<neut><nom><sg><penacc>
%
% FAILING: infinitive
%<n64316><#>lu<verb><w_regular>::<infin>ein<pres><act><penacc>
%
