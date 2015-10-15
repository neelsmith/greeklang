% Get these strings past pp6:
%
%


%%%%
#include "../../build/fst/symbols.fst"

#2nd_3rd_6th_tense# = <aor><fut><futpft>

% Extend stem with theta for 6th principal part
#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$6th_pp$ =  {[#=ltr#]}:{[#=ltr#]q} ^-> ([#urn#]+[#stemchars#]+ __ [#vowelquant#]*<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#]<pass>)

$6th_pp$


%% Strings to test:
%
% <coretests.n64316_0><lexent.n64316><#>luq<verb><w_regular>::<w_regular><w_indicative.67>hsomai<1st><sg><fut><indic><pass>
%
% <coretests.n6949_0><lexent.n6949>a<sm>na<#>luq<verb><w_regular>::<w_regular><w_indicative.67>hsomai<1st><sg><fut><indic><pass>
