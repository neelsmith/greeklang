%How to replace special chars like the colon :



#ltr# = a-z
#smooth# =  \)
#rough# = \(
#breathing# = #smooth# #rough#
#alphachar# = #ltr# #breathing#

#urn# = <n64316>
#tense# = <pres><impft><aor><pft><plupft><fut><futpft>

#augmenttense# = <aor><impft><plupft>
#not_augmented# = <pres><fut><pft><futpft>

#2ndpptense# = <aor><fut>

% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense
#=ltr# = a-z


ALPHABET = [#alphachar#] [#tense#] [#urn#] [#breathing#] [\:] [<#>]
$2ndpp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#]<#>[a-z]+ __ [\:]+[#2ndpptense#])

$tstlexicon$ = <n64316><#>lu\:\:[#tense#]



$tstlexicon$ || $2ndpp$
