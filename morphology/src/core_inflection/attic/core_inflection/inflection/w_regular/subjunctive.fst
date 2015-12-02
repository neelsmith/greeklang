% subjunctive.fst
% Inflectional patterns for subunctive mood of regular omega verbs
%

% Present, aorist, perfect subjunctive endings:
$w_presaorpft_subj_ending$ = <w_regular> ( \
    <w_subjunctive.1>w<1st><sg>[<pres><aor><pft>]<subj><act> |\
    <w_subjunctive.2>h\|s<2nd><sg>[<pres><aor><pft>]<subj><act> |\
    <w_subjunctive.3>h\|<3rd><sg>[<pres><aor><pft>]<subj><act> |\
    <w_subjunctive.4>wmen<1st><pl>[<pres><aor><pft>]<subj><act> |\
    <w_subjunctive.5>hte<2nd><pl>[<pres><aor><pft>]<subj><act> |\
    <w_subjunctive.6>wsi<3rd><pl>[<pres><aor><pft>]<subj><act> |\
    \
    <w_subjunctive.7>wmai<1st><sg>[<pres><aor>]<subj>[<mid><pass>] |\
    <w_subjunctive.8>h\|<2nd><sg>[<pres><aor>]<subj>[<mid><pass>] |\
    <w_subjunctive.9>htai<3rd><sg>[<pres><aor>]<subj>[<mid><pass>] |\
    <w_subjunctive.10>wmeqa<1st><pl>[<pres><aor>]<subj>[<mid><pass>] |\
    <w_subjunctive.11>hsqe<2nd><pl>[<pres><aor>]<subj>[<mid><pass>] |\
    <w_subjunctive.12>wntai<3rd><pl>[<pres><aor>]<subj>[<mid><pass>]  \
    \
)

$w_subjunctive$ = ( $w_presaorpft_subj_ending$ )


$w_subjunctive$
