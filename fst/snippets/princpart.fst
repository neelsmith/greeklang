% princpart.fst
% How to use a "replace" construction with the ^-> operator
%


%$toylexicon$ = <n64316>lu<aor> | <n64316>lu<pres>

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

$toylexicon$ || $princpart$ || $striptag$
