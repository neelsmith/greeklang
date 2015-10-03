% princpart.fst
% How to use a "replace" construction with the ^-> operator
%




#ltr# = a-z
#urn# = <n64316>
#tag# = <pres><impft><aor><pft><plupft><fut><futpft>
#smooth# =  \)
#rough# = \(
#breathing# = #smooth# #rough#

#augmenttense# = <aor><impft><plupft>
#not_augmented# = <pres><fut><pft><futpft>

#tense# = #tag#


%%%%%%%%%%%%%%%%%%%% Handle augment as needed %%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Use an agreement variable to expand stem with augment
% when followed by tag for augmenting tense
#=ltr# = a-z
ALPHABET = [#ltr#] [#tag#] [#urn#] [#breathing#]
$augmented$ = {[#=ltr#]}:{e\)[#=ltr#]} ^-> ([#urn#] __ [a-z]+ [#augmenttense#])

% Pass other tenses through unchanged.
ALPHABET = [#ltr#] [#breathing#][#tag#] [#urn#]
$unaugmented$ = [#urn#] [#ltr#]+ [#not_augmented#]

$augment$ = ($augmented$ | $unaugmented$)


% Format for final display:
ALPHABET = [#ltr#] [#breathing#] [#tag#]:<> [#urn#]:<>
$striptag$ = .*


$toylexicon$ = <n64316>lu[#tense#]
$toylexicon$  || $augment$ || $striptag$
