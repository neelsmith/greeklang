#include "@workdir@stemtypes.fst"


% Variables with symbols for morphological concepts.
%
% Parts of speech:
#pos# = <noun><verb><adj>

%
% 1. Noun morphology:
%
#gender# = <masc><fem><neut>
#case# = <nom><acc><gen><dat><voc>
#number# = <sg><pl>
%
% 2. Adjective morphology:
%
%
% 3. Verb morphology:
%


#morphtags# = #pos# #gender# #case# #number#





% Transducers for the above variables:
$gender$ = [#gender#]
$case$ = [#case#]
$number$ = [#number#]




% Identity variables for the transducers:
$=gender$ = [#gender#]
$=case$ = [#case#]
$=number$ = [#number#]
