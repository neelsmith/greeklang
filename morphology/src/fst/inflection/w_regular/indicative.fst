% indicative.fst
% Inflectional patterns for indicative mood of regular omega verbs
%
% Currently includes pres, impft, fut, aor and perf in all 3 voices.
%
% Pluperfect, fut. perfect not yet added
%

% Present and future indicative endings:
$w_presfut_indic_ending$ = <w_regular> ( \
    <w_indicative.1>w<1st><sg>[<pres><fut>]<indic><act> |\
    <w_indicative.2>eis<2nd><sg>[<pres><fut>]<indic><act> |\
    <w_indicative.3>ei<3rd><sg>[<pres><fut>]<indic><act> |\
    <w_indicative.4>omen<1st><pl>[<pres><fut>]<indic><act> |\
    <w_indicative.5>ete<2nd><pl>[<pres><fut>]<indic><act> |\
    <w_indicative.6>ousi<3rd><pl>[<pres><fut>]<indic><act> |\
    \
    <w_indicative.7>omai<1st><sg>[<pres><fut>]<indic><mid> |\
    <w_indicative.8>ei<2nd><sg>[<pres><fut>]<indic><mid> |\
    <w_indicative.9>etai<3rd><sg>[<pres><fut>]indic><mid> |\
    <w_indicative.10>omeqa<1st><pl>[<pres><fut>]<indic><mid> |\
    <w_indicative.11>esqe<2nd><pl>[<pres><fut>]<indic><mid> |\
    <w_indicative.12>ontai<3rd><pl>[<pres><fut>]<indic><mid>  |\
    \
    <w_indicative.67>hsomai<1st><sg><fut><indic><pass> |\
    <w_indicative.68>hsei<2nd><sg><fut><indic><pass> |\
    <w_indicative.69>hsetai<3rd><sg><fut><indic><pass> |\
    <w_indicative.70>hsomeqa<1st><pl><fut><indic><pass> |\
    <w_indicative.71>hsesqe<2nd><pl><fut><indic><pass> |\
    <w_indicative.72>hsontai<3rd><pl><fut><indic><pass> \
)

% Imperfect indicative:
$w_imperfect_ending$ = <w_regular> ( \
    <w_indicative.13>on<1st><sg><impft><indic><act> |\
    <w_indicative.14>es<2nd><sg><impft><indic><act> |\
    <w_indicative.15>e<3rd><sg><impft><indic><act> |\
    <w_indicative.16>omen<1st><pl><impft><indic><act> |\
    <w_indicative.17>ete<2nd><pl><impft><indic><act> |\
    <w_indicative.18>on<3rd><pl><impft><indic><act> |\
    \
    <w_indicative.19>omhn<1st><sg><impft><indic>[<mid><pass>] |\
    <w_indicative.20>ou<2nd><sg><impft><indic>[<mid><pass>] |\
    <w_indicative.21>eto<3rd><sg><impft><indic>[<mid><pass>] |\
    <w_indicative.22>omeqa<1st><pl><impft><indic>[<mid><pass>] |\
    <w_indicative.23>esqe<2nd><pl><impft><indic>[<mid><pass>] |\
    <w_indicative.24>onto<3rd><pl><impft><indic>[<mid><pass>] \
    \
)


% First aorist
$aor1_indic_ending$ = <w_regular> ( \
    <w_indicative.25>a<1st><sg><aor><indic><act> |\
    <w_indicative.26>as<2nd><sg><aor><indic><act> |\
    <w_indicative.27>e<3rd><sg><aor><indic><act> |\
    <w_indicative.28>amen<1st><pl><aor><indic><act> |\
    <w_indicative.29>ate<2nd><pl><aor><indic><act> |\
    <w_indicative.30>an<3rd><pl><aor><indic><act> |\
    \
    <w_indicative.31>amhn<1st><sg><aor><indic><mid> |\
    <w_indicative.32>w<2nd><sg><aor><indic><mid> |\
    <w_indicative.33>ato<3rd><sg><aor><indic><mid> |\
    <w_indicative.34>ameqa<1st><pl><aor><indic><mid> |\
    <w_indicative.35>asqe<2nd><pl><aor><indic><mid> |\
    <w_indicative.36>anto<3rd><pl><aor><indic><mid> |\
    \
    <w_indicative.37>hn<1st><sg><aor><indic><pass> |\
    <w_indicative.38>hs<2nd><sg><aor><indic><pass> |\
    <w_indicative.39>h<3rd><sg><aor><indic><pass> |\
    <w_indicative.40>hmen<1st><pl><aor><indic><pass> |\
    <w_indicative.41>hte<2nd><pl><aor><indic><pass> |\
    <w_indicative.42>hsan<3rd><pl><aor><indic><pass> \
    \
)


% Perfect act, mid, passive:
$pft_indic_ending$ = <w_regular> ( \
    <w_indicative.43>a<1st><sg><pft><indic><act> |\
    <w_indicative.44>as<2nd><sg><pft><indic><act> |\
    <w_indicative.45>e<3rd><sg><pft><indic><act> |\
    <w_indicative.46>amen<1st><pl><pft><indic><act> |\
    <w_indicative.47>ate<2nd><pl><pft><indic><act> |\
    <w_indicative.48>asi<3rd><pl><pft><indic><act> |\
    \
    <w_indicative.49>mai<1st><sg><pft><indic>[<mid><pass>] |\
    <w_indicative.50>sai<2nd><sg><pft><indic>[<mid><pass>] |\
    <w_indicative.51>tai<3rd><sg><pft>indic>[<mid><pass>] |\
    <w_indicative.52>meqa<1st><pl><pft><indic>[<mid><pass>] |\
    <w_indicative.53>sqe<2nd><pl><pft><indic>[<mid><pass>] |\
    <w_indicative.54>ntai<3rd><pl><pft><indic>[<mid><pass>]  \
    \
)


% Pluperfect act, mid, passive:
$plupft_indic_ending$ = <w_regular> ( \
  <w_indicative.55>h<1st><sg><plupft><indic><act> |\
  <w_indicative.56>hs<2nd><sg><plupft><indic><act> |\
  <w_indicative.57>ei<3rd><sg><plupft><indic><act> |\
  <w_indicative.58>emen<1st><pl><plupft><indic><act> |\
  <w_indicative.59>ete<2nd><pl><plupft><indic><act> |\
  <w_indicative.60>esan<3rd><pl><plupft><indic><act> |\
  \
  <w_indicative.61>mhn<1st><sg><plupft><indic>[<mid><pass>] |\
  <w_indicative.62>so<2nd><sg><plupft><indic>[<mid><pass>] |\
  <w_indicative.63>to<3rd><sg><plupft><indic>[<mid><pass>] |\
  <w_indicative.64>meqa<1st><pl><plupft><indic>[<mid><pass>] |\
  <w_indicative.65>sqe<2nd><pl><plupft><indic>[<mid><pass>] |\
  <w_indicative.66>nto<3rd><pl><plupft><indic>[<mid><pass>] \
)

$w_indicative$ = ( $w_presfut_indic_ending$ | $w_imperfect_ending$ | $aor1_indic_ending$ | $pft_indic_ending$ | $plupft_indic_ending$)


$w_indicative$
