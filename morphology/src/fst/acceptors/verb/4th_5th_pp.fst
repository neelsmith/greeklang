% 4th_5th_pp.sft
%
#include "@workdir@symbols.fst"

% Tense/voice combinations for fourth-fifth principal parts
%
% For regular omega verbs,  reduplicate in all voices.
% In perfect active, extend stem with kappa.
% In pluperfect, augment is taken care of separately?
%


#4th_5th_tense# = <pft><plupft>


% Add reduplication on 4th and 5th parts:
#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]


%%%%% 4th and 5th principal parts %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with kappa in 4th (active voice):
% Extend stem with kappa in 4th (active voice):
#=ltr# = #stemchars#
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$kappa$ = {[#=ltr#]}:{[#=ltr#]k} ^-> ([#urn#]+[#stemchars#]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#4th_5th_tense#][#mood#]<act>)


% Add reduplication on both 4th and 5th parts:
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$redupe$ = {[#=ltr#]}:{[#=ltr#]e[#=ltr#]}  ^-> ([#urn#]+[#inmorpheme#]*<#> __ [#stemchars#]+<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#4th_5th_tense#][#mood#][#voice#])

$4th_5th_pp$ =   $kappa$ || $redupe$
$4th_5th_pp$


%<coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>
