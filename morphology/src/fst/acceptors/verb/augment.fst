% augment.fst
%
#include "@workdir@symbols.fst"


% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense

#augmenttense# = <aor><impft><plupft>

#=ltr# = a-z
ALPHABET = [#letter#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extratag#]
$augmented$ = {[#=ltr#]}:{e<sm>[#=ltr#]} ^-> (<#> __ [#letter#]+<verb><w_regular>[#extratag#]*\:\:<w_regular>[#urn#][#letter#]*[#person#][#number#][#augmenttense#]<indic>)

 $augmented$

% Model to process
%<coretests.n64316_0><lexent.n64316>a<sm>na<#>lu<lo><verb><w_regular>::<w_regular><w_indicative.1>w<1st><sg><fut><indic><act>



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
