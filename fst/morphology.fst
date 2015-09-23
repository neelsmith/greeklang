%% morphology.fst : a Finite State Transducer for ancient Greek morphology %%

#include "symbols.fst"
#include "extratags.fst"
#include "phonology.fst"

$stemraw$ = "lexicon.fst"
$stems$ = $stemraw$

% Compile when stable:  use .fst in dev't:
%$ends$ = "inflection.fst"
$ends$ = "<inflection.a>"

$morph$ = $stems$ $ends$

% $morph$ YIELDS:
%generate> mhn<fem><is_ios><is_ios>is<nom><sg>
%mhn<fem><is_ios><is_ios>is<nom><sg>
%generate>
%analyze> mhn<fem><is_ios><is_ios>is<nom><sg>
%mhn<fem><is_ios><is_ios>is<nom><sg>


% Compile when stable:  use .fst in dev't:
$acceptor$ = "<acceptor.a>"
%$acceptor$ = "acceptor.fst"


$acceptor$ || $morph$
%$morph$
%$stems$ $ends$

%ALPHABET = [#character#] [#tag#]
