% infin_6th.fst
% Extend stem of infinitive with theta in 6th principal part
%
#include "@workdir@symbols.fst"

#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [\:] [<#>] [#stemtype#] [#persistacc#]
$6th_pp$ = {[#=ltr#]}:{[#=ltr#]q} ^-> ([#stemchars#]+ __ <verb><w_regular>[\:]+<infin>[#letter#]+[<aor><fut>]<pass>[#persistacc#])
$6th_pp$
