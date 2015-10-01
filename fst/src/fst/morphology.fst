%% morphology.fst : a Finite State Transducer for ancient Greek morphology
%
% All symbols used in the FST:
#include "@workdir@symbols.fst"
%
% Dynamically loaded lexica of stems:
$stems$ = @lexica@
%
% Dynamically loaded inflectional rules:
$ends$ =  "<@workdir@inflection.a>" | @extrafstrules@
%
% Morphology data is the crossing of stems and endings:
$morph$ = $stems$ $separator$ $separator$ $ends$

%
% Acceptor filters for content satisfying requirements for morphological analysis
$acceptor$ = "<@workdir@acceptor.a>"

%
% Formatting: suppress analytical markup in surface forms:
#surfacesymbol# = #character#
#analysissymbol# = #urn# #editorial# #morphtag# #stemtype# #extratag# #separator#
ALPHABET = [#surfacesymbol#] [#analysissymbol#]:<>
$striptags$ = .*


% Final transducer:
$morph$ || $acceptor$  || $striptags$


% Examples of translations from surface form to analysis:
%
% input:  mhnis
% output: <n67485>mhn<noun><fem><is_ios>::<is_ios>is<fem><nom><sg>
%
% input:  luw
% output: <n64316><#>lu<verb><w_regular>::<w_regular>w<1st><sg><pres><indic><act>
