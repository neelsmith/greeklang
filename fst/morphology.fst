%% morphology.fst : a Finite State Transducer for ancient Greek morphology %%

#include "symbols.fst"
#include "phonology.fst"

$stemraw$ = "lexiconsrc.fst"

ALPHABET = [#character#] [#tag#]

$stemraw$
