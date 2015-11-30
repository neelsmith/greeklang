%% inflection.fst
% A transducer accepting all inflectional patterns.
%

$ending$ = "<@workdir@core_inflection/inflection/nouninfl.a>" | "<@workdir@core_inflection/inflection/verbinfl.a>" | "<@workdir@core_inflection/inflection/vadjinfl.a>" | "<@workdir@core_inflection/inflection/infininfl.a>"

$ending$
