% w_regular_infl.fst
% Inflectional patterns for regular omega verbs.
% When complete, this tranducer should completely implement Smyth #383.
%
% Currently includes pres, impft, fut, aor and perf in all 3 voices.
%
% Pluperfect, fut. perfect not yet added
%

$w_regular$ = "<@workdir@inflection/w_regular/indicative.a>" |  "<@workdir@inflection/w_regular/subjunctive.a>" | "<@workdir@inflection/w_regular/optative.a>"  | "<@workdir@inflection/w_regular/imperative.a>"

$w_regular$
