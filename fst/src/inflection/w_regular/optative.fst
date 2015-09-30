% optative.fst
% Inflectional patterns for optative mood of regular omega verbs
%

% Present and future indicative endings:
$w_presfut_opt_ending$ = <w_regular> ( \
    oimi<1st><sg>[<pres><fut>]<opt><act> |\
    ois<2nd><sg>[<pres><fut>]<opt><act> |\
    oi<3rd><sg>[<pres><fut>]<opt><act> |\
    oimen<1st><pl>[<pres><fut>]<opt><act> |\
    oite<2nd><pl>[<pres><fut>]<opt><act> |\
    oien<3rd><pl>[<pres><fut>]<opt><act> |\
    \
    oimhn<1st><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    oio<2nd><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    oito<3rd><sg>[<pres><fut>]opt>[<mid><pass>] |\
    oimeqa<1st><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    oisqe<2nd><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    ointo<3rd><pl>[<pres><fut>]<opt>[<mid><pass>]  \
    \
)


$w_optative$ = ( $w_presfut_opt_ending$ )


$w_optative$
