% Get these strings past pp6:
%
%


%%%%
#include "../../build/fst/symbols.fst"

#4th_5th_tense# = <pft><plupft>


%%%%% 4th and 5th principal parts %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with kappa in 4th (active voice):
#=ltr# = #stemchars#
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$kappa$ = {[#=ltr#]}:{[#=ltr#]k} ^-> ([#urn#]+[#stemchars#]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#4th_5th_tense#][#mood#]<act>)


% Add reduplication on both 4th and 5th parts:
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$redupe$ = {[#=ltr#]}:{[#=ltr#]e[#=ltr#]}  ^-> ([#urn#]+[#inmorpheme#]*<#> __ [#stemchars#]+<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#4th_5th_tense#][#mood#][#voice#])

$4th_5th_pp$ =   $kappa$ || $redupe$
$4th_5th_pp$


% Works with both 4-5 parts and passes through 1st part:
% $kappa$

% Works with both 4-5 parts and passes through 1st part:
% $redupe$








%% Strings to test:
%
% Pass through a first part (unmodified stem):
% <coretests.n6949_0><lexent.n6949>a<sm>na<#>lu<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>
%
% FOURTH AND FIFTH PARTS:
%
%<coretests.n64316_0><lexent.n64316><#>lelu<lo>k<verb><w_regular>::<w_regular><w_indicative.43>a<1st><sg><pft><indic><act>
%
% <coretests.n6949_0><lexent.n6949>a<sm>na<#>leluk<verb><w_regular>::<w_regular><w_indicative.43>a<1st><sg><pft><indic><act>
