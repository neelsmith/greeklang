% subjunctive.fst
% Inflectional patterns for subunctive mood of regular omega verbs
%

% Present and future indicative endings:
$w_pres_subj_ending$ = <w_regular> ( \
    w<1st><sg><pres><subj><act> |\
    h\|s<2nd><sg><pres><subj><act> |\
    h\|<3rd><sg><pres><subj><act> |\
    wmen<1st><pl><pres><subj><act> |\
    hte<2nd><pl><pres><subj><act> |\
    wsi<3rd><pl><pres><subj><act> |\
    \
    wmai<1st><sg><pres><subj>[<mid><pass>] |\
    h\|<2nd><sg><pres><subj>[<mid><pass>] |\
    htai<3rd><sg><pres><subj>[<mid><pass>] |\
    wmeqa<1st><pl><pres><subj>[<mid><pass>] |\
    hsqe<2nd><pl><pres><subj>[<mid><pass>] |\
    wntai<3rd><pl><pres><subj>[<mid><pass>]  \
    \
)


$w_subjunctive$ = ( $w_pres_subj_ending$ )


$w_subjunctive$
