% imperative.fst
% Inflectional patterns for imperative mood of regular omega verbs
%

% Present and future indicative endings:
$w_pres_imptv_ending$ = <w_regular> ( \
    e<2nd><sg><pres><imptv><act> |\
    etw<3rd><sg><pres><imptv><act> |\
    ete<2nd><pl><pres><imptv><act> |\
    ontwn<3rd><pl><pres><imptv><act> |\
    \
    ou<2nd><sg><pres><imptv>[<mid><pass>] |\
    esqw<3rd><sg><pres><imptv>[<mid><pass>] |\
    esqe<2nd><pl><pres><imptv>[<mid><pass>] |\
    esqwn<3rd><pl><pres><imptv>[<mid><pass>] \
    \
)


$w_imperative$ = ($w_pres_imptv_ending$  )


$w_imperative$
