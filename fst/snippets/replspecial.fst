%How to replace special chars like the colon :



#ltr# = a-z
#smooth# =  \)
#rough# = \(
#breathing# = #smooth# #rough#
#alphachar# = #ltr# #breathing#

#urn# = <n64316>
#pos# = <verb>
#tense# = <pres><impft><aor><pft><plupft><fut><futpft>
#person# = <1st>
#number# = <sg>
#mood# = <indic>
#voice# = <act><mid><pass>

#morphtag# = #pos# #person# #number# #tense# #mood# #voice#

#stemtype# = <w_regular>

#extras# = <ml><hmt>

#augmenttense# = <aor><impft><plupft>
#not_augmented# = <pres><fut><pft><futpft>


% not really 2nd pp:  just stems needing -sigma extension
#2ndpptense# = <aor><fut>

% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense
#=ltr# = a-z


ALPHABET = [#alphachar#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extras#]
$2ndpp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#]<#>[a-z]+ __ <verb><w_regular>[#extras#]*[\:]+<w_regular>[#alphachar#]*[#person#][#number#][#2ndpptense#])

$tstlexicon$ = <n64316><#>lu<verb><w_regular><ml>\:\:<w_regular>w<1st><sg>[#tense#]<indic><act><hmt>



$tstlexicon$ || $2ndpp$
