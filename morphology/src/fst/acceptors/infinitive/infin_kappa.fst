% infin_kappa.fst
% Extend stem of infinitive with kappa in 4th principal part
%
#include "@workdir@symbols.fst"


%%%%% 4th principal part only  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Extend stem with kappa:
#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [\:] [<#>] [#stemtype#] [#persistacc#]
$kappa$ = {[#=ltr#]}:{[#=ltr#]k} ^-> ([#stemchars#]+ __ <verb><w_regular>[\:]+<infin>[#letter#]+[<pft><plupft><futpft>]<act>)
$kappa$
