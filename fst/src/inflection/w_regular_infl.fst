% w_regular_infl.fst
% Inflectional patterns for regular omega verbs
%
% Currently includes pres, impft, fut, aor and perf in all 3 voices.
%
% Pluperfect, fut. perfect not yet added
%

% Present and future indicative endings:
$w_presfut_indic_ending$ = <w_regular> ( \
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

% Imperfect indicative:
$w_imperfect_ending$ = <w_regular> ( \
    on<1st><sg><impft><indic><act> |\
    es<2nd><sg><impft><indic><act> |\
    e<3rd><sg><impft><indic><act> |\
    omen<1st><pl><impft><indic><act> |\
    ete<2nd><pl><impft><indic><act> |\
    on<3rd><pl><impft><indic><act> |\
    \
    omhn<1st><sg><impft><indic>[<mid><pass>] |\
    ou<2nd><sg><impft><indic>[<mid><pass>] |\
    eto<3rd><sg><impft><indic>[<mid><pass>] |\
    omeqa<1st><pl><impft><indic>[<mid><pass>] |\
    esqe<2nd><pl><impft><indic>[<mid><pass>] |\
    onto<3rd><pl><impft><indic>[<mid><pass>] \
    \
)


% First aorist
$aor1_indic_ending$ = <w_regular> ( \
    a<1st><sg><aor><indic><act> |\
    as<2nd><sg><aor><indic><act> |\
    e<3rd><sg><aor><indic><act> |\
    amen<1st><pl><aor><indic><act> |\
    ate<2nd><pl><aor><indic><act> |\
    an<3rd><pl><aor><indic><act> |\
    \
    amhn<1st><sg><aor><indic><mid> |\
    w<2nd><sg><aor><indic><mid> |\
    ato<3rd><sg><aor><indic><mid> |\
    ameqa<1st><pl><aor><indic><mid> |\
    asqe<2nd><pl><aor><indic><mid> |\
    anto<3rd><pl><aor><indic><mid> |\
    \
    hn<1st><sg><aor><indic><pass> |\
    hs<2nd><sg><aor><indic><pass> |\
    h<3rd><sg><aor><indic><pass> |\
    hmen<1st><pl><aor><indic><pass> |\
    hte<2nd><pl><aor><indic><pass> |\
    hsan<3rd><pl><aor><indic><pass> \
    \
)


% Perfect act, mid, passive:
$pft_indic_ending$ = <w_regular> ( \
    a<1st><sg><pft><indic><act> |\
    as<2nd><sg><pft><indic><act> |\
    e<3rd><sg><pft><indic><act> |\
    amen<1st><pl><pft><indic><act> |\
    ate<2nd><pl><pft><indic><act> |\
    asi<3rd><pl><pft><indic><act> |\
    \
    mai<1st><sg><perf><indic>[<mid><pass>] |\
    sai<2nd><sg><perf><indic>[<mid><pass>] |\
    tai<3rd><sg><perf>indic>[<mid><pass>] |\
    meqa<1st><pl><perf><indic>[<mid><pass>] |\
    sqe<2nd><pl><perf><indic>[<mid><pass>] |\
    ntai<3rd><pl><perf><indic>[<mid><pass>]  \
    \
)

$w_regular_endings$ = ( $w_presfut_indic_ending$ | $w_imperfect_ending$ | $aor1_indic_ending$ | $pft_indic_ending$)

$w_regular_endings$
