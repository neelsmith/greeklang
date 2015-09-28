%seq.fst: string together both princ. part and augment% princpart.fst



$toylexicon$ = <n64316>lu[<aor><pres>]

#ltr# = a-z
#urn# = <n64316>
#tag# = <pres><aor>

#not_aorist# = <pres>

% Use an agreement variable to expand stem with "s"
% when followed by tag <aor>
#=ltr# = a-z
ALPHABET = [#ltr#] [#tag#] [#urn#]
$2ndpp$ = {[#=ltr#]}:{[#=ltr#]s} ^-> (__ <aor>)

% Pass 1st princ. part through unchanged.
% Exclude aor. tense analyses:
ALPHABET = [#ltr#] [#tag#] [#urn#]
$1stpp$ = [#urn#] [#ltr#]+ [#not_aorist#]

$princpart$ = ($1stpp$ | $2ndpp$)

% Format for final display:
ALPHABET = [#ltr#] [#tag#]:<> [#urn#]:<>
$striptag$ = .*





% Distinguish tenses taking augment from those that do not
#not_augmented# = <pres>

% Use an agreement variable to expand stem with augment
% when followed by tag <aor>
#=ltr# = a-z
ALPHABET = [#ltr#] [#tag#] [#urn#]
$augmented$ = {[#=ltr#]}:{e[#=ltr#]} ^-> ([#urn#] __ [a-z]+ <aor>)

% Pass other tenses through unchanged.
ALPHABET = [#ltr#] [#tag#] [#urn#]
$unaugmented$ = [#urn#] [#ltr#]+ [#not_augmented#]

$augment$ = ($augmented$ | $unaugmented$)

$toylexicon$ || $princpart$ || $augment$ || $striptag$
