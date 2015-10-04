% Snippet to develop infinitive stem mod
#include "../../build/fst/symbols.fst"

%%%%%%%% Tense/voice combinations determining principal part %%%%%%%%%%%%
%
% For regular omega verbs, form stem of 2nd and 3rd
% principal parts by adding sigma.  The stem will be
% identical, for both parts, and is applied
% to the active and middle voice.
% The 6th principal part stem will apply to passive
% voice forms of this set of tenses.
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>
#6th_voice# = <pass>

% Tenses needing reduplication in 4th and 5th parts:
#4th_5th_tense# = <pft><plupft><futpft>

% Perfect tense also adds kappa on 4th part, which
% applies to the active voice only.
#kappatense# = <pft>



%%%%% 2nd and 3rd principal part %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with sigma:
#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#persistacc#]
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#][#stemchars#]+ __ <verb><w_regular>[#extratag#]*[\:]+<infin>[#letter#]+[#2nd_3rd_6th_tense#][<act><mid>][#persistacc#])



%%%%% 6th principal part %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with theta:
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#][#persistacc#]
$6th_pp$ = {[#=ltr#]}:{[#=ltr#]q} ^-> ([#urn#][#stemchars#]+ __ <verb><w_regular>[#extratag#]*[\:]+<infin>[#letter#]+[#2nd_3rd_6th_tense#]<pass>[#persistacc#])





%%%%% 4th and 5th principal parts %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Add reduplication:
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$redupe$ = {[#=ltr#]}:{[#=ltr#]e[#=ltr#]} ^-> ([#urn#]<#> __ [a-z]+<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#letter#]*[#person#][#number#][#4th_5th_tense#])


%%%%% 4th principal part only  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with kappa:
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$kappa$ = {[#=ltr#]}:{[#=ltr#]k} ^-> ([#urn#]<#>[a-z]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#letter#]*[#person#][#number#][#4th_5th_tense#][#mood#]<act>)


% Complete processing of 4th and 5th principal parts:
$4th_5th_pp$ =  $redupe$ || $kappa$


% Final transducer. (NB: leaves stem untouched for 1st principal part.)
%$2nd_3rd_pp$ || $4th_5th_pp$  || $6th_pp$

$2nd_3rd_pp$  || $6th_pp$

% model
% % <n64316><#>lu<verb><w_regular>::<infin>ein<pres><act><penacc>
% <n64316><#>lu<verb><w_regular>::<infin>ai<aor><act><penacc>
