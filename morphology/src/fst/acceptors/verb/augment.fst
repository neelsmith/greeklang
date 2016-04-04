% augment.fst
%
#include "@workdir@symbols.fst"


% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense

ALPHABET = [#editorial# #urntag# #urnchar# <verb> #morphtag# #stemtype#  #separator# #accent# #letter# #diacritic#  #breathing# \. #stemchars# ]

#augmenttense# = <aor><impft><plupft>


#=ltr# = #consonant#
$augmentsimplecons$ = {[#=ltr#]}:{e<sm>[#=ltr#]} ^-> ( <#> __ [#stemchars#]+<verb>[#verbclass#]\:\:[#verbclass#]<verb>[#stemchars#]+[#person#][#number#][#augmenttense#]<indic>[#voice#]<u>[#urnchar#]+[#period#][#urnchar#]+</u>)


$simplex$ = $augmentsimplecons$

$allaugment$ =  $simplex$ %% and compounds, too...

$allaugment$


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
