% 2nd_3rdpp.sft
%
#include "@workdir@symbols.fst"

#2nd_3rd_6th_tense# = <aor><fut><futpft>

% Extend stem with theta for 6th principal part
#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$6th_pp$ = {[#=ltr#]}:{[#=ltr#]q} ^-> ([#urn#]<#>[a-z]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#]<pass>)

$6th_pp$
