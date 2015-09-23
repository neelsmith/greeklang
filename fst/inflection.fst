%% inflection.fst

$is_ios_ending$ = <is_ios>
(is<nom><sg>|\
i<voc><sg>|\
in<acc><sg>)


$hs_ou_ending$ = <hs_ou> (hs[<nom><voc>]<sg> )

$ending$ = $is_ios_ending$ | $hs_ou_ending

$ending$
