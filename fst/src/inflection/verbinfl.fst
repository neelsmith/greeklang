% verbinfl.fst
% Verbal inflection patterns

% Present indicative:
$w_pres_indic_ending$ = <w_regular> ( \
    w<1st><sg><pres><indic><act> |\
    eis<2nd><sg><pres><indic><act> |\
    ei<3rd><sg><pres><indic><act> |\
    omen<1st><sg><pres><indic><act> |\
    ete<2nd><sg><pres><indic><act> |\
    ousi<3rd><sg><pres><indic><act> |\
    \
    omai<1st><sg><pres><indic><mid> |\
    ei<2nd><sg><pres><indic><mid> |\
    etai<3rd><sg><pres><indic><mid> |\
    omeqa<1st><sg><pres><indic><mid> |\
    esqe<2nd><sg><pres><indic><mid> |\
    ontai<3rd><sg><pres><indic><mid> |\
    \
    omai<1st><sg><pres><indic><pass> |\
    ei<2nd><sg><pres><indic><pass> |\
    etai<3rd><sg><pres><indic><pass> |\
    omeqa<1st><sg><pres><indic><pass> |\
    esqe<2nd><sg><pres><indic><pass> |\
    ontai<3rd><sg><pres><indic><pass> \
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
$w_regular_endings$ = ($aor1_actmid_ending$ | $w_pres_indic_ending$ | $w_imperfect_ending$ )

$verbinfl$ = $w_regular_endings$

$verbinfl$
