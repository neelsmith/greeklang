% optative.fst
% Inflectional patterns for optative mood of regular omega verbs
%

% Present and future indicative endings:
$w_presfut_opt_ending$ = <w_regular> ( \
    oimi<1st><sg>[<pres><fut><pft>]<opt><act> |\
    oihn<1st><sg><pft><opt><act> |\
    ois<2nd><sg>[<pres><fut><pft>]<opt><act> |\
    oihs<2nd><sg><pft><opt><act> |\
    oi<3rd><sg>[<pres><fut><pft>]<opt><act> |\
    oih<3rd><sg><pft><opt><act> |\
    oimen<1st><pl>[<pres><fut><pft>]<opt><act> |\
    oite<2nd><pl>[<pres><fut><pft>]<opt><act> |\
    oien<3rd><pl>[<pres><fut><pft>]<opt><act> |\
    \
    oimhn<1st><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    oio<2nd><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    oito<3rd><sg>[<pres><fut>]opt>[<mid><pass>] |\
    oimeqa<1st><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    oisqe<2nd><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    ointo<3rd><pl>[<pres><fut>]<opt>[<mid><pass>]  \
    \
)
$w_aor_opt_ending$ = <w_regular> ( \
    aimi<1st><sg>[<pres><fut>]<opt><act> |\
    ais<2nd><sg>[<pres><fut>]<opt><act> |\
    eias<2nd><sg>[<pres><fut>]<opt><act> |\
    ai<3rd><sg>[<pres><fut>]<opt><act> |\
    eie<3rd><sg>[<pres><fut>]<opt><act> |\
    aimen<1st><pl>[<pres><fut>]<opt><act> |\
    aite<2nd><pl>[<pres><fut>]<opt><act> |\
    aien<3rd><pl>[<pres><fut>]<opt><act> |\
    eian<3rd><pl>[<pres><fut>]<opt><act> |\
    \
    aimhn<1st><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    aio<2nd><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    aito<3rd><sg>[<pres><fut>]opt>[<mid><pass>] |\
    aimeqa<1st><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    aisqe<2nd><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    ainto<3rd><pl>[<pres><fut>]<opt>[<mid><pass>]  \
    \
)

$w_optative$ = ( $w_presfut_opt_ending$ | $w_aor_opt_ending$)


$w_optative$
