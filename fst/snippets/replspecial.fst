%How to replace special chars like the colon :



#ltr# = a-z
#smooth# =  \)
#rough# = \(
#breathing# = #smooth# #rough#
#alphachar# = #ltr# #breathing#

#urn# = <n64316>
#pos# = <verb>
#tense# = <pres><impft><aor><pft><plupft><fut><futpft>
#morphtag# = #pos# #tense#

#augmenttense# = <aor><impft><plupft>
#not_augmented# = <pres><fut><pft><futpft>


% not really 2nd pp:  just stems needing -sigma extension
#2ndpptense# = <aor><fut>

% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense
#=ltr# = a-z


ALPHABET = [#alphachar#] [#morphtag#] [#urn#] [#breathing#] [\:] [<#>]
$2ndpp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#]<#>[a-z]+ __ <verb>[\:]+[#2ndpptense#])

$tstlexicon$ = <n64316><#>lu<verb>\:\:[#tense#]



$tstlexicon$ || $2ndpp$
