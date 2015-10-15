% Get these strings past pp6:
%
%


%%%%
#include "../../build/fst/symbols.fst"

#4th_5th_tense# = <pft><plupft>


% Add reduplication on 4th and 5th parts:
#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]


%%%%% 4th and 5th principal parts %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with kappa in 4th (active voice):
#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$kappa$ = {[#=ltr#]}:{[#=ltr#]k} ^-> ([#urn#]+[#stemchars#]+ __ [#vowelquant#]*<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#4th_5th_tense#][#mood#]<act>)

% Works with both 4-5 parts and passes through 1st part:
% $kappa$

% Reduplication on both 4th and 5th parts:
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$redupe$ = {[#=ltr#]}:{[#=ltr#]e[#=ltr#]}  ^-> ([#urn#]+<#>? __ [#stemchars#]+<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#4th_5th_tense#][#mood#][#voice#])


% Works with both 4-5 parts and passes through 1st part:
% $redupe$



$4th_5th_pp$ =   $kappa$ || $redupe$
$4th_5th_pp$






%% Strings to test:
%
% Pass through a first part (unmodified stem):
% <coretests.n6949_0><lexent.n6949>a<sm>na<#>lu<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>
%
% FOURTH AND FIFTH PARTS:
%
%<coretests.n64316_0><lexent.n64316><#>leluk<verb><w_regular>::<w_regular><w_indicative.43>a<1st><sg><pft><indic><act>
%
% <coretests.n6949_0><lexent.n6949>a<sm>na<#>leluk<verb><w_regular>::<w_regular><w_indicative.43>a<1st><sg><pft><indic><act>
