% 2nd_3rdpp.sft
%
#include "@workdir@symbols.fst"

% Tense/voice combinations for second-third principal parts
%
% For regular omega verbs,  extend the stem of 2nd and 3rd
% principal parts by adding sigma.  The stem will be
% identical, for both parts, and is applied to the active and middle voice.
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>


%%%%% 2nd and 3rd principal part %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with sigma:
%%#=ltr# = a-z
%%ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]:<>
%%$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#]+[#stemchars#]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#])




%%%%% 2nd and 3rd principal part %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with sigma:
#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#]+[#stemchars#]+ __ [#vowelquant#]*<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#])

$2nd_3rd_pp$


%%% SUCCEEDED running directly from .a file before making multichar for smooth breathing ie using ")"
% <coretests.n64316_0><lexent.n64316>a<smooth>na<#>lu<long><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>
