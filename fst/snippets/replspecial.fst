%How to replace special chars like :



#ltr# = a-z
#urn# = <n64316>
#tense# = <pres><impft><aor><pft><plupft><fut><futpft>
#smooth# =  \)
#rough# = \(
#breathing# = #smooth# #rough#

#augmenttense# = <aor><impft><plupft>
#not_augmented# = <pres><fut><pft><futpft>



% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense
#=ltr# = a-z


ALPHABET = [#ltr#] [#tense#] [#urn#] [#breathing#] [\:]
$augmented$ = {[#=ltr#]}:{e\)[#=ltr#]} ^-> ([#urn#] __ [a-z]+\:[#augmenttense#])

$tstlexicon$ = <n64316>lu\:[#tense#]




$tstlexicon$ || $augmented$
