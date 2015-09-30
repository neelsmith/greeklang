% imperative.fst
% Inflectional patterns for imperative mood of regular omega verbs
%

% Present and future indicative endings:
$w_pres_imptv_ending$ = <w_regular> ( \
    w<1st><sg>[<pres><fut>]<imptv><act> |\
    eis<2nd><sg>[<pres><fut>]<imptv><act> |\
    ei<3rd><sg>[<pres><fut>]<imptv><act> |\
    omen<1st><pl>[<pres><fut>]<imptv><act> |\
    ete<2nd><pl>[<pres><fut>]<imptv><act> |\
    ousi<3rd><pl>[<pres><fut>]<imptv><act> |\
    \
    omai<1st><sg>[<pres><fut>]<imptv>[<mid><pass>] |\
    ei<2nd><sg>[<pres><fut>]<imptv>[<mid><pass>] |\
    etai<3rd><sg>[<pres><fut>]imptv>[<mid><pass>] |\
    omeqa<1st><pl>[<pres><fut>]<imptv>[<mid><pass>] |\
    esqe<2nd><pl>[<pres><fut>]<imptv>[<mid><pass>] |\
    ontai<3rd><pl>[<pres><fut>]<imptv>[<mid><pass>]  \
    \
)


$w_imperative$ = ($w_pres_imptv_ending$  )


$w_imperative$
