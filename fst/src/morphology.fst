%% morphology.fst : a Finite State Transducer for ancient Greek morphology %%

#include "symbols.fst"
#include "phonology.fst"

$stemraw$ = "lexicon.fst" |  "iliad.fst"
%$stemraw$ =  "iliad.fst"
$stems$ = $stemraw$



$ends$ = "<inflection.a>"
$extrainfl$ = "<extrainfl.a>"

%$morph$ = ($stems$ | $extrastems$ ) ($ends$ | $extrainfl$ )
$morph$ = $stems$  ($ends$ | $extrainfl$ )

% $morph$ YIELDS:
%generate> mhn<fem><is_ios><is_ios>is<nom><sg>
%mhn<fem><is_ios><is_ios>is<nom><sg>
%generate>
%analyze> mhn<fem><is_ios><is_ios>is<nom><sg>
%mhn<fem><is_ios><is_ios>is<nom><sg>


$acceptor$ = "<acceptor.a>"



$acceptor$ || $morph$
%$morph$

%$stems$

% analyze> basil<masc><eus_ews><eus_ews>eus<masc><nom><sg>
% basil<masc><eus_ews><eus_ews>eus<masc><nom><sg>

%ALPHABET = [#character#] [#tag#]
