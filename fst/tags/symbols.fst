#include "stemtypes.fst"

% Start with noun morphology:
#gender# = <masc><fem><neut>
#case# = <nom><acc><gen><dat><voc>
#number# = <sg><pl>

#morph# =  #gender# #case# #number#

#tag# = #morph#


$gender$ = [#gender#]
$case$ = [#case#]
$number$ = [#number#]

$tag$ = [#tag#]

$=gender$ = [#gender#]
$=case$ = [#case#]
$=number$ = [#number#]

$=stemtype$ = [#stemtype#]

$separator$ = {\:\:}:<>
