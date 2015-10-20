%

#include "../../build/fst/symbols.fst"

#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>





%%%%% 2nd and 3rd principal part %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with sigma:
#=ltr# = #stemchars#
%ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#] [#urntag#] [#period#]

%$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#]+[#stemchars#]+ __ <verb><w_regular>[#extratag#]*[\:]+<w_regular>[#urn#][#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#])




ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#] [#urntag#] [#period#]
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^->  (<u>[#urnchar#]+ [#period#] [#stemchars#]+ __ )





%%% (<u>[#urnchar#]+ [#period#] [#urnchar#]+</u>[#stemchars#]+  __ )



% <u>lexent[#period#]
%[#urnchar#]+</u>[#stemchars#]+ __  )


% <verb> )


%<w_regular>[#extratag#]*[\:]+ )


%%[#letter#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#] <u>[#urnchar#]+ [#period#] [#urnchar#]+</u>)



$2nd_3rd_pp$


%%% EXAPLE OF COMPOUND to PARSE AND GENERATE (1st part):
% <u>coretests.n64316_0</u><u>lexent.n64316</u><#>lu<lo><verb><w_regular>
% plus :: plus
% w<1st><sg><pres><indic><act><u>w_indicative.1</u>
% or plus :: plus
% % w<1st><sg><fut><indic><act><u>w_indicative.1</u>
%
%
% OUT OF DATE:
%<coretests.n6949_0><lexent.n6949>a<sm>na<#>lu<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><pres><indic><act>
%
% FOR SECOND PART:
%generate from  <coretests.n6949_0><lexent.n6949>a<sm>na<#>lu<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>
