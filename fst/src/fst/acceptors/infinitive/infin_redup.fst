% infin_redup.fst
% Reduplicate stem of infinitive in 4th and 5th principal parts
%
#include "@workdir@symbols.fst"




%%%%% 4th and 5th principal parts %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Add reduplication:
#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#][#persistacc#]
$redupe$ = {[#=ltr#]}:{[#=ltr#]e[#=ltr#]} ^-> ([#urn#][<#>]* __ [#stemchars#]+<verb><w_regular>[#extratag#]*[\:]+<infin>[#letter#]+[<pft><plupft><futpft>][#voice#]<penacc>)
$redupe$
