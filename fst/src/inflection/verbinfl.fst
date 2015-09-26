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


$w_imperfect_ending$ = <w_regular> ( \
    on<1st><sg><impft><indic><act> |\
    es<2nd><sg><impft><indic><act> |\
    e<3rd><sg><impft><indic><act> |\
    omen<1st><sg><impft><indic><act> |\
    ete<2nd><sg><impft><indic><act> |\
    on<3rd><sg><impft><indic><act> \
)

$w_regular_endings$ = $w_pres_indic_ending$ | $w_imperfect_ending$


$verbinfl$ = $w_regular_endings$

$verbinfl$
