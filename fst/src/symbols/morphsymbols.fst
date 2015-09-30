% morphsymbols.fst
%
% Definitions of all symbols used to express a morphological analysis
%
% Parts of speech:
#pos# = <noun><verb><adj>
%
% 1. Noun morphology:
%
#gender# = <masc><fem><neut>
#case# = <nom><acc><gen><dat><voc>
#number# = <sg><dual><pl>
%
% 2. Adjective morphology:
%
#degree# = <posit><comp><superl>
%
% 3. Verb morphology:
%
#person# = <1st><2nd><3rd>
% number already defined in noun morphology
#tense# = <pres><impft><fut><aor><pft><plupft>
#mood# = <indic><subj><opt><imptv>
#voice# = <act><mid><pass>


#morphtag# = #pos# #gender# #case# #number# #person# #tense# #mood# #voice# #degree#


#persistacc# = <ultacc><penacc><antacc>

% Consider whether those belong here or elsewhere...?

% Transducers for the above variables:
$gender$ = [#gender#]
$case$ = [#case#]
$number$ = [#number#]


% Identity variables for the transducers:
$=gender$ = [#gender#]
$=case$ = [#case#]
$=number$ = [#number#]
