%seq.fst: string together both princ. part and augment% princpart.fst



$toylexicon$ = <n64316>lu[<aor><pres>]

#ltr# = a-z
#urn# = <n64316>
#tag# = <pres><aor>
#smooth# =  \)
#rough# = \(
#breathing# = #smooth# #rough#

% Distinguish tenses taking augment from those that do not
#not_2ndpp# = <pres>
% Distinguish tenses taking augment from those that do not
#not_augmented# = <pres>




%%%%%%%%%%%%%%%%%%%% Handle augment as needed %%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Use an agreement variable to expand stem with "s"
% when followed by tag <aor>
#=ltr# = a-z
ALPHABET = [#ltr#]  [#breathing#] [#tag#] [#urn#]
$2ndpp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> (__ <aor>)

% Pass 1st princ. part through unchanged.
% Exclude aor. tense analyses:
ALPHABET = [#ltr#]  [#breathing#] [#tag#] [#urn#]
$1stpp$ = [#urn#] [#ltr#]+ [#not_2ndpp#]

$princpart$ = ($1stpp$ | $2ndpp$)







%%%%%%%%%%%% Modify stem of regular verbs to form principal parts %%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Use an agreement variable to expand stem with augment
% when followed by tag <aor>
#=ltr# = a-z
ALPHABET = [#ltr#] [#tag#] [#urn#] [#breathing#]
$augmented$ = {[#=ltr#]}:{e\)[#=ltr#]} ^-> ([#urn#] __ [a-z]+ <aor>)

% Pass other tenses through unchanged.
ALPHABET = [#ltr#] [#tag#] [#urn#]  [#breathing#]
$unaugmented$ = [#urn#] [#ltr#]+ [#not_augmented#]

$augment$ = ($augmented$ | $unaugmented$)



%%%%%%%%%%%% Final pipeline %%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% Format for final display:
ALPHABET = [#ltr#]  [#breathing#] [#tag#]:<> [#urn#]:<>
$striptag$ = .*


$toylexicon$ || $princpart$ || $augment$ || $striptag$
