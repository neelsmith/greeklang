% optative.fst
% Inflectional patterns for optative mood of regular omega verbs
%

% Present and future indicative endings:
$w_pres_opt_ending$ = <w_regular> ( \
    w<1st><sg>[<pres><fut>]<indic><act> |\
    eis<2nd><sg>[<pres><fut>]<indic><act> |\
    ei<3rd><sg>[<pres><fut>]<indic><act> |\
    omen<1st><pl>[<pres><fut>]<indic><act> |\
    ete<2nd><pl>[<pres><fut>]<indic><act> |\
    ousi<3rd><pl>[<pres><fut>]<indic><act> |\
    \
    omai<1st><sg>[<pres><fut>]<indic>[<mid><pass>] |\
    ei<2nd><sg>[<pres><fut>]<indic>[<mid><pass>] |\
    etai<3rd><sg>[<pres><fut>]indic>[<mid><pass>] |\
    omeqa<1st><pl>[<pres><fut>]<indic>[<mid><pass>] |\
    esqe<2nd><pl>[<pres><fut>]<indic>[<mid><pass>] |\
    ontai<3rd><pl>[<pres><fut>]<indic>[<mid><pass>]  \
    \
)


$w_optative$ = ( $w_pres_opt_ending$ )


$w_optative$
