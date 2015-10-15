%

#include "../../build/fst/symbols.fst"

#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>


%%%%% 6th principal part %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with theta:
#=ltr# = #stemchars#
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$6th_pp$ = {[#=ltr#]}:{[#=ltr#]q} ^-> ([#urn#]+[#stemchars#]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#]<pass>)

$6th_pp$



%%% EXAPLE OF COMPOUND to PARSE AND GENERATE (1st part):
%<coretests.n6949_0><lexent.n6949>a<sm>na<#>lu<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>
%
% FOR SIXTH PART:
%
%<coretests.n64316_0><lexent.n64316><#>lu<lo>q<verb><w_regular>::<w_regular><w_indicative.67>hsomai<1st><sg><fut><indic><pass>
% <coretests.n6949_0><lexent.n6949>a<sm>na<#>lu<lo>q<verb><w_regular>::<w_regular><w_indicative.67>hsomai<1st><sg><fut><indic><pass>
%
