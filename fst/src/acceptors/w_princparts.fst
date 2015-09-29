% A transducer for w_regular verbs; parallel transducers
% could handle other regular patterns like contract verbs.


#include "@workdir@symbols.fst"

%
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>
#6th_voice# = <pass>





% reduplication on 4th and 5th:
#4th_5th_tense# = <pft><plupft><futpft>

% also -kappa on 4th
#kappatense# = <pft>




% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense
#=ltr# = a-z

% Extend second and third principal parts with sigma:
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#]<#>[a-z]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#])

% Extend 6th principal part with theta:
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$6th_pp$ = {[#=ltr#]}:{[#=ltr#]q} ^-> ([#urn#]<#>[a-z]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#6th_voice#])

% Add reduplication on 4th and 5th parts:
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$redupe$ = {[#=ltr#]}:{[#=ltr#]e[#=ltr#]} ^-> ([#urn#]<#> __ [a-z]+<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#letter#]*[#person#][#number#][#4th_5th_tense#])

% Add kappa to 4th only: restrict to active voice.
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$kappa$ = {[#=ltr#]}:{[#=ltr#]k} ^-> ([#urn#]<#>[a-z]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#letter#]*[#person#][#number#][#4th_5th_tense#][#mood#]<act>)


$4th_5th_pp$ =  $redupe$ || $kappa$

%$synoptic$ ||  $2nd_3rd_pp$ || $4th_5th_pp$  || $6th_pp$ || $striptag$

$2nd_3rd_pp$ || $4th_5th_pp$  || $6th_pp$
