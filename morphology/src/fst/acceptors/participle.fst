% participle.fst
% Acceptor for participle pattern:
% tense, voice, gender, case number
#include "@workdir@symbols.fst"

$ptcpl$ = <ptcplform> %%% <u>[#urnchar#]+ [#period#] [#urnchar#]+</u><u>lexent[#period#][#urnchar#]*</u>[#stemchars#]+ <adj> $separator$+  %% PLUS A LOT MORE ....



$ptcpl$
