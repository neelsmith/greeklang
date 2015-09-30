% w_regular_infl.fst
% Inflectional patterns for regular omega verbs

% Present indicative:
$w_presfut_indic_ending$ = <w_regular> ( \
    w<1st><sg>[<pres><fut>]<indic><act> |\
    eis<2nd><sg>[<pres><fut>]<indic><act> |\
    ei<3rd><sg>[<pres><fut>]<indic><act> |\
    omen<1st><sg>[<pres><fut>]<indic><act> |\
    ete<2nd><sg>[<pres><fut>]<indic><act> |\
    ousi<3rd><sg>[<pres><fut>]<indic><act> |\
    \
    omai<1st><sg>[<pres><fut>]<indic><mid> |\
    ei<2nd><sg>[<pres><fut>]<indic><mid> |\
    etai<3rd><sg>[<pres><fut>]indic><mid> |\
    omeqa<1st><sg>[<pres><fut>]<indic><mid> |\
    esqe<2nd><sg>[<pres><fut>]<indic><mid> |\
    ontai<3rd><sg>[<pres><fut>]<indic><mid> \
    \
    omai<1st><sg>[<pres><fut>]<indic><pass> |\
    ei<2nd><sg>[<pres><fut>]<indic><pass> |\
    etai<3rd><sg>[<pres><fut>]<indic><pass> |\
    omeqa<1st><sg>[<pres><fut>]<indic><pass> |\
    esqe<2nd><sg>[<pres><fut>]<indic><pass> |\
    ontai<3rd><sg>[<pres><fut>]<indic><pass> \
)



% Imperfect indicative:
$w_imperfect_ending$ = <w_regular> ( \
    on<1st><sg><impft><indic><act> |\
    es<2nd><sg><impft><indic><act> |\
    e<3rd><sg><impft><indic><act> |\
    omen<1st><sg><impft><indic><act> |\
    ete<2nd><sg><impft><indic><act> |\
    on<3rd><sg><impft><indic><act> |\
    \
    omhn<1st><sg><impft><indic><mid> |\
    ou<2nd><sg><impft><indic><mid> |\
    eto<3rd><sg><impft><indic><mid> |\
    omeqa<1st><sg><impft><indic><mid> |\
    esqe<2nd><sg><impft><indic><mid> |\
    onto<3rd><sg><impft><indic><mid> |\
    \
    omhn<1st><sg><impft><indic><pass> |\
    ou<2nd><sg><impft><indic><pass> |\
    eto<3rd><sg><impft><indic><pass> |\
    omeqa<1st><sg><impft><indic><pass> |\
    esqe<2nd><sg><impft><indic><pass> |\
    onto<3rd><sg><impft><indic><pass> \
)


% Aor act and mid:
$aor1_actmid_ending$ = <w_regular> ( \
    a<1st><sg><aor><indic><act> |\
    as<2nd><sg><aor><indic><act> |\
    e<3rd><sg><aor><indic><act> |\
    amen<1st><sg><aor><indic><act> |\
    ate<2nd><sg><aor><indic><act> |\
    an<3rd><sg><aor><indic><act> |\
    \
    amhn<1st><sg><aor><indic><mid> |\
    w<2nd><sg><aor><indic><mid> |\
    ato<3rd><sg><aor><indic><mid> |\
    ameqa<1st><sg><aor><indic><mid> |\
    asqe<2nd><sg><aor><indic><mid> |\
    anto<3rd><sg><aor><indic><mid> \
    \
)


% Aor act and mid:
$pft_act_ending$ = <w_regular> ( \
    a<1st><sg><pft><indic><act> |\
    as<2nd><sg><pft><indic><act> |\
    e<3rd><sg><pft><indic><act> |\
    amen<1st><sg><pft><indic><act> |\
    ate<2nd><sg><pft><indic><act> |\
    asi<3rd><sg><pft><indic><act> \
)

$w_regular_endings$ = ( $w_presfut_indic_ending$ | $w_imperfect_ending$ | $aor1_actmid_ending$ | $pft_act_ending$)

$w_regular_endings$
