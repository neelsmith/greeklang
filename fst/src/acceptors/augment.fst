% augment.fst
%
#include "@workdir@symbols.fst"


% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense

#augmenttense# = <aor><impft><plupft>

#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$augmented$ = {[#=ltr#]}:{e\)[#=ltr#]} ^-> (<#> __ [#letter#]+<verb><w_regular>[#extratag#]*\:\:<w_regular>[#letter#]*[#person#][#number#][#augmenttense#])

 $augmented$

% Model to process
%<n64316><#>lu<verb><w_regular>::<w_regular>a<1st><sg><aor><indic><act>
