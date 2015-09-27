% princpart.fst
% How to use a "replace" construction with the ^-> operator
%




#ltr# = a-z
#urn# = <n64316>
#tag# = <pres><aor>

#not_augmented# = <pres>

% Use an agreement variable to expand stem with augment
% when followed by tag <aor>
#=ltr# = a-z
ALPHABET = [#ltr#] [#tag#] [#urn#]
$augmented$ = {[#=ltr#]}:{e[#=ltr#]} ^-> ([#urn#] __ [a-z]+ <aor>)
%$augmented$ = {[#=ltr#]}:{e[#=ltr#]} ^-> ([#urn#] __ )


% Pass other tenses through unchanged.
ALPHABET = [#ltr#] [#tag#] [#urn#]
$unaugmented$ = [#urn#] [#ltr#]+ [#not_augmented#]

$augment$ = ($augmented$ | $unaugmented$)

% Format for final display:
ALPHABET = [#ltr#] [#tag#]:<> [#urn#]:<>
$striptag$ = .*


$toylexicon$ = <n64316>lu<aor> | <n64316>lu<pres>
$toylexicon$  || $augment$ || $striptag$
