% infin_2nd-3rd.fst
% Extend stem of infinitive with sigma in 2nd and 3rd principal parts
%
#include "@workdir@symbols.fst"

#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [\:] [<#>] [#stemtype#] [#persistacc#]
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#][#sigma#]} ^-> ([#stemchars#]+ __ <verb><w_regular>[\:]+<infin>[#letter#]+[<aor><fut><futpft>][<act><mid>][#persistacc#])

$2nd_3rd_pp$
