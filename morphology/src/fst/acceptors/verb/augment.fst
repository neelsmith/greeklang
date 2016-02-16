% augment.fst
%
#include "@workdir@symbols.fst"


% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense

#augmenttense# = <aor><impft><plupft>


%%%%% Add augment %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#]  [\:] [<#>] [#stemtype#] [#extratag#] [#vowelquant#]
$augmented$ = {[#=ltr#]}:{e<sm>[#=ltr#]} ^-> ([#stemchars#]*<#> __ [#stemchars#]+<verb><w_regular>[#extratag#]*[\:]+<w_regular>[#letter#]*[#person#][#number#][#augmenttense#]<indic>[#voice#])


 $augmented$


%% Account for these VC patterns:
%  pros<#>  ->pros<#>e
%  pro<#>  ->pro<#>e or prou<#>
%  a<sm>na<#>  -> a<sm>n<#>e
% <#> -> e<sm>
%
% Account for verb contractions:
% a -> h
% e -> ei
% o -> ou
%
