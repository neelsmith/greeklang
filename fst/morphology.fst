%% morphology.fst : a Finite State Transducer for ancient Greek morphology %%

#include "symbols.fst"
#include "phonology.fst"

$stemraw$ = "lexiconsrc.fst"
$stems$ = $stemraw$
$ends$ = "<inflection.a>"

%$morph$ = $stems$ {\:\:}:<> $ends$

$morph$ = $stems$ $ends$

% $morph$ YIELDS:
%generate> mhn<fem><is_ios>::<is_ios>is<nom><sg>
%mhn<fem><is_ios><is_ios>is<nom><sg>
%generate>
%analyze> mhn<fem><is_ios><is_ios>is<nom><sg>
%mhn<fem><is_ios>::<is_ios>is<nom><sg>

$acceptor$ = "<acceptor.a>"

$acceptor$ || $morph$


%ALPHABET = [#character#] [#tag#]
