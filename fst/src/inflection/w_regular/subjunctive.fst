% subjunctive.fst
% Inflectional patterns for subunctive mood of regular omega verbs
%

% Present and aorist subjunctive endings:
$w_presaor_subj_ending$ = <w_regular> ( \
    w<1st><sg>[<pres><aor>]<subj><act> |\
    h\|s<2nd><sg>[<pres><aor>]<subj><act> |\
    h\|<3rd><sg>[<pres><aor>]<subj><act> |\
    wmen<1st><pl>[<pres><aor>]<subj><act> |\
    hte<2nd><pl>[<pres><aor>]<subj><act> |\
    wsi<3rd><pl>[<pres><aor>]<subj><act> |\
    \
    wmai<1st><sg>[<pres><aor>]<subj>[<mid><pass>] |\
    h\|<2nd><sg>[<pres><aor>]<subj>[<mid><pass>] |\
    htai<3rd><sg>[<pres><aor>]<subj>[<mid><pass>] |\
    wmeqa<1st><pl>[<pres><aor>]<subj>[<mid><pass>] |\
    hsqe<2nd><pl>[<pres><aor>]<subj>[<mid><pass>] |\
    wntai<3rd><pl>[<pres><aor>]<subj>[<mid><pass>]  \
    \
)


$w_subjunctive$ = ( $w_presaor_subj_ending$ )


$w_subjunctive$
