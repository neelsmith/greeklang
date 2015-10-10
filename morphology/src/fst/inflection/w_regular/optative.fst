% optative.fst
% Inflectional patterns for optative mood of regular omega verbs
%

% Present and future indicative endings:
$w_presfut_opt_ending$ = <w_regular> ( \
    <w_optative.1>oimi<1st><sg>[<pres><fut><pft>]<opt><act> |\
    <w_optative.2>oihn<1st><sg><pft><opt><act> |\
    <w_optative.3>ois<2nd><sg>[<pres><fut><pft>]<opt><act> |\
    <w_optative.4>oihs<2nd><sg><pft><opt><act> |\
    <w_optative.5>oi<3rd><sg>[<pres><fut><pft>]<opt><act> |\
    <w_optative.6>oih<3rd><sg><pft><opt><act> |\
    <w_optative.7>oimen<1st><pl>[<pres><fut><pft>]<opt><act> |\
    <w_optative.8>oite<2nd><pl>[<pres><fut><pft>]<opt><act> |\
    <w_optative.9>oien<3rd><pl>[<pres><fut><pft>]<opt><act> |\
    \
    <w_optative.10>oimhn<1st><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    <w_optative.11>oio<2nd><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    <w_optative.12>oito<3rd><sg>[<pres><fut>]opt>[<mid><pass>] |\
    <w_optative.13>oimeqa<1st><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    <w_optative.14>oisqe<2nd><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    <w_optative.15>ointo<3rd><pl>[<pres><fut>]<opt>[<mid><pass>]  \
    \
)
$w_aor_opt_ending$ = <w_regular> ( \
    <w_optative.16>aimi<1st><sg>[<pres><fut>]<opt><act> |\
    <w_optative.17>ais<2nd><sg>[<pres><fut>]<opt><act> |\
    <w_optative.18>eias<2nd><sg>[<pres><fut>]<opt><act> |\
    <w_optative.19>ai<3rd><sg>[<pres><fut>]<opt><act> |\
    <w_optative.20>eie<3rd><sg>[<pres><fut>]<opt><act> |\
    <w_optative.21>aimen<1st><pl>[<pres><fut>]<opt><act> |\
    <w_optative.22>aite<2nd><pl>[<pres><fut>]<opt><act> |\
    <w_optative.23>aien<3rd><pl>[<pres><fut>]<opt><act> |\
    <w_optative.24>eian<3rd><pl>[<pres><fut>]<opt><act> |\
    \
    <w_optative.25>aimhn<1st><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    <w_optative.26>aio<2nd><sg>[<pres><fut>]<opt>[<mid><pass>] |\
    <w_optative.27>aito<3rd><sg>[<pres><fut>]opt>[<mid><pass>] |\
    <w_optative.28>aimeqa<1st><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    <w_optative.29>aisqe<2nd><pl>[<pres><fut>]<opt>[<mid><pass>] |\
    <w_optative.30>ainto<3rd><pl>[<pres><fut>]<opt>[<mid><pass>]  \
    \
)

$w_optative$ = ( $w_presfut_opt_ending$ | $w_aor_opt_ending$)


$w_optative$
