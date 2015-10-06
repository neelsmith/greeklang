% redup.fst:  snippet implementing reduplication
% How to use a "replace" construction with the ^-> operator
%



#ltr# = a-z
#urn# = <n64316>
#tag# = <pres><aor><pft><plupft>

$toylexicon$ = <n64316>lu[<pres><pft><plupft><aor>]

% in reality, have to accont for both
% tense AND mood, but test snippet here on tense

#redupetense# = <pft><plupft>
#noredupetense# = <pres><aor>

#not_augmented# = <pres><pft>
#augmented# = <aor><plupft>


%%%%%%%%%%%%% Handle augment %%%%%%%%%%%%%%%%%%%
%
% Use an agreement variable to expand stem with augment
% when followed by tag <aor>
#=ltr# = a-z
ALPHABET = [#ltr#] [#tag#] [#urn#]
$augmented$ = {[#=ltr#]}:{e[#=ltr#]} ^-> ([#urn#] __ [a-z]+ [#augmented#])


% Pass other tenses through unchanged.
ALPHABET = [#ltr#] [#tag#] [#urn#]
$unaugmented$ = [#urn#] [#ltr#]+ [#not_augmented#]

$augment$ = ($augmented$ | $unaugmented$)




%%%%%%%%%%%%% Handle reduplication %%%%%%%%%%%%%%%%%%%
%
#=ltr2# = a-z
ALPHABET = [#ltr#] [#tag#] [#urn#]
$redup$ = {[#=ltr2#]}:{[#=ltr2#]e[#=ltr2#]} ^-> ([#urn#] __ [a-z]+ [#redupetense#])

ALPHABET = [#ltr#] [#tag#] [#urn#]
$noredup$ = [#urn#] [#ltr#]+ [#noredupetense#]


$reduplication$ = ($redup$ | $noredup$)


%%%%%%%%%%%%% Format for final display %%%%%%%%%%%%%%%%%%%
%
ALPHABET = [#ltr#] [#tag#]:<> [#urn#]:<>
$striptag$ = .*

$toylexicon$ ||  $reduplication$ || $augment$ || $striptag$

%$toylexicon$  || $augment$ || $striptag$
