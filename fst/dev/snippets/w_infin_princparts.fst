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


$2nd_3rd_pp$

% model
% % <n64316><#>lu<verb><w_regular>::<infin>ein<pres><act><penacc>
% <n64316><#>lu<verb><w_regular>::<infin>ai<aor><act><penacc>
