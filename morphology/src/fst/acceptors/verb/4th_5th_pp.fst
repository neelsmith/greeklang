% 4th_5th_pp.sft
%
#include "@workdir@symbols.fst"

% Tense/voice combinations for fourth-fifth principal parts
%
% For regular omega verbs,  reduplicate in all voices.
% In perfect active, extend stem with kappa.
% In pluperfect, augment is taken care of separately?
%

% reduplication on 4th and 5th:
#4th_5th_tense# = <pft><plupft>



% Reduplication:
#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$redupe$ = {[#=ltr#]}:{[#=ltr#]e[#=ltr#]}  ^-> ([#urn#]+<#>? __ [a-z]+<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#4th_5th_tense#][#mood#][#voice#])


ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$kappa$ = {[#=ltr#]}:{[#=ltr#]k} ^-> ([#urn#]+<#>[a-z]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#4th_5th_tense#][#mood#]<act>)


$4th_5th_pp$ =  $redupe$ || $kappa$

$4th_5th_pp$

%<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>
