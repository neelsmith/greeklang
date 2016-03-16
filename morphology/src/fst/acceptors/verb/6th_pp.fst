% 6th_pp.sft
%
#include "@workdir@symbols.fst"

#2nd_3rd_6th_tense# = <aor><fut><futpft>


%%%%% 6th principal part %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with theta:
#=ltr# = #stemchars#
ALPHABET = [#letter#] [#morphtag#]  [\:] [<#>] [#stemtype#] [#vowelquant#]
$6th_pp$ = {[#=ltr#]}:{[#=ltr#]q} ^-> ([#stemchars#]+ __ <verb><w_regular>[\:]+<w_regular>[#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#]<pass>)

$6th_pp$
