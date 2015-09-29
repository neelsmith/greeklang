% Illustrates how to replace special chars like the colon, and how
% to pipe together replacement patterns to generate regular principal parts.
% This example is a transducer for w_regular verbs; parallel transducers
% could handle other regular patterns like contract verbs.



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





% reduplication on 4th and 5th:
#4th_5th_tense# = <pft><plupft><futpft>

% also -kappa on 4th
#kappatense# = <pft>




% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense
#=ltr# = a-z

% Extend second and third principal parts with sigma:
ALPHABET = [#alphachar#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extras#]
$2nd_3rd_pp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> ([#urn#]<#>[a-z]+ __ <verb><w_regular>[#extras#]*[\:]+<w_regular>[#alphachar#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#2nd_3rd_voice#])


% Extend 6th principal part with theta:
ALPHABET = [#alphachar#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extras#]
$6th_pp$ = {[#=ltr#]}:{[#=ltr#]q} ^-> ([#urn#]<#>[a-z]+ __ <verb><w_regular>[#extras#]*[\:]+<w_regular>[#alphachar#]*[#person#][#number#][#2nd_3rd_6th_tense#][#mood#][#6th_voice#])

% Add reduplication on 4th and 5th parts:
ALPHABET = [#alphachar#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extras#]
$redupe$ = {[#=ltr#]}:{[#=ltr#]e[#=ltr#]} ^-> ([#urn#]<#> __ [a-z]+<verb><w_regular>[#extras#]*[\:]+<w_regular>[#alphachar#]*[#person#][#number#][#4th_5th_tense#])

% Add kappa to 4th only: restrict to active voice.
ALPHABET = [#alphachar#] [#morphtag#] [#urn#] [\:] [<#>] [#stemtype#] [#extras#]
$kappa$ = {[#=ltr#]}:{[#=ltr#]k} ^-> ([#urn#]<#>[a-z]+ __ <verb><w_regular>[#extras#]*[\:]+<w_regular>[#alphachar#]*[#person#][#number#][#4th_5th_tense#][#mood#]<act>)


% Formatting for final display
ALPHABET = [#alphachar#] [#morphtag#]:<> [#urn#]:<> [\:]:<> [<#>]:<> [#stemtype#]:<> [#extras#]:<>
$striptag$ = .*

$synoptic$ = <n64316><#>lu<verb><w_regular><ml>\:\:<w_regular> ( \
  w<1st><sg><pres><indic><act> |\
  omai<1st><sg><pres><indic><mid> |\
  a<1st><sg><aor><indic><act> |\
  amhn<1st><sg><aor><indic><mid> |\
  w<1st><sg><fut><indic><act> |\
  omai<1st><sg><fut><indic><mid> |\
  omai<1st><sg><fut><indic><mid> |\
  hsomai<1st><sg><fut><indic><pass> |\
  hn<1st><sg><aor><indic><pass> |\
  a<1st><sg><pft><indic><act> |\
  mai<1st><sg><pft><indic><pass> \
)



$4th_5th_pp$ =  $redupe$ || $kappa$

$synoptic$ ||  $2nd_3rd_pp$ || $4th_5th_pp$  || $6th_pp$ || $striptag$
