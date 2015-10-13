% Get these strings past pp2:
%
% <coretests.n64316_0><lexent.n64316><#>lu<verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>
%<coretests.n64316_0><lexent.n64316><#>lu<long><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>

%<coretests.n6949_0><lexent.n6949>a)na<#>lu<long><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>


% FAILS IN MAIN BUILD:
% <coretests.n6949_0><lexent.n6949>a)na<#>lu<long><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>


%%%
% <coretests.n6949_0><lexent.n6949>a)na<#>lu<long><verb><w_regular>::<w_regular><w_indicative.43>a<1st><sg><fut><indic><act>


% <coretests.n64316_0><lexent.n64316>peri<#>lu<long><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>



%%% SUCCEEDED:
% <coretests.n64316_0><lexent.n64316>a<smooth>na<#>lu<long><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>


%%%%
#include "../../build/fst/symbols.fst"

#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>


%%%%% 2nd and 3rd principal part %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with sigma:
#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#]+[#stemchars#]+ __ [#vowelquant#]*<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#])

$2nd_3rd_pp$
