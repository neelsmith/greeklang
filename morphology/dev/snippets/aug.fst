%

#include "../../build/fst/symbols.fst"

#augmenttense# = <aor><impft><plupft>


%%%%% Add augment %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$augmented$ = {[#=ltr#]}:{e<sm>[#=ltr#]} ^-> ([#urn#]+[#stemchars#]*<#> __ [#stemchars#]+<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#augmenttense#]<indic>[#voice#])





$augmented$

% Wrong b/c it doesn't check for consonant following;
%<coretests.n6949_0><lexent.n6949>a<sm>na<#>e<sm>lu<lo><verb><w_regular>::<w_regular><w_indicative.14>es<2nd><sg><impft><indic><act>


%%% EXAMPLES
% First-part to pass through unchanged
%<coretests.n6949_0><lexent.n6949>a<sm>na<#>lu<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>
%
% AUGMENTED
%
%<coretests.n64316_0><lexent.n64316><#>e<sm>lu<verb><w_regular>::<w_regular><w_indicative.14>es<2nd><sg><impft><indic><act>
