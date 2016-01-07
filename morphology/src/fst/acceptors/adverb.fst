% Adverb acceptor
#include "@workdir@symbols.fst"

$adj$ = <u>[#urnchar#]+ [#period#] [#urnchar#]+</u><u>lexent[#period#][#urnchar#]*</u>[#stemchars#]+ <adv> $separator$+  %% PLUS A LOT MORE ....

$adj$
