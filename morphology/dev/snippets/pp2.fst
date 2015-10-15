%

#include "../../build/fst/symbols.fst"

#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>


%%%%% 2nd and 3rd principal part %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with sigma:
#=ltr# = #stemchars#
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#]+[#stemchars#]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#])


$2nd_3rd_pp$


%%% EXAPLE OF COMPOUND to PARSE AND GENERATE (1st part):
%<coretests.n6949_0><lexent.n6949>a<sm>na<#>lu<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>
%
% FOR SECOND PART:
%generate from  <coretests.n6949_0><lexent.n6949>a<sm>na<#>lu<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>
