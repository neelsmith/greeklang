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


%
#2nd_3rd_6th_tense# = <aor><fut><futpft>
#2nd_3rd_voice# = <act><mid>
#6th_voice# = <pass>

#nosigmatense# = <pres><impft><pft><plupft>



% reduplication on 4th and 5th:
#redupetense# = <pft><plupft><futpft>
% also -kappa on 4th
#kappatense# = <pft>


% 6th
#thetatense# = <aor><fut>


% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense
#=ltr# = a-z


ALPHABET = [#alphachar#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extras#]
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#]<#>[a-z]+ __ <verb><w_regular>[#extras#]*[\:]+<w_regular>[#alphachar#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#])

$tstlexicon$ = <n64316><#>lu<verb><w_regular><ml>\:\:<w_regular> (w<1st><sg><fut><indic><act> |\
  a<1st><sg><aor><indic><act> \
)



$tstlexicon$ || $2nd_3rd_pp$
