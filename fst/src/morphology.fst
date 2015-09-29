%% morphology.fst : a Finite State Transducer for ancient Greek morphology %%

% All symbols used in the FST:
#include "@workdir@allsymbols.fst"

% Dynamically loaded lexica of stems:
$stems$ = @lexica@

% Dynamically loaded inflectional rules:
$ends$ =  "<@workdir@inflection.a>" | @extrafstrules@


$morph$ = $stems$ $separator$ $separator$ $ends$

% #morphtag# is defined in "symbols.fst"
% #stemtype#  is defined in "stemtypes.fst"
% #extratag#  is defined in "extratgs.fst"
ALPHABET = [#character#] [#extratag#]:<> [#morphtag#]:<> [#stemtype#]:<> [#separator#]:<> [#urn#]:<>
$striptags$ = .*



$acceptor$ = "<@workdir@acceptor.a>"
$acceptor$ || $morph$ || $striptags$


% From input to analysis:
% mhnis
% we get analysis output:
% <n67485>mhn<noun><fem><is_ios>::<is_ios>is<fem><nom><sg>
% Verb example: luw
% We hope to get
% <n64316>lu<verb><w_regular>::<w_regular>w<1st><sg><pres><indic><act>
