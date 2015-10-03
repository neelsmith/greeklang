%verbs.fst Verb morphology snippet
% Analysis of conjugated verbal forms following the sequence:
% 1. get/generate princ. part
% 2. check for reduplication
% 3. check for augment
% 4. generically apply endings

#include "phonology.fst"
#include "morphsymbols.fst"
#include "stemtypes.fst"


% toy data set
#urn# = <n64316>
$urn$ = [#urn#]
#extratag# = <ml>
$extratag$ = [#extratag#]
$toylexicon$ = <n64316><#>lu<verb><w_regular><ml>
% do one indic for each princ.part and toss in a couple
% of subjunctives for good measure:
$toyending$ = <w_regular> ( w<1st><sg><pres>[<indic><subj>]<act> |\
  w<1st><sg><fut><indic><act> |\
  a<1st><sg><aor><indic><act> |\
  a<1st><sg><perf><indic><act> |\
  h<1st><sg><plupft><indic><act> \
 )




%%%%%%%% Basic verb acceptor joins stems and inflectional patterns %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
% #character# is defined in "phonology.fst"
#nonmorph# = #character# #extratag#
$nonmorph$ = [#nonmorph#]

% all defined in morphsymbol.fst
$=verbclass$ = [#verbclass#]
$person$ = [#person#]
$number$ = [#number#]
$tense$ = [#tense#]
$mood$ = [#mood#]
$voice$ = [#voice#]

$verbacceptor$ =  $urn$ $nonmorph$+ <verb> $=verbclass$  $extratag$* $separator$+ $=verbclass$ $nonmorph$* $person$ $number$ $tense$ $mood$ $voice$ $nonmorph$*


% example of accepted verb id:
% <n64316><#>lu<verb><w_regular><ml>::<w_regular>w<1st><sg><pres><indic><act>




%%%%%%%%  Format for final display: %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Surface form composed solely of alphabetic characters (including accents and
% diacritics in the alphabet)
ALPHABET = [#alphacharacter#] [#editorial#]:<>  [#morphtag#]:<> [#urn#]:<> [#separator#]:<> [#verbclass#]:<> [#extratag#]:<>
$striptag$ = .*



%%%%%%%%%% Snippet test
% the simple mophology formula
$morph$ = $toylexicon$ \:\: $toyending$

% the final verb pipeline
$morph$   || $verbacceptor$  || $striptag$
