% optative.fst
% Inflectional patterns for optative mood of regular omega verbs
%

% Present and future indicative endings:
$w_pres_opt_ending$ = <w_regular> ( \
    w<1st><sg>[<pres><fut>]<opt><act> |\
    eis<2nd><sg>[<pres><fut>]<opt><act> |\
    ei<3rd><sg>[<pres><fut>]<opt><act> |\
    omen<1st><pl>[<pres><fut>]<opt><act> |\
    ete<2nd><pl>[<pres><fut>]<opt><act> |\
    ousi<3rd><pl>[<pres><fut>]<opt><act> |\
    \
    omai<1st><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    ei<2nd><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    etai<3rd><sg>[<pres><fut>]opt>[<mid><pass>] |\
    omeqa<1st><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    esqe<2nd><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    ontai<3rd><pl>[<pres><fut>]<opt>[<mid><pass>]  \
    \
)


$w_optative$ = ( $w_pres_opt_ending$ )


$w_optative$
