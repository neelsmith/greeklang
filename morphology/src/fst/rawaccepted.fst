
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
$morph$ = $stems$ \:\: $ends$

%
% Acceptor filters for content satisfying requirements for morphological analysis
$acceptor$ = "<@workdir@acceptor.a>"


$morph$ || $acceptor$ 
